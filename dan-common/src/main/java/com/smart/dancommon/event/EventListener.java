package com.smart.dancommon.event;

import org.springframework.stereotype.Component;

@Component
public class EventListener {
    @org.springframework.context.event.EventListener
    public void updateOrderStatus(DemoEvent demoEvent) {
        String orderId = demoEvent.getOrderId();
        //修改订单状态
        System.out.println(String.format("支付成功，修改订单【%s】状态为已支付！！！",orderId));
    }
}

