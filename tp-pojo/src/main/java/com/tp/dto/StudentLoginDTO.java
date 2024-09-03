package com.tp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "学生登录时传递的数据模型")
public class StudentLoginDTO  implements Serializable {

    @ApiModelProperty("学号")
    private String id;

    @ApiModelProperty("密码")
    private String password;


    public String getId() {
        return id;
    }
}