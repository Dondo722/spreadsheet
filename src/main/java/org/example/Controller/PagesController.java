package org.example.Controller;

import org.example.Model.PagesModel;
import org.example.Model.SpreadsheetModel;
import org.example.View.AlertBox;
import org.example.View.Pages;
import org.example.View.SpreadsheetView;

public class PagesController {
    protected static void setController(SpreadsheetView view, SpreadsheetModel model){
        Pages pages = view.getPages();
        pages.getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
        pages.getLabelCount().setText("Teachers: " + model.getList().size());

        pages.getRawsField().setOnAction(e -> {
            if (!(pages.getRawsField().getText().matches(("[a-zA-Z]+$")) || pages.getRawsField().getText().equals(""))
                    || pages.getRawsField().getText().equals(String.valueOf(PagesModel.getRawsCount()))){
                int saveIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() -1);
                PagesModel.setRawsCount(Integer.parseInt(pages.getRawsField().getText()));
                PagesModel.countLastPage(model.getList().size());
                PagesModel.countCurrentPage(saveIndex);
                int fromIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() - 1);
                pages.getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
                int toIndex = Math.min(fromIndex+PagesModel.getRawsCount(),model.getList().size());
                SpreadsheetController.changeTableList(model.getSubList(fromIndex,toIndex));
            }
            else {
                AlertBox.display();
                pages.getRawsField().setText(String.valueOf(PagesModel.getRawsCount()));
            }

        });
        pages.getButtonFirst().setOnAction(e -> {
            PagesModel.setCurrentPage(1);
            int fromIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() - 1);
            int toIndex = Math.min(fromIndex + PagesModel.getRawsCount(), model.getList().size());
            SpreadsheetController.changeTableList(model.getSubList(fromIndex, toIndex));

            pages.getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());

        });
        pages.getButtonPrevious().setOnAction(e -> {

            if(PagesModel.getCurrentPage() != 1) {
                PagesModel.setCurrentPage(PagesModel.getCurrentPage() - 1);
                int fromIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() - 1);
                int toIndex = Math.min(fromIndex + PagesModel.getRawsCount(), model.getList().size());
                SpreadsheetController.changeTableList(model.getSubList(fromIndex, toIndex));

                pages.getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
            }

        });
        pages.getButtonNext().setOnAction(e -> {
            if(PagesModel.getCurrentPage() != PagesModel.getLastPage()){
                PagesModel.setCurrentPage(PagesModel.getCurrentPage() + 1);
                int fromIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() - 1);
                int toIndex = Math.min(fromIndex+PagesModel.getRawsCount(),model.getList().size());
                SpreadsheetController.changeTableList(model.getSubList(fromIndex,toIndex));

                pages.getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
            }
        });

        pages.getButtonLast().setOnAction(e -> {
            PagesModel.setCurrentPage(PagesModel.getLastPage());
            int fromIndex = PagesModel.getRawsCount() * (PagesModel.getCurrentPage() - 1);
            int toIndex = Math.min(fromIndex + PagesModel.getRawsCount(), model.getList().size());
            SpreadsheetController.changeTableList(model.getSubList(fromIndex, toIndex));

            pages.getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
        });
    }
    protected static void update(SpreadsheetView view, SpreadsheetModel model){
        PagesModel.countLastPage(model.getList().size());
        view.getPages().getLabelCount().setText("Teachers: " + model.getList().size());
        view.getPages().getLabelCurrentPage().setText(PagesModel.getCurrentPage() + " / " + PagesModel.getLastPage());
    }
}
