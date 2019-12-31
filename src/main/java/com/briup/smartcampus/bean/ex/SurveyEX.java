package com.briup.smartcampus.bean.ex;

import com.briup.smartcampus.bean.Class;
import com.briup.smartcampus.bean.Course;
import com.briup.smartcampus.bean.Department;
import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.bean.Teacher;

import java.io.Serializable;
import java.util.Date;

public class SurveyEX implements Serializable {
    private Integer id;

    private String status;

    private Integer code;

    private Date surveyday;

    private Integer departmentId;

    private Integer courseId;

    private Integer clazzId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer userId;

    private Integer questionnaireId;

    private Double average;

    private Department department;

    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getSurveyday() {
        return surveyday;
    }

    public void setSurveyday(Date surveyday) {
        this.surveyday = surveyday;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }



    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }



    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    private Teacher teacher;

    private Questionnaire questionnaire;



    private static final long serialVersionUID = 1L;


}
