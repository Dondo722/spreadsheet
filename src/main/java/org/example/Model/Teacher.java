package org.example.Model;

import java.time.Period;


public class Teacher {
    private String faculty;
    private String departmentName;
    private String fullName;
    private String academicRank;
    private String academicDegree;
    private CustomPeriod workExperience;

    public Teacher(String faculty, String departmentName, String fullName, String academicRank, String academicDegree, CustomPeriod workExperience) {
        this.faculty = faculty;
        this.departmentName = departmentName;
        this.fullName = fullName;
        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.workExperience = workExperience;
    }

    public static String[] getNames(){
         return new String[]{"Faculty","Department","Teacher\n name:","Academic\n rank","Academic\n degree","Work\n experience"};
    }

    public static String[] getNamesVal(){
        return new String[]{"faculty","departmentName","fullName","academicRank","academicDegree","workExperience"};
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public CustomPeriod getWorkExperience() {
        return workExperience;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setWorkExperience(CustomPeriod workExperience) {
        this.workExperience = workExperience;
    }
}
