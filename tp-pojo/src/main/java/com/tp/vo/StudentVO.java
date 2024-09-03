package com.tp.vo;

import com.tp.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO {
    private String id;
    private String name;
    private String major;

    private  Float totalCredit;
    private Float needCredit;
    private String password;

    private String realName;

    private Integer unFinished;

    private String clazz;

    public StudentVO (Student student)
    {
        this.id = student.getId();
        this.name = student.getName();
        this.major = student.getMajor();
        this.totalCredit = student.getTotalCredit();
        this.needCredit = student.getNeedCredit();
        this.password = student.getPassword();
        this.realName = student.getRealName();
        this.clazz= student.getClazz();
    }
}
