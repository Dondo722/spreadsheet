package org.example.Controller;

import org.example.Model.SpreadsheetModel;
import org.example.View.AddBox;
import org.example.View.Alerts.InputAlert;
import org.example.View.SpreadsheetView;

public class AddBoxController {
    protected static void setController(AddBox addBox, SpreadsheetView view, SpreadsheetModel model) {
        addBox.getButtonAdd().setOnAction(e -> {
            if(model.canAddTeacher(addBox.getValues())) {
                model.addTeacher(addBox.getValues());
                addBox.getWindow().close();
                PagesController.update(view,model);
            }
            else InputAlert.display();
        });
        addBox.getButtonCancel().setOnAction(e -> addBox.getWindow().close());
    }
}
