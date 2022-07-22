package com.sryzzz.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.sryzzz.ecommerce.account.AddressInfo;
import com.sryzzz.ecommerce.common.TableId;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * @author sryzzz
 * @create 2022/7/22 23:03
 * @description 用户地址相关服务功能测试
 */
@Slf4j
public class AddressServiceTest extends BaseTest {

    @Autowired
    private IAddressService addressService;

    /**
     * 测试创建用户地址信息
     */
    @Test
    public void testCreateAddressInfo() {

        AddressInfo.AddressItem addressItem = new AddressInfo.AddressItem();
        addressItem.setUsername("chuchen");
        addressItem.setPhone("18800000001");
        addressItem.setProvince("深圳市");
        addressItem.setCity("深圳市");
        addressItem.setAddressDetail("宝安区");

        log.info("test create address info: [{}]", JSON.toJSONString(
                addressService.createAddressInfo(
                        new AddressInfo(loginUserInfo.getId(),
                                Collections.singletonList(addressItem))
                )
        ));
    }

    /**
     * 测试获取当前登录用户地址信息
     */
    @Test
    public void testGetCurrentAddressInfo() {

        log.info("test get current user info: [{}]", JSON.toJSONString(
                addressService.getCurrentAddressInfo()
        ));
    }

    /**
     * 测试通过 id 获取用户地址信息
     */
    @Test
    public void testGetAddressInfoById() {

        log.info("test get address info by id: [{}]", JSON.toJSONString(
                addressService.getAddressInfoById(10L)
        ));
    }

    /**
     * 测试通过 TableId 获取用户地址信息
     */
    @Test
    public void testGetAddressInfoByTableId() {

        log.info("test get address info by table id: [{}]", JSON.toJSONString(
                addressService.getAddressInfoByTableId(
                        new TableId(Collections.singletonList(new TableId.Id(11L)))
                )
        ));
    }
}
