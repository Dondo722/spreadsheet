package org.example.Controller;

import javafx.collections.ObservableList;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.Page.Pageable;
import org.example.View.SpreadsheetView;


public class SpreadsheetController {
    private static SpreadsheetView view ;
    private static SpreadsheetModel model;
    public SpreadsheetController(SpreadsheetView view,SpreadsheetModel model){
        SpreadsheetController.view = view;
        SpreadsheetController.model = model;
        view.getTable().setItems(model.getList());

        addControllers();
    }
    private void addControllers(){
        MainMenuController.setController(view,model);
        LeftMenuController.setController(view,model);
        PagesController.setController(view,model.getList());
    }
    protected static void changeTableList(Pageable pageable, ObservableList<Teacher> list){
        pageable.getTable().setItems(list);
    }
}
