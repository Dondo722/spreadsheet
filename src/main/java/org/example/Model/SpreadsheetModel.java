package org.example.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SpreadsheetModel {
    private  ObservableList<Teacher> teachers = FXCollections.observableArrayList();

    public  void addTeacher(String faculty, String departmentName, String fullName, String academicRank, String academicDegree, CustomPeriod workExperience ){
        teachers.add(new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,workExperience));
    }

    public boolean canAddTeacher(String[] teacherData){
        for (int i = 0; i < teacherData.length - 1;i++){
            if (teacherData[i].equals("") || teacherData[i].matches((".*\\d+.*"))) return false;
        }
        return CustomPeriod.canBe(teacherData[teacherData.length-1]);
    }
    public void addTeacher(String[] teacherData){
        String faculty = teacherData[0];
        String departmentName = teacherData[1];
        String fullName = teacherData[2];
        String academicRank= teacherData[3];
        String academicDegree = teacherData[4];
        CustomPeriod workExperience = new CustomPeriod(teacherData[5]);

        teachers.add(new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,workExperience));
    }

    public ObservableList<Teacher> getList() {
        return teachers;
    }

    public ObservableList<Teacher> getSubList(int fromIndex, int toIndex){
        return FXCollections.observableArrayList(teachers.subList(fromIndex,toIndex));
    }


    public void setTeachers(ObservableList<Teacher> teachers) {
        this.teachers = teachers;
    }

}
