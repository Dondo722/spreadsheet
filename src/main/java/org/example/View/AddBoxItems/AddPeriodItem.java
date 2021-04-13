package org.example.View.AddBoxItems;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.time.Period;

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
    public Period getPeriod(){
        int years =  Integer.parseInt(textFieldYears.getText());
        int months = Integer.parseInt(textFieldMonths.getText());
        return Period.of(years,months,0);
    }
    public boolean isPeriod(){
        return (!textFieldYears.getText().isEmpty() && !textFieldMonths.getText().isEmpty() &&
                !textFieldYears.getText().matches("[a-zA-Z]+$") && !textFieldMonths.getText().matches("[a-zA-Z]+$"));
    }
}
