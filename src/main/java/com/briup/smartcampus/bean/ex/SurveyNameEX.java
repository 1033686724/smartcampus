package com.briup.smartcampus.bean.ex;

import com.briup.smartcampus.bean.Course;
import com.briup.smartcampus.bean.Department;
import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.bean.Teacher;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SurveyNameEX implements Serializable {
    @ApiModelProperty(hidden = true)
    private Integer id;

    private String status;

    private Integer code;

    private Date surveyday;
//    @ApiModelProperty(hidden = true)
//    private Integer departmentId;
//    @ApiModelProperty(hidden = true)
//    private Integer courseId;
//    @ApiModelProperty(hidden = true)
//    private Integer clazzId;
//    @ApiModelProperty(hidden = true)
//    private Integer teacherId;
//    @ApiModelProperty(hidden = true)
//    private Integer questionnaireId;
//
//    private Double average;
//    @ApiModelProperty(hidden = true)
//    private Department department;
//    @ApiModelProperty(hidden = true)
//    private Course course;

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
//
//    public Integer getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Integer departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }
//
//    public Integer getClazzId() {
//        return clazzId;
//    }
//
//    public void setClazzId(Integer clazzId) {
//        this.clazzId = clazzId;
//    }
//
//    public Integer getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(Integer teacherId) {
//        this.teacherId = teacherId;
//    }
//
//    public Integer getQuestionnaireId() {
//        return questionnaireId;
//    }
//
//    public void setQuestionnaireId(Integer questionnaireId) {
//        this.questionnaireId = questionnaireId;
//    }
//
//    public Double getAverage() {
//        return average;
//    }
//
//    public void setAverage(Double average) {
//        this.average = average;
//    }
//
//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//    public Class getaClass() {
//        return aClass;
//    }
//
//    public void setaClass(Class aClass) {
//        this.aClass = aClass;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    public Questionnaire getQuestionnaire() {
//        return questionnaire;
//    }
//
//    public void setQuestionnaire(Questionnaire questionnaire) {
//        this.questionnaire = questionnaire;
//    }
//    @ApiModelProperty(hidden = true)
//    private Class aClass;
//    @ApiModelProperty(hidden = true)
//    private Teacher teacher;
//    @ApiModelProperty(hidden = true)
//    private Questionnaire questionnaire;



    private static final long serialVersionUID = 1L;
    private String departmentName;
    private String courseName;
    private String className;
    private String teacherName;
    private String questionnaireName;

    public String getDepatmentName() {
        return departmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.departmentName = depatmentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }
}
