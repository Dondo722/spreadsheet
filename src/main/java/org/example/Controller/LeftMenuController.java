package org.example.Controller;

import org.example.Model.SpreadsheetModel;
import org.example.View.*;

public class LeftMenuController {
    protected static void setController( SpreadsheetView view, SpreadsheetModel model){
        LeftMenu menu = view.getLeftMenu();
        menu.getOpenButton().setOnAction(e -> MainMenuController.openAndSaveDialogs(view,model,false));
        menu.getSaveButton().setOnAction(e -> MainMenuController.openAndSaveDialogs(view,model,true));
        menu.getAddButton().setOnAction(e -> MainMenuController.addBox(view, model));
        menu.getFindButton().setOnAction(e -> MainMenuController.searchBox(model));
        menu.getDeleteButton().setOnAction(e -> MainMenuController.deleteBox(view, model));
    }
}
