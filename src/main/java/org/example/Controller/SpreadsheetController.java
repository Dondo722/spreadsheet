package org.example.Controller;

import javafx.collections.ObservableList;
import org.example.Model.CustomPeriod;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.SpreadsheetView;

import java.io.OutputStream;
import java.time.Period;

public class SpreadsheetController {
    private static SpreadsheetView view ;
    private static SpreadsheetModel model;
    public SpreadsheetController(SpreadsheetView view,SpreadsheetModel model){
        SpreadsheetController.view = view;
        SpreadsheetController.model = model;
        testAddTeachers();
        addTable(model.getList());
        addControllers();
    }
    private void addControllers(){
        MainMenuController.setController(view,model);
        PagesController.setController(view,model);
    }
    protected static void addTable(ObservableList<Teacher> list ){
        view.addTable(Teacher.getNames().length,Teacher.getNames(),Teacher.getNamesVal(), list);
    }
    public void testAddTeachers() {
        System.out.println(Period.of(1,1,1).toString());
        model.addTeacher("Slitherin", "dik", "AAAAAAA", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("X", "HUk", "BBBBBBBBB", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("Slitherin", "dik", "CCCCCCCCC", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("Slitherin", "dik", "DDDDDDDDDDD", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("Slitherin", "dik", "EEEEEEEEEE", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("hda", "dik", "KKKKKKKKKK", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("fasd", "dik", "LLLLLLLL", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("lxcv;", "dik", "MMMMMMMMM", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("Slitherin", "dik", "NNNNNNNNNN", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("ggrqwkl", "dik", "FFFFFFFF", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("bnvmc", "dik", "IIIIIIIIII", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("qwyeuioryqwui", "dik", "JJJJJJJJJJJJJJ", "BACA", "MASTER", new CustomPeriod("0 0"));
        model.addTeacher("hasdfk", "dik", "GGGGGGGGGGGGG", "BACA", "MASTER", new CustomPeriod("0 0"));
    }
}
