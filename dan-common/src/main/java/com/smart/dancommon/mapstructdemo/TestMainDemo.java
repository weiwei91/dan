package com.smart.dancommon.mapstructdemo;

import org.mapstruct.factory.Mappers;

/**
 * @ClassName TestMainDemo
 * @Author WeiWei10
 * @Date 2020/9/3 20:51
 * @Version 1.0
 */
public class TestMainDemo {
    public static void main(String[] args) {
        Order order = new Order();
        order.setId(12345L);
        order.setOrderSn("orderSn");
        order.setOrderType(0);
        order.setReceiverKeyword("keyword");
        order.setSourceType(1);
        order.setStatus(2);
        order.setTest("TEST");

        OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
        OrderQueryParam orderQueryParam = mapper.entity2queryParam(order);
        System.out.println(1);

    }
}
