package org.example.Controller;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.Model.CustomPeriod;
import org.example.Model.SpreadsheetModel;
import org.example.Model.Teacher;
import org.example.View.AddBox;
import org.example.View.DeleteBox;
import org.example.View.SearchBox;
import org.example.View.SpreadsheetView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainMenuController {
    protected static void setController(SpreadsheetView view, SpreadsheetModel model){
        view.getMainMenu().getOpenItem().setOnAction(e -> MainMenuController.openAndSaveDialogs(view,model,false));
        view.getMainMenu().getSaveItem().setOnAction(e -> MainMenuController.openAndSaveDialogs(view,model,true));
        view.getMainMenu().getAddItem().setOnAction(e -> MainMenuController.addBox(view, model));
        view.getMainMenu().getFindItem().setOnAction(e -> MainMenuController.searchBox(model));
        view.getMainMenu().getDeleteItem().setOnAction(e -> MainMenuController.deleteBox(view, model));
    }

    protected static void openAndSaveDialogs(SpreadsheetView view,SpreadsheetModel model,boolean saveCase){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("saves"));
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("xml file","*.xml");
        fileChooser.getExtensionFilters().add(extensionFilter);

        try{
            if(saveCase){
                File file = fileChooser.showSaveDialog(new Stage());
                MainMenuController.saveDataToFile(file,model);
            }
            else{
                File file = fileChooser.showOpenDialog(new Stage());
                MainMenuController.getDataFromFile(file,model);
            }
        }
        catch (Exception ex) {System.out.println(ex.getMessage());}
        PagesController.update(view, model.getList());
    }

    protected static void addBox(SpreadsheetView view, SpreadsheetModel model){
        AddBox addBox = new AddBox();
        AddBoxController.setController(addBox, view, model);
        addBox.display();
    }

    protected static void searchBox(SpreadsheetModel model){
        SearchBox searchBox = new SearchBox();
        SearchBoxController.setController(searchBox, model);
        searchBox.display();
    }

    protected static void deleteBox(SpreadsheetView view, SpreadsheetModel model){
        DeleteBox deleteBox = new DeleteBox();
        DeleteBoxController.setController(deleteBox,view, model);
        deleteBox.display();
    }

    private static void saveDataToFile(File file, SpreadsheetModel model) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        for(Teacher teacher: model.getList()){
            Element element = document.createElement("teacher");
            root.appendChild(element);
            for (int i = 0 ; i < Teacher.getNamesVal().length; i++){
                element.setAttribute(Teacher.getNamesVal()[i],teacher.getValuesByName(Teacher.getNamesVal()[i]));
            }
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(file)));
    }

    private static void getDataFromFile(File file, SpreadsheetModel model) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler handler = new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("teacher")){
                    String faculty = attributes.getValue("faculty");
                    String departmentName = attributes.getValue("departmentName");
                    String fullName = attributes.getValue("fullName");
                    String academicRank = attributes.getValue("academicRank");
                    String academicDegree = attributes.getValue("academicDegree");
                    String workExperience = attributes.getValue("workExperience");

                    Teacher teacher = new Teacher(faculty,departmentName,fullName,academicRank,academicDegree,new CustomPeriod(workExperience));
                    model.getList().add(teacher);
                }
            }
        };
        model.getList().clear();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse(file,handler);
    }
}
