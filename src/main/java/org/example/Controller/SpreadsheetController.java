package org.example.Controller;

import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.SpreadsheetView;

import java.time.Period;

public class SpreadsheetController {
    private final SpreadsheetView view;
    private final SpreadsheetModel model;
    public SpreadsheetController(SpreadsheetView view,SpreadsheetModel model){
        this.view = view;
        this.model = model;
        view.addTable(Teacher.getNames().length,Teacher.getNames(),Teacher.getNamesVal(), model.getTeachers());
        testAddTeachers();
        addControllers();
    }
    private void addControllers(){
        MainMenuController.setController(view,model);
    }
    public void testAddTeachers(){
        model.addTeacher("Slitherin","dik","AAAAAAA","BACA", "MASTER", Period.ZERO);
        model.addTeacher("X2","HUk","BBBBBBBBB","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","CCCCCCCCC","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","DDDDDDDDDDD","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","EEEEEEEEEE","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","KKKKKKKKKK","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","LLLLLLLL","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","MMMMMMMMM","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","NNNNNNNNNN","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","FFFFFFFF","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","IIIIIIIIII","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","JJJJJJJJJJJJJJ","BACA", "MASTER", Period.ZERO);
        model.addTeacher("Slitherin","dik","GGGGGGGGGGGGG","BACA", "MASTER", Period.ZERO);
    }
}
