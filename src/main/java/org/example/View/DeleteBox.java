package org.example.View;

import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;

public class DeleteBox extends SearchBox{
    private final Button buttonDelete = new Button("Delete");
    public DeleteBox(){
        super();
        this.getTable().getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );
        super.addBotStatic(buttonDelete);
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }
}
