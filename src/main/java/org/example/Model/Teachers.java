package org.example.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Period;

public class Teachers {
    public static ObservableList<Teacher> teachers = FXCollections.observableArrayList();

    public static void addTeacher(String faculty, String departmentName, String fullName, String academicRank, String academicDegree, Period workExperience ){
        teachers.add(new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,workExperience));
    }
}
