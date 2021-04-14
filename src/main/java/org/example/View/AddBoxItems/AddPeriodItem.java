package org.example.View.AddBoxItems;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class AddPeriodItem extends HBox{
    private final TextField textFieldYears = new TextField();
    private final TextField textFieldMonths = new TextField();

    public AddPeriodItem(int spacing, int labelWidth, String labelText,int fieldsWidth){
        super();
        super.setSpacing(spacing);
        Label label = new Label(labelText);
        label.setPrefWidth(labelWidth);
        textFieldYears.promptTextProperty().set("years");
        textFieldYears.setPrefWidth(fieldsWidth);
        textFieldMonths.promptTextProperty().set("months");
        textFieldMonths.setPrefWidth(fieldsWidth);
        this.getChildren().addAll(label,textFieldYears,textFieldMonths);
    }
    public String getPeriodMonths(){
        return textFieldMonths.getText();
    }
    public String getPeriodYears(){
        return textFieldYears.getText();
    }
    public String getPeriod(){
        return textFieldYears.getText() + " " + textFieldMonths.getText();
    }
}
