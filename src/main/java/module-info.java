module br.edu.ifpr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jakarta.persistence;
    requires static lombok;
    requires java.desktop;

    opens br.edu.ifpr to javafx.fxml;
    exports br.edu.ifpr;

    opens br.edu.ifpr.menu to javafx.fxml;
    exports br.edu.ifpr.menu;
}