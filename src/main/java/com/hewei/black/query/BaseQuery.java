package com.hewei.black.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseQuery<T> implements Serializable {
    @ApiModelProperty("当前页:默认值1")
    private int currentPage = 1;
    @ApiModelProperty("每页条数:默认值10")
    private int pageSize = 10;


}
