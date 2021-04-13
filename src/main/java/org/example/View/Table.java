package org.example.View;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table<T> extends TableView<T> {
    public Table(int sceneWidth,int columnCount,String[] columnNames,String[] columnValNames){
        super();
        int tableWidth = sceneWidth/columnCount;
        for (int i = 0; i < columnCount; i++){
            TableColumn<T,String> facultyColumn = new TableColumn<>(columnNames[i]);
            facultyColumn.setPrefWidth(tableWidth);
            facultyColumn.setCellValueFactory(new PropertyValueFactory<>(columnValNames[i]));
            this.getColumns().add(facultyColumn);
        }
    }
}
