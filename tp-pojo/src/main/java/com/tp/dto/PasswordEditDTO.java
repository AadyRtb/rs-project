package com.tp.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordEditDTO implements Serializable {
    private String StuId;
    private String newPassword;
    private String oldPassword;
}
