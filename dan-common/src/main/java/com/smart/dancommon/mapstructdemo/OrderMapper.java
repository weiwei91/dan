package com.smart.dancommon.mapstructdemo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author weiwei10
 */
@Mapper
public interface OrderMapper {

    /**
     * @param order
     *
     * @return OrderQueryParam
     */
    @Mapping(source = "test", target = "test1")
    OrderQueryParam entity2queryParam(Order order);

}
