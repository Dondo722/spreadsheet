package org.example.View.SearchBoxes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class NameSearchBox extends HBox {
    private final TextField teacherName = new TextField();
    private final ChoiceBox<String> department = new ChoiceBox<>();
    public NameSearchBox(){
        super();
        this.setPadding(new Insets(5));
        this.setSpacing(10);

        HBox teachHBox = new HBox();
        Label teacherLabel = new Label("Teacher name: ");
        teachHBox.getChildren().addAll(teacherLabel,teacherName);
        teachHBox.setSpacing(5);

        HBox departmentHBox = new HBox();
        Label departmentLabel = new Label("Department name: ");
        departmentHBox.setSpacing(5);
        teachHBox.getChildren().addAll(departmentLabel,department);

        this.getChildren().addAll(teachHBox,departmentHBox);
    }
    public void addItems(String[] items){
            department.getItems().addAll(items);
    }

    public TextField getTeacherName() {
        return teacherName;
    }

}
