package com.smart.dancommon.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BaseController
 * @Author WeiWei10
 * @Date 2020/8/31 19:06
 * @Version 1.0
 */
public class BaseController {
    protected Logger logger =null;
    public BaseController(){
        logger= LoggerFactory.getLogger(getClass().getName());
    }
}
