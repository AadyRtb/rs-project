package com.rs.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "新建套餐返回的数据格式")
public class MenuVo implements Serializable {

    @ApiModelProperty("主食")
    private List<String> foodName;

    @ApiModelProperty("小吃")
    private List<String> snackName;

    @ApiModelProperty("饮料")
    private List<String> drinkName;




}
