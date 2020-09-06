package com.smart.dancommon.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    //订单id
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public DemoEvent(Object source,String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
