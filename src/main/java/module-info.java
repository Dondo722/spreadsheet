module org.example {
    requires javafx.controls;
    requires java.xml;
    exports org.example;
    opens org.example.Model;
}