package org.example.Controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.Controller.AddBoxItems.AddPeriodItem;
import org.example.Model.Teachers;
import org.example.Controller.AddBoxItems.AddItem;




public class AddBox {
    Stage window = new Stage();
    int boxHeight = 250;
    int boxPadding = 10;
    int boxSpacing = 8;
    int spacing = 5;
    int itemLabelWidth = 100;
    int itemFieldWidth = 310;
    AddItem facultyItem = new AddItem(spacing,itemLabelWidth,"Faculty:",itemFieldWidth,"faculty name");
    AddItem departmentNameItem = new AddItem(spacing,itemLabelWidth,"Department:",itemFieldWidth,"department name");
    AddItem teacherNameItem = new AddItem(spacing,itemLabelWidth,"Teacher:",itemFieldWidth,"full name");
    AddItem teacherAcademicRankItem = new AddItem(spacing,itemLabelWidth,"Academic rank:",itemFieldWidth,"teacher academic rank");
    AddItem teacherAcademicDegreeItem = new AddItem(spacing,itemLabelWidth,"Academic degree:",itemFieldWidth,"teacher academic degree");
    AddPeriodItem teacherWorkExperienceItem = new AddPeriodItem(spacing,itemLabelWidth,"Work experience:",itemFieldWidth/2);


    public void display(){

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Teacher");

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.setSpacing(5);
        Button buttonAdd = new Button("Add");
        buttonAdd.setOnAction(e -> addButton());
        Button buttonCancel = new Button("Cancel");
        buttonCancel.setOnAction(e -> window.close());
        buttons.getChildren().addAll(buttonCancel,buttonAdd);


        VBox root  = new VBox();
        root.setPadding(new Insets(boxPadding));
        root.setSpacing(boxSpacing);
        root.getChildren().addAll(facultyItem,departmentNameItem,teacherNameItem,teacherAcademicRankItem,teacherAcademicDegreeItem,teacherWorkExperienceItem,buttons);

        int boxWeight = 435;
        Scene scene = new Scene(root, boxWeight,boxHeight);
        window.setScene(scene);
        window.showAndWait();
    }
    private void addButton(){
        if(allRight()){
            Teachers.addTeacher(facultyItem.getText(),departmentNameItem.getText(),teacherNameItem.getText(),teacherAcademicRankItem.getText(),
                    teacherAcademicDegreeItem.getText(),teacherWorkExperienceItem.getPeriod());
            window.close();
        }
        else AlertBox.display();
    }
    private boolean allRight(){
        if (facultyItem.getText().isEmpty() || facultyItem.getText().matches((".*\\d+.*"))) return false;
        else if (departmentNameItem.getText().isEmpty() || departmentNameItem.getText().matches((".*\\d+.*"))) return false;
        else if (teacherNameItem.getText().isEmpty() || teacherNameItem.getText().matches((".*\\d+.*"))) return false;
        else if (teacherAcademicRankItem.getText().isEmpty() || teacherAcademicRankItem.getText().matches((".*\\d+.*"))) return false;
        else if (teacherAcademicDegreeItem.getText().isEmpty() || teacherAcademicDegreeItem.getText().matches((".*\\d+.*"))) return false;

        return (teacherWorkExperienceItem.isPeriod());
    }




}
