package org.example.View.SearchBoxes;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class NameSearchBox extends HBox {
    private final TextField teacherName = new TextField();
    private final ChoiceBox<String> departmentBox = new ChoiceBox<>();
    public NameSearchBox(){
        super();
        int inputElWidth = 100;

        this.setSpacing(10);

        HBox teachHBox = new HBox();
        Label teacherLabel = new Label("Teacher name: ");
        teacherName.setPrefWidth(inputElWidth);
        teachHBox.getChildren().addAll(teacherLabel,teacherName);
        teachHBox.setSpacing(5);

        HBox departmentBoxHBox = new HBox();
        Label departmentBoxLabel = new Label("Department name: ");
        departmentBox.setPrefWidth(inputElWidth);
        teachHBox.getChildren().addAll(departmentBoxLabel,departmentBox);
        departmentBoxHBox.setSpacing(5);

        this.getChildren().addAll(teachHBox,departmentBoxHBox);
    }
    public void addDepartments(String[] items){
            departmentBox.getItems().addAll(items);
    }

    public TextField getTeacherName() {
        return teacherName;
    }

    public String getDepartmentName(){
        return departmentBox.getValue();
    }

}
