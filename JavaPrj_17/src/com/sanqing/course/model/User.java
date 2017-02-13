/*
 * @(#)User.java Sep 8, 2007
 * Copyright 2007 sanqing organization, Inc. All rights reserved
 */
package com.sanqing.course.model;

/**
 * �û�ʵ�����
 * @hibernate.class table="User" lazy="false"
 */
public class User {

	private String id;			//����
	private String name;		//��¼��
	private String password;    //����
	
	private Teacher teacher;   //�����Ľ�ʦ 
	
    

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
     *      column="name"
     *      not-null="true"
     */
    public String getName() {
        return name;
    }
    /**
     * @hibernate.property
     *      column="getPassword"
     *      not-null="true"
     */
    public String getPassword() {
        return password;
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
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


   
}
