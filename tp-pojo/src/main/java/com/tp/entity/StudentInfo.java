package com.tp.entity;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    static private StudentInfo studentInfo;


    private String id;
    private String name;
    private String major;

    private  Float totalCredit;
    private Float needCredit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Float getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Float totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Float getNeedCredit() {
        return needCredit;
    }

    public void setNeedCredit(Float needCredit) {
        this.needCredit = needCredit;
    }


    public static StudentInfo getStudentInfo() {
        if (studentInfo == null) {
            studentInfo = new StudentInfo();
        }
        return studentInfo;
    }
}
