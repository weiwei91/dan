package com.smart.dancommon.event;

import com.smart.DanStartApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EventTest extends DanStartApplicationTests {
    @Autowired
    private DemoService demoService;

    @Test
    public void testEvent(){
        String orderId = "123";
        demoService.paySuccess(orderId);
    }
}
