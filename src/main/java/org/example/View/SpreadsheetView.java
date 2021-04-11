package org.example.View;


import org.example.Model.Teachers;

public class SpreadsheetView {
    private  int sceneWidth;
    private TeacherTable table ;

    public SpreadsheetView(int sceneWidth) {
        this.sceneWidth = sceneWidth;
        this.table = new TeacherTable(sceneWidth);
        this.table.setItems(Teachers.teachers);
    }


    public int getSceneWidth() {
        return sceneWidth;
    }

    public TeacherTable getTable() {
        return table;
    }


    public void setSceneWidth(int sceneWidth) {
        this.sceneWidth = sceneWidth;
    }

    public void setTable(TeacherTable table) {
        this.table = table;
    }

}
