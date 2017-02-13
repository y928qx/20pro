/*
 * @(#)Mark.java Sep 8, 2007
 * Copyright 2007 sanqing organization, Inc. All rights reserved
 */
package com.sanqing.course.model;

/**
 * �ɼ�ʵ�����
 * @hibernate.class table="Mark" lazy="false"
 */
public class Mark {

    private String id;          //����
    private Student student;    //ѧ��
    private Course course;      //�γ�
    private Float score;        //�ɼ�
    
    /**
     * @hibernate.many-to-one column="studentId" class="com.sanqing.course.model.Student" 
     */
    public Student getStudent() {
        return student;
    }
    /**
     * @hibernate.many-to-one column="courseId" class="com.sanqing.course.model.Course" 
     */
    public Course getCourse() {
        return course;
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
     *      column="score"
     *      not-null="false"
     */
    public Float getScore() {
        return score;
    }
    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @param score the score to set
     */
    public void setScore(Float score) {
        this.score = score;
    }
    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
}
