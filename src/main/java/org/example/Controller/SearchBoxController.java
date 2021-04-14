package org.example.Controller;

import org.example.Model.SpreadsheetModel;
import org.example.View.SearchBox;
import org.example.View.SearchBoxes.NameSearchBox;
import org.example.View.SearchBoxes.RankSearchBox;
import org.example.View.SpreadsheetView;

public class SearchBoxController {
    protected static void setController(SearchBox searchBox, SpreadsheetView view, SpreadsheetModel model){
        searchBox.getItemName().setOnAction(e -> {
            NameSearchBox nameSearchBox = new NameSearchBox();
            searchBox.addBot(nameSearchBox);
            nameSearchBox.getTeacherName().setOnAction(eq -> System.out.println("i work"));
        });
        searchBox.getItemRank().setOnAction(e -> {
            RankSearchBox rankSearchBox = new RankSearchBox();
            searchBox.addBot(rankSearchBox);

        });

//        searchBox.getItemExperience().setOnAction(e -> {});
    }
}
