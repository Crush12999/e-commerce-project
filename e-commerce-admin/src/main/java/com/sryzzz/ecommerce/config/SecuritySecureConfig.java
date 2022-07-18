package com.sryzzz.ecommerce.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author sryzzz
 * @create 2022/7/18 19:31
 * @description 配置安全认证，以便其它的微服务可以注册
 * 参考 Spring Security 官方文档
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    /**
     * 应用上下文路径
     */
    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();

        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                // 配置所有的静态资源和登录页可以公开访问
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                // 其它请求必须经过认证
                .anyRequest().authenticated()
                .and()
                // 配置登录和登出路径
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
                .and()
                .logout().logoutUrl(adminContextPath + "/logout")
                .and()
                // 开启 http basic 支持，其他的服务模块注册时需要使用
                .httpBasic()
                .and()
                // 开启基于 cookie 的 csrf 保护
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                // 忽略这些路径的 csrf 保护以便其它模块可以实现注册
                .ignoringAntMatchers(
                        adminContextPath + "/instances",
                        adminContextPath + "/actuator/**"
                );
    }
}
