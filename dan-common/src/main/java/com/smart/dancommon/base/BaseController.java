package com.smart.dancommon.base;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BaseController
 * @Author WeiWei10
 * @Date 2020/8/31 19:06
 * @Version 1.0
 */
@Slf4j
public class BaseController {
    public BaseController(){
        log= LoggerFactory.getLogger(getClass().getName());
    }
}
