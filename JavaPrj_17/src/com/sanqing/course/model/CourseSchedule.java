/*
 * @(#)CourseSchedule.java Sep 8, 2007
 * Copyright 2007 sanqing organization, Inc. All rights reserved
 */
package com.sanqing.course.model;

/**
 * �γ̱�ʵ�����
 * @hibernate.class table="CourseSchedule" lazy="false"
 */
public class CourseSchedule {

    private String id;          //����
    private Team team;          //�༶
    private Course course;      //�γ�
    private Teacher teacher;    //��ʦ
    private String semester;    //ѧ��
    private Float  score;       //ѧ��

    /**
     * @hibernate.many-to-one column="teacherId" class="com.sanqing.course.model.Teacher" 
     */
    public Teacher getTeacher() {
        return teacher;
    }
    /**
     * @hibernate.many-to-one column="courseId" class="com.sanqing.course.model.Course" 
     */
    public Course getCourse() {
        return course;
    }
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
     *      column="score"
     *      not-null="false"
     */
    public Float getScore() {
        return score;
    }
    /**
     * @hibernate.property
     *      column="semester"
     *      not-null="false"
     */
    public String getSemester() {
        return semester;
    }
    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
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
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }
    
}
