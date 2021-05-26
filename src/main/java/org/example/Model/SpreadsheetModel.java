package org.example.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Vector;


public class SpreadsheetModel {
    private final ObservableList<Teacher> teachers = FXCollections.observableArrayList();

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
        CustomPeriod workExperience = CustomPeriod.createPeriod(teacherData[5]);

        teachers.add(new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,workExperience));
    }

    public ObservableList<Teacher> getList() {
        return teachers;
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
            if(!isTeacherPeriodAdded(list,teacher)){
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


    public void getTeachersByName(ObservableList<Teacher> list, String name){
        for (Teacher teacher : teachers){
            if (list.contains(teacher))continue;
            if ( teacher.getFullName().equals(name)) {
                list.add(teacher);
                continue;
            }
            if (teacher.getFullName().contains(name)) {
                int index = teacher.getFullName().indexOf(name);
                if(index != 0 && teacher.getFullName().charAt(index - 1) != ' ') continue;
                if (index + name.length() != teacher.getFullName().length() && teacher.getFullName().charAt(index + name.length()) != ' ')
                    continue;
                list.add(teacher);
            }
        }
    }
    public void getTeachersByDepartment(ObservableList<Teacher> list,String department){
        for (Teacher teacher : teachers){
            if (list.contains(teacher))continue;
            if (teacher.getDepartmentName().equals(department))
                list.add(teacher);
        }
    }
    public void getTeachersByRank(ObservableList<Teacher> list,String rank){
        for (Teacher teacher : teachers){
            if (list.contains(teacher))continue;
            if (teacher.getAcademicRank().equals(rank))
                list.add(teacher);
        }
    }
    public void getTeachersByFaculty(ObservableList<Teacher> list,String faculty){
        for (Teacher teacher : teachers){
            if (list.contains(teacher))continue;
            if (teacher.getFaculty().equals(faculty))
                list.add(teacher);
        }
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

    public boolean isTeacherPeriodAdded(Vector<CustomPeriod> list,Teacher teacher){
        CustomPeriod teacherPeriod = teacher.getWorkExperience();
        for (CustomPeriod period : list){
            if (period.isEqual(teacherPeriod))
                return true;
        }
        return false;
    }

}
