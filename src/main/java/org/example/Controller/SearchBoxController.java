package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.CustomPeriod;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.Alerts.InputAlert;
import org.example.View.SearchBox;
import org.example.View.SearchBoxes.NameSearchBox;
import org.example.View.SearchBoxes.RankSearchBox;
import org.example.View.SearchBoxes.WorkExpSearchBox;

public class SearchBoxController {

    protected static void setController(SearchBox searchBox, SpreadsheetModel model){
        searchBox.getItemName().setOnAction(e -> {
            searchBox.nameSearchBoxCase(model.getDepartmentList());
            searchBox.getButtonFind().setOnAction(event -> nameSearchBoxFind(searchBox,model));
        });
        searchBox.getItemRank().setOnAction(e -> {
            searchBox.rankSearchBoxCase(model.getRankList(),model.getFacultyList());
            searchBox.getButtonFind().setOnAction(event -> rankSearchBoxFind(searchBox,model));
        });

        searchBox.getItemExperience().setOnAction(e -> {
            searchBox.workExpSearchBoxCase(model.getPeriodList());
            searchBox.getButtonFind().setOnAction(event -> expSearchBoxFind(searchBox,model));
        });
    }
    private static void addTableToSearchBox(SearchBox searchBox, ObservableList<Teacher> list){
        searchBox.getTable().setItems(list);
    }
    private static void nameSearchBoxFind(SearchBox searchBox,SpreadsheetModel model){
        NameSearchBox nameBox = searchBox.getNameSearchBox();
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        if (nameBox.getDepartmentName() == null &&  nameBox.getTeacherName().getText().equals("")) {
            InputAlert.display();
            return;
        }
         if (nameBox.getTeacherName() != null && !nameBox.getTeacherName().getText().equals(""))
             model.getTeachersByName(teachers,nameBox.getTeacherName().getText());
         if (nameBox.getDepartmentName() != null)
             model.getTeachersByDepartment(teachers,nameBox.getDepartmentName());
         SearchBoxController.addToView(searchBox,teachers);
    }
    private static void rankSearchBoxFind(SearchBox searchBox,SpreadsheetModel model){
        RankSearchBox rankBox = searchBox.getRankSearchBox();
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        if (rankBox.getRankBoxVal() == null && rankBox.getFacultyBoxVal()== null) {
            InputAlert.display();
            return;
        }
        if (rankBox.getRankBoxVal() != null )
            model.getTeachersByRank(teachers,rankBox.getRankBoxVal());
        if (rankBox.getFacultyBoxVal() != null)
            model.getTeachersByFaculty(teachers,rankBox.getFacultyBoxVal());
        SearchBoxController.addToView(searchBox,teachers);
    }
    private static void expSearchBoxFind(SearchBox searchBox,SpreadsheetModel model){
        WorkExpSearchBox expBox = searchBox.getWorkExpSearchBox();
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        if (new CustomPeriod(expBox.getFromVal()).moreThan(new CustomPeriod(expBox.getToVal())))
            InputAlert.display();
        else if (expBox.getFromVal() == null || expBox.getToVal()== null )InputAlert.display();
        else {
            teachers.addAll(model.getTeachersByExp(expBox.getFromVal(),expBox.getToVal()));
            SearchBoxController.addToView(searchBox,teachers);
        }
    }
    private static void addToView(SearchBox searchBox,ObservableList<Teacher> teachers){
        PagesController.setController(searchBox, teachers);
        SearchBoxController.addTableToSearchBox(searchBox, teachers);
    }
}
