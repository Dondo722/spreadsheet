package org.example.Controller;

import org.example.Model.SpreadsheetModel;
import org.example.View.AddBox;
import org.example.View.SpreadsheetView;

public class MainMenuController {
    protected static void setController(SpreadsheetView view, SpreadsheetModel model){
        view.getMainMenu().getAddItem().setOnAction(e -> {
            AddBox addBox = new AddBox();
            AddBoxController.setController(addBox, view, model);
            addBox.display();
        });
    }
}
