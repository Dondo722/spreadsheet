package org.example.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.View.AddBoxItems.AddNameItem;
import org.example.View.AddBoxItems.AddPeriodItem;
import org.example.View.AddBoxItems.AddItem;




public class AddBox {
    private final Stage window = new Stage();
    int spacing = 5;
    int itemLabelWidth = 100;
    int itemFieldWidth = 310;
    private final AddItem facultyItem = new AddItem(spacing,itemLabelWidth,"Faculty:",itemFieldWidth,"faculty name");
    private final AddItem departmentNameItem = new AddItem(spacing,itemLabelWidth,"Department:",itemFieldWidth,"department name");
    private final AddNameItem teacherNameItem = new AddNameItem(spacing,itemLabelWidth,"Teacher:",itemFieldWidth);
    private final AddItem teacherAcademicRankItem = new AddItem(spacing,itemLabelWidth,"Academic rank:",itemFieldWidth,"teacher academic rank");
    private final AddItem teacherAcademicDegreeItem = new AddItem(spacing,itemLabelWidth,"Academic degree:",itemFieldWidth,"teacher academic degree");
    private final AddPeriodItem teacherWorkExperienceItem = new AddPeriodItem(spacing,itemLabelWidth,"Work experience:",itemFieldWidth/2);
    private final Button buttonAdd = new Button("Add");
    private final Button buttonCancel = new Button("Cancel");

    public void display(){

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Teacher");

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.setSpacing(5);
        buttons.getChildren().addAll(buttonCancel,buttonAdd);


        VBox root  = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(8);
        root.getChildren().addAll(facultyItem,departmentNameItem,teacherNameItem,teacherAcademicRankItem,teacherAcademicDegreeItem,teacherWorkExperienceItem,buttons);

        int boxWeight = 435;
        int boxHeight = 250;
        Scene scene = new Scene(root, boxWeight,boxHeight);
        window.setScene(scene);
        window.showAndWait();
    }
    public String[] getValues(){
        return new String[]{facultyItem.getText(),departmentNameItem.getText(),teacherNameItem.getText(),teacherAcademicRankItem.getText(),
                teacherAcademicDegreeItem.getText(),teacherWorkExperienceItem.getPeriod()} ;
    }

    public Stage getWindow() {
        return window;
    }

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public Button getButtonCancel() {
        return buttonCancel;
    }
}
