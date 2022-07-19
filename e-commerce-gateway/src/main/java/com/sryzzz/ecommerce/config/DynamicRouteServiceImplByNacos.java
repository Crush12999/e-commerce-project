package com.sryzzz.ecommerce.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author sryzzz
 * @create 2022/7/19 15:24
 * @description 通过 nacos 下发动态路由配置, 监听 Nacos 中路由配置变更
 */
@Slf4j
@Component
@DependsOn({"gatewayConfig"})
public class DynamicRouteServiceImplByNacos {

    /**
     * Nacos 配置服务
     */
    private ConfigService configService;

    @Resource
    private DynamicRouteServiceImpl dynamicRouteService;

    /**
     * Bean 在容器中构造完成之后会执行 init 方法
     */
    @PostConstruct
    public void init() {

        log.info("gateway route init....");

        try {
            // 初始化 Nacos 配置客户端
            configService = initConfigService();
            if (configService == null) {
                log.error("init config service fail");
                return;
            }

            // 通过 Nacos Config 并指定路由配置路径去获取路由配置
            String configInfo = configService.getConfig(
                    GatewayConfig.NACOS_ROUTE_DATA_ID,
                    GatewayConfig.NACOS_ROUTE_GROUP,
                    GatewayConfig.DEFAULT_TIMEOUT
            );

            log.info("get current gateway config: [{}]", configInfo);
            List<RouteDefinition> definitionList =
                    JSON.parseArray(configInfo, RouteDefinition.class);

            if (CollectionUtils.isNotEmpty(definitionList)) {
                for (RouteDefinition definition : definitionList) {
                    log.info("init gateway config: [{}]", definition.toString());
                    dynamicRouteService.addRouteDefinition(definition);
                }
            }

        } catch (Exception ex) {
            log.error("gateway route init has some error: [{}]", ex.getMessage(), ex);
        }

        // 设置监听器
        dynamicRouteByNacosListener(GatewayConfig.NACOS_ROUTE_DATA_ID,
                GatewayConfig.NACOS_ROUTE_GROUP);
    }

    /**
     * 初始化 Nacos Config
     */
    private ConfigService initConfigService() {

        try {
            Properties properties = new Properties();
            properties.setProperty("serverAddr", GatewayConfig.NACOS_SERVER_ADDRESS);
            properties.setProperty("namespace", GatewayConfig.NACOS_NAMESPACE);
            return configService = NacosFactory.createConfigService(properties);
        } catch (Exception ex) {
            log.error("init gateway nacos config error: [{}]", ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * 监听 Nacos 下发的动态路由配置
     */
    private void dynamicRouteByNacosListener(String dataId, String group) {

        try {
            // 给 Nacos Config 客户端增加一个监听器
            configService.addListener(dataId, group, new Listener() {

                /**
                 * 自己提供线程池执行操作
                 */
                @Override
                public Executor getExecutor() {
                    return null;
                }

                /**
                 * 监听器收到配置更新
                 * @param configInfo Nacos 中最新的配置定义
                 */
                @Override
                public void receiveConfigInfo(String configInfo) {

                    log.info("start to update config: [{}]", configInfo);
                    List<RouteDefinition> definitionList =
                            JSON.parseArray(configInfo, RouteDefinition.class);
                    log.info("update route: [{}]", definitionList.toString());
                    dynamicRouteService.updateList(definitionList);
                }
            });
        } catch (NacosException ex) {
            log.error("dynamic update gateway config error: [{}]", ex.getMessage(), ex);
        }
    }
}
