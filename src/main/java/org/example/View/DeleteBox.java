package org.example.View;

import javafx.scene.control.Button;

public class DeleteBox extends SearchBox{
    private final Button buttonDelete = new Button("Delete");
    public DeleteBox(){
        super();
        super.addBotStatic(buttonDelete);
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }
}
