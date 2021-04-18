package org.example.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Vector;


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

    public String[] getDepartmentList(){
        Vector<String> list = new Vector<>();
        for (Teacher teacher : teachers) {
            if(!list.contains(teacher.getDepartmentName())){
                list.add(teacher.getDepartmentName());
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] getRankList(){
        Vector<String> list = new Vector<>();
        for (Teacher teacher : teachers) {
            if(!list.contains(teacher.getAcademicRank())){
                list.add(teacher.getAcademicRank());
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] getFacultyList(){
        Vector<String> list = new Vector<>();
        for (Teacher teacher : teachers) {
            if(!list.contains(teacher.getFaculty())){
                list.add(teacher.getFaculty());
            }
        }
        return list.toArray(new String[0]);
    }
    public String[] getPeriodList(){
        Vector<CustomPeriod> list = new Vector<>();
        for (Teacher teacher : teachers) {
            if(!list.contains(teacher.getWorkExperience())){
                list.add(teacher.getWorkExperience());
            }
        }
        for (int k = 0; k < list.size(); k++){
            int min = k;
            for (int i = k; i < list.size(); i++) {
                if (list.get(min).moreThan(list.get(i))) {
                    min = i;
                }
            }
            if (min != k){
                CustomPeriod temp = list.get(k);
                list.set(k,list.get(min));
                list.set(min,temp);
            }
        }
        Vector<String> result = new Vector<>();
        for (CustomPeriod period: list){
            result.add(period.toString());
        }
        return result.toArray(new String[0]);
    }


    public ObservableList<Teacher> getTeachersByName(String name){
        ObservableList<Teacher> list = FXCollections.observableArrayList();
        for (Teacher teacher : teachers){
            if (teacher.getFullName().contains(name) || teacher.getFullName().equals(name))
                list.add(teacher);
        }
        return list;
    }
    public ObservableList<Teacher> getTeachersByDepartment(String department){
        ObservableList<Teacher> list = FXCollections.observableArrayList();
        for (Teacher teacher : teachers){
            if (teacher.getDepartmentName().equals(department))
                list.add(teacher);
        }
        return list;
    }
    public ObservableList<Teacher> getTeachersByRank(String rank){
        ObservableList<Teacher> list = FXCollections.observableArrayList();
        for (Teacher teacher : teachers){
            if (teacher.getAcademicRank().equals(rank))
                list.add(teacher);
        }
        return list;
    }
    public ObservableList<Teacher> getTeachersByFaculty(String faculty){
        ObservableList<Teacher> list = FXCollections.observableArrayList();
        for (Teacher teacher : teachers){
            if (teacher.getFaculty().equals(faculty))
                list.add(teacher);
        }
        return list;
    }
    public ObservableList<Teacher> getTeachersByExp(String lowVal, String topVal){
        ObservableList<Teacher> list = FXCollections.observableArrayList();
        for (Teacher teacher : teachers){
            if (teacher.getWorkExperience().moreOrEqualThan(CustomPeriod.getPeriod(lowVal)) &&
                    CustomPeriod.getPeriod(topVal).moreOrEqualThan(teacher.getWorkExperience()))
                list.add(teacher);
        }
        return list;
    }





    public void setTeachers(ObservableList<Teacher> teachers) {
        this.teachers = teachers;
    }

}
