/*
 * @(#)Student.java Sep 8, 2007
 * Copyright 2007 sanqing organization, Inc. All rights reserved
 */
package com.sanqing.course.model;

/**
 * ѧ��ʵ�����
 * @hibernate.class table="Student" lazy="false"
 */
public class Student {

    private String id;          //����
    private String code;        //ѧ��
    private String name;        //����
    private String enrollDate;  //��ѧʱ��
    private String birthday;    //��������
    private String sex;         //�Ա�
    
    private Team team;          //�����༶

    /**
     * @hibernate.many-to-one column="teamId" class="com.sanqing.course.model.Team" 
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @hibernate.id
     *      column="id"
     *      generator-class="uuid.hex"
     */
    public String getId() {
        return id;
    }

    /**
     * @hibernate.property
     *      column="birthday"
     *      not-null="false"
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @hibernate.property
     *      column="code"
     *      not-null="false"
     */
    public String getCode() {
        return code;
    }

    /**
     * @hibernate.property
     *      column="enrollDate"
     *      not-null="false"
     */
    public String getEnrollDate() {
        return enrollDate;
    }

    /**
     * @hibernate.property
     *      column="name"
     *      not-null="false"
     */
    public String getName() {
        return name;
    }

    /**
     * @hibernate.property
     *      column="sex"
     *      not-null="false"
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @param enrollDate the enrollDate to set
     */
    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }
    
    
}
