package com.smart.dancommon.mapstructdemo;

import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;

/**
 * @ClassName OrderQueryParam
 * @Author WeiWei10
 * @Date 2020/9/3 20:48
 * @Version 1.0
 */
@Data
public class OrderQueryParam {
    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 收货人姓名/号码
     */
    private String receiverKeyword;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    private Integer status;

    /**
     * 订单类型：0->正常订单；1->秒杀订单
     */
    private Integer orderType;

    /**
     * 订单来源：0->PC订单；1->app订单
     */
    private Integer sourceType;
    private String test1;
}