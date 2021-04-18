package org.example.Controller;

import javafx.collections.ObservableList;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.DeleteBox;
import org.example.View.SpreadsheetView;


public class DeleteBoxController {
    protected static void setController(DeleteBox deleteBox, SpreadsheetView view, SpreadsheetModel model){
        SearchBoxController.setController(deleteBox,model);
        deleteBox.getButtonDelete().setOnAction(e ->deleteButton(deleteBox,view,model));
    }
    private static void deleteButton(DeleteBox deleteBox, SpreadsheetView view, SpreadsheetModel model){
        ObservableList<Teacher> teachersSelected, allTeachers;
        allTeachers = SearchBoxController.getTable().getItems();
        teachersSelected = SearchBoxController.getTable().getSelectionModel().getSelectedItems();
        teachersSelected.forEach(model.getList()::remove);
        if(allTeachers.size() > 1 ) teachersSelected.forEach(allTeachers::remove);
        else allTeachers.clear();
        PagesController.update(view,model);
        SearchBoxController.setTopLabel(deleteBox,"Found teachers: " + allTeachers.size());
    }

}
