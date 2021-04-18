package org.example.Controller;

import javafx.collections.ObservableList;
import org.example.Model.CustomPeriod;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.SpreadsheetView;
import org.example.View.Table;


public class SpreadsheetController {
    private static SpreadsheetView view ;
    private static SpreadsheetModel model;
    private static Table<Teacher> table;
    public SpreadsheetController(SpreadsheetView view,SpreadsheetModel model){
        SpreadsheetController.view = view;
        SpreadsheetController.model = model;
        table = new Table<>(view.getSceneWidth(), Teacher.getNames().length,Teacher.getNames(),Teacher.getNamesVal());
        table.setItems(model.getList());
        testAddTeachers();

        addTableToView();
        addControllers();
    }
    private void addControllers(){
        MainMenuController.setController(view,model);
        PagesController.setController(view,model);
    }

    protected static void addTableToView( ){
        view.addTable(table);
    }
    protected static void changeTableList(ObservableList<Teacher> list){
        table.setItems(list);
    }

    protected static Table<Teacher> getTable(){
        return table;
    }

    public void testAddTeachers() {
        model.addTeacher("Slitherin", "dik", "AAAAAAA", "BACA", "MASTER", new CustomPeriod("12 0"));
        model.addTeacher("X", "HUk", "BBBBBBBBB", "BACA", "MASTER", new CustomPeriod("0 5"));
        model.addTeacher("Slitherin", "hik", "CCCCCCCCC", "HUGA", "MASTER", new CustomPeriod("0 8"));
        model.addTeacher("Slitherin", "dik", "DDDDDDDDDDD", "BACA", "MASTER", new CustomPeriod("1 0"));
        model.addTeacher("Slitherin", "pjo", "EEEEEEEEEE", "TEMPA", "MASTER", new CustomPeriod("4 0"));
        model.addTeacher("hda", "dik", "KKKKKKKKKK", "HUGA", "MASTER", new CustomPeriod("4 1"));
        model.addTeacher("fasd", "lgu", "LLLLLLLL", "SALSA", "MASTER", new CustomPeriod("6 7"));
        model.addTeacher("lxcv;", "dik", "MMMMMMMMM", "TEMPA", "MASTER", new CustomPeriod("7 1"));
        model.addTeacher("Slitherin", "lgu", "NNNNNNNNNN", "TEMPA", "MASTER", new CustomPeriod("0 1"));
        model.addTeacher("ggrqwkl", "dihikk", "FFFFFFFF", "FUXA", "MASTER", new CustomPeriod("0 2"));
        model.addTeacher("bnvmc", "dik", "IIIIIIIIII", "FUXA", "MASTER", new CustomPeriod("0 4"));
        model.addTeacher("qwyeuioryqwui", "lgu", "JJJJJJJJJJJJJJ", "BACA", "MASTER", new CustomPeriod("110 0"));
        model.addTeacher("hasdfk", "hik", "GGGGGGGGGGGGG", "BACA", "MASTER", new CustomPeriod("10 0"));
    }
}
