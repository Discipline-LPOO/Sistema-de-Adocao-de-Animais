module br.edu.ifpr {
    // javaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    // JPA e hibernate
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    requires static lombok;
    requires java.desktop;

    // Acessos
    opens br.edu.ifpr to javafx.fxml;
    exports br.edu.ifpr;

    opens br.edu.ifpr.menu to javafx.fxml;
    exports br.edu.ifpr.menu;

    opens br.edu.ifpr.adotante to org.hibernate.orm.core;
    opens br.edu.ifpr.adocao to org.hibernate.orm.core;
    opens br.edu.ifpr.animal to org.hibernate.orm.core;
    opens br.edu.ifpr.apelido to org.hibernate.orm.core;
    opens br.edu.ifpr.documentoIdentidade to org.hibernate.orm.core;
    opens br.edu.ifpr.documentoResidencia to org.hibernate.orm.core;
    opens br.edu.ifpr.doenca to org.hibernate.orm.core;
    opens br.edu.ifpr.especie to org.hibernate.orm.core;
    opens br.edu.ifpr.vacina to org.hibernate.orm.core;

}
