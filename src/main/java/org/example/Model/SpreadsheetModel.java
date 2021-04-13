package org.example.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Period;

public class SpreadsheetModel {
    private Teacher teacher;
    private  ObservableList<Teacher> teachers = FXCollections.observableArrayList();

    public  void addTeacher(String faculty, String departmentName, String fullName, String academicRank, String academicDegree, Period workExperience ){
        teachers.add(new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,workExperience));
    }
    public boolean canAddTeacher(String[] teacherData){
        for (int i = 0; i < teacherData.length - 2;i++){
            if (teacherData[i].equals("") || teacherData[i].matches((".*\\d+.*"))) return false;
        }
        for(int i = teacherData.length - 2; i < teacherData.length; i++){
            if (teacherData[i].equals("") || teacherData[i].matches(("[a-zA-Z]+$"))) return false;
        }
        return true;
    }
    public void addTeacher(String[] teacherData){
        String faculty = teacherData[0];
        String departmentName = teacherData[1];
        String fullName = teacherData[2];
        String academicRank= teacherData[3];
        String academicDegree = teacherData[4];
        Period workExperience =  Period.of(Integer.parseInt(teacherData[5]),Integer.parseInt(teacherData[6]),0);

        teachers.add(new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,workExperience));
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public ObservableList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setTeachers(ObservableList<Teacher> teachers) {
        this.teachers = teachers;
    }

}
