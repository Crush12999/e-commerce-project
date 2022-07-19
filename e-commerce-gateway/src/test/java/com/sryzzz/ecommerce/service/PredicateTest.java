package com.sryzzz.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author sryzzz
 * @create 2022/7/19 14:35
 * @description Java8 Predicate 使用方法与思想
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PredicateTest {

    public static List<String> MICRO_SERVICE = Arrays.asList(
            "nacos", "authority", "gateway", "ribbon", "feign", "hystrix", "e-commerce"
    );

    /**
     * 主要用于参数符不符合规则, 返回值是 boolean
     */
    @Test
    public void testPredicateTest() {

        Predicate<String> letterLengthLimit = s -> s.length() > 5;
        MICRO_SERVICE.stream().filter(letterLengthLimit).forEach(System.out::println);
    }

    /**
     * and 方法等同于我们的逻辑与 &&, 存在短路特性, 需要所有的条件都满足
     */
    @Test
    public void testPredicateAnd() {

        Predicate<String> letterLengthLimit = s -> s.length() > 5;
        Predicate<String> letterStartWith = s -> s.startsWith("gate");

        MICRO_SERVICE.stream().filter(
                letterLengthLimit.and(letterStartWith)
        ).forEach(System.out::println);
    }

    /**
     * or 等同于我们的逻辑或 ||, 多个条件主要一个满足即可
     */
    @Test
    public void testPredicateOr() {

        Predicate<String> letterLengthLimit = s -> s.length() > 5;
        Predicate<String> letterStartWith = s -> s.startsWith("gate");

        MICRO_SERVICE.stream().filter(
                letterLengthLimit.or(letterStartWith)
        ).forEach(System.out::println);
    }

    /**
     * negate 等同于我们的逻辑非 !
     */
    @Test
    public void testPredicateNegate() {

        Predicate<String> letterStartWith = s -> s.startsWith("gate");
        MICRO_SERVICE.stream().filter(letterStartWith.negate()).forEach(System.out::println);
    }

    /**
     * isEqual 类似于 equals(), 区别在于: 先判断对象是否为 NULL,
     * 不为 NULL 再使用 equals 进行比较
     */
    @Test
    public void testPredicateIsEqual() {

        Predicate<String> equalGateway = s -> Predicate.isEqual("gateway").test(s);
        MICRO_SERVICE.stream().filter(equalGateway).forEach(System.out::println);
    }
}
