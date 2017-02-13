/*
 * @(#)Team.java Aug 27, 2007
 * Copyright 2007 sanqing organization, Inc. All rights reserved
 */
package com.sanqing.course.model;

import java.util.Set;

/**
 * �༶ʵ�����
 * @hibernate.class table="Team" lazy="false"
 */
public class Team {

    private String id;      //����
    private String name;    //�༶����
    
    private Set<Student> students;  //������ѧ��

    /**
     * @hibernate.set inverse="true" lazy="true" cascade="delete-orphan"
     * @hibernate.key column="teamId"
     * @hibernate.one-to-many class="com.sanqing.course.model.Student"
     */
    public Set<Student> getStudents() {
        return students;
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
     *      column="name"
     *      not-null="false"
     */
    public String getName() {
        return name;
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
     * @param students the students to set
     */
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    
}
