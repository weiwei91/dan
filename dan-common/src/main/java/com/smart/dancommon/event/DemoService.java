package com.smart.dancommon.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class DemoService {

    @Autowired
    public ApplicationEventPublisher applicationEventPublisher;

    /**
     * 支付成功后，发布事件
     * @param orderId
     */
    public void paySuccess(String orderId) {
        if (!StringUtils.isEmpty(orderId)) {
            applicationEventPublisher.publishEvent(new DemoEvent(this, orderId));
        }
    }



}
