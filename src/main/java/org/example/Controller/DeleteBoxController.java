package org.example.Controller;

import javafx.collections.ObservableList;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.Alerts.DeleteAlert;
import org.example.View.DeleteBox;
import org.example.View.SpreadsheetView;


public class DeleteBoxController {
    protected static void setController(DeleteBox deleteBox, SpreadsheetView view, SpreadsheetModel model){
        SearchBoxController.setController(deleteBox,model);
        deleteBox.getButtonDelete().setOnAction(e -> deleteButton(deleteBox,view,model));
    }
    private static void deleteButton(DeleteBox deleteBox, SpreadsheetView view, SpreadsheetModel model){
        ObservableList<Teacher> teachersSelected;
        teachersSelected = deleteBox.getTable().getSelectionModel().getSelectedItems();
        teachersSelected.forEach(model.getList()::remove);
        DeleteAlert.display(teachersSelected.size());
        deleteBox.getButtonFind().fire();

       // PagesController.update(view,model);
       // SearchBoxController.setTopLabel(deleteBox,"Found teachers: " + allTeachers.size());
    }

}
