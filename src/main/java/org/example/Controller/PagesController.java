package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.PagesModel;
import org.example.Model.Teacher;
import org.example.View.Alerts.InputAlert;
import org.example.View.Page.Pageable;
import org.example.View.Page.Pages;

public class PagesController {
    private static PagesModel pagesModel;
    private static Pages pages;

    protected static void setController(Pageable view, ObservableList<Teacher> list){
        pages = view.getPages();
        pagesModel = new PagesModel();

        updateTeachers(view,list);

        pages.getRawsField().setOnAction(e -> {
            if(list.size() == 0) {
                pages.getRawsField().clear();
                pagesModel.setRawsCount(-1);
                return;
            }
            try{
                if(Integer.parseInt(pages.getRawsField().getText()) <= 0)
                    throw new Exception();
                countPage(view, list);
                updateTeachers(view,list);
            }
            catch (Exception exception) {
                InputAlert.display();
                if(pagesModel.getRawsCount() != -1)pages.getRawsField().setText(String.valueOf(pagesModel.getRawsCount()));
                else pages.getRawsField().clear();
                System.out.println(exception.getMessage());
            }
        });
        pages.getButtonFirst().setOnAction(e -> {
            if(list.size() == 0) return;
            pagesModel.setCurrentPage(1);
            updateTeachers(view,list);
        });
        pages.getButtonPrevious().setOnAction(e -> {
            if(list.size() == 0) return;
            if(pagesModel.getCurrentPage() != 1) {
                pagesModel.setCurrentPage(pagesModel.getCurrentPage() - 1);
                updateTeachers(view,list);
            }
        });
        pages.getButtonNext().setOnAction(e -> {
            if(list.size() == 0) return;
            if(pagesModel.getCurrentPage() != pagesModel.getLastPage()){
                pagesModel.setCurrentPage(pagesModel.getCurrentPage() + 1);
                updateTeachers(view,list);
            }
        });

        pages.getButtonLast().setOnAction(e -> {
            if(list.size() == 0) return;
            pagesModel.setCurrentPage(pagesModel.getLastPage());
            updateTeachers(view,list);
        });
    }



    public static void countPage(Pageable view, ObservableList<Teacher> list){
        int saveIndex = pagesModel.getRawsCount() * (pagesModel.getCurrentPage() -1);
        pagesModel.setRawsCount(Integer.parseInt(view.getPages().getRawsField().getText()));
        pagesModel.countLastPage(list.size());
        pagesModel.countCurrentPage(saveIndex);
    }

    private static void newPage(Pageable pageable, ObservableList<Teacher> list){
        int fromIndex = pagesModel.getRawsCount() * (pagesModel.getCurrentPage() - 1);
        int toIndex = Math.min(fromIndex + pagesModel.getRawsCount(), list.size());
        SpreadsheetController.changeTableList(pageable,FXCollections.observableArrayList(list.subList(fromIndex, toIndex)));
    }

    protected static void updateTeachers(Pageable pageable, ObservableList<Teacher> list){
        if(pagesModel.getRawsCount() != -1) newPage(pageable, list);
        pageable.getPages().getLabelCount().setText("Teachers: " + list.size());
        pageable.getPages().getLabelCurrentPage().setText(pagesModel.getCurrentPage() + " / " + pagesModel.getLastPage());
    }

    protected static void update(Pageable view, ObservableList<Teacher> list){
        pagesModel.countLastPage(list.size());
        if(pagesModel.getRawsCount() == -1){
            System.out.println("if");
            updateTeachers(view, list);
            System.out.println("pagesModel.getRawsCount()" + pagesModel.getRawsCount());
            System.out.println("pagesModel.getLastPage()" + pagesModel.getLastPage());
            System.out.println("pagesModel.getCurrentPage()" + pagesModel.getCurrentPage());

        }
        else{
            System.out.println("else");
            newPage(view, list);
        }
    }
    public static void setFirstPage(Pageable view,ObservableList<Teacher> list) {
        if(list.size() == 0) return;
        pagesModel.setCurrentPage(1);
        updateTeachers(view,list);
    }

}
