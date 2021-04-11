package org.example.View;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Model.Teacher;


public class TeacherTable extends TableView<Teacher> {
    public TeacherTable(int sceneWidth){
        super();
        int tableWidth = sceneWidth/6;

        TableColumn<Teacher,String> facultyColumn = new TableColumn<>("Faculty");
        facultyColumn.setPrefWidth(tableWidth);
        facultyColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        this.getColumns().add(facultyColumn);


        TableColumn<Teacher,String> departmentNameColumn = new TableColumn<>("Department");
        departmentNameColumn.setMinWidth(tableWidth);
        departmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        this.getColumns().add(departmentNameColumn);


        TableColumn<Teacher, String> fullNameColumn = new TableColumn<>("Teacher\n name:");
        fullNameColumn.setPrefWidth(tableWidth);
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        this.getColumns().add(fullNameColumn);


        TableColumn<Teacher,String> academicRankColumn = new TableColumn<>("Academic\n rank");
        academicRankColumn.setPrefWidth(tableWidth);
        academicRankColumn.setCellValueFactory(new PropertyValueFactory<>("academicRank"));
        this.getColumns().add(academicRankColumn);


        TableColumn<Teacher,String> academicDegreeColumn = new TableColumn<>("Academic\n degree");
        academicDegreeColumn.setPrefWidth(tableWidth);
        academicDegreeColumn.setCellValueFactory(new PropertyValueFactory<>("academicDegree"));
        this.getColumns().add(academicDegreeColumn);


        TableColumn<Teacher, String> workExperienceColumn = new TableColumn<>("Work\n experience");
        workExperienceColumn.setPrefWidth(tableWidth);
        workExperienceColumn.setCellValueFactory(new PropertyValueFactory<>("workExperience"));
        this.getColumns().add(workExperienceColumn);
    }
}
