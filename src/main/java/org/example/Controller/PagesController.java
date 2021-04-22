package org.example.Controller;

import org.example.Model.PagesModel;
import org.example.Model.SpreadsheetModel;
import org.example.View.Alerts.InputAlert;
import org.example.View.Pages;
import org.example.View.SpreadsheetView;

public class PagesController {
    protected static void setController(SpreadsheetView view, SpreadsheetModel model){
        Pages pages = view.getPages();
        updateTeachers(view,model);

        pages.getRawsField().setOnAction(e -> {
            try{
                int saveIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() -1);
                PagesModel.setRawsCount(Integer.parseInt(pages.getRawsField().getText()));
                PagesModel.countLastPage(model.getList().size());
                PagesModel.countCurrentPage(saveIndex);
                newPage(view,model);
            }
            catch (Exception exception) {
                InputAlert.display();
                if(PagesModel.getRawsCount() != -1)pages.getRawsField().setText(String.valueOf(PagesModel.getRawsCount()));
                else pages.getRawsField().clear();
                System.out.println(exception.getMessage());
            }
        });
        pages.getButtonFirst().setOnAction(e -> {
            PagesModel.setCurrentPage(1);
            newPage(view,model);
        });
        pages.getButtonPrevious().setOnAction(e -> {

            if(PagesModel.getCurrentPage() != 1) {
                PagesModel.setCurrentPage(PagesModel.getCurrentPage() - 1);
                newPage(view,model);
            }
        });
        pages.getButtonNext().setOnAction(e -> {
            if(PagesModel.getCurrentPage() != PagesModel.getLastPage()){
                PagesModel.setCurrentPage(PagesModel.getCurrentPage() + 1);
                newPage(view,model);
            }
        });

        pages.getButtonLast().setOnAction(e -> {
            PagesModel.setCurrentPage(PagesModel.getLastPage());
            newPage(view,model);
        });
    }

    private static void newPage(SpreadsheetView view,SpreadsheetModel model){
        int fromIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() - 1);
        int toIndex = Math.min(fromIndex + PagesModel.getRawsCount(), model.getList().size());
        SpreadsheetController.changeTableList(model.getSubList(fromIndex, toIndex));

       updateTeachers(view,model);
    }

    protected static void updateTeachers(SpreadsheetView view, SpreadsheetModel model){
        view.getPages().getLabelCount().setText("Teachers: " + model.getList().size());
        view.getPages().getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
    }

    protected static void update(SpreadsheetView view, SpreadsheetModel model){
        PagesModel.countLastPage(model.getList().size());
        updateTeachers(view, model);
    }
}
