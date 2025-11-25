module com.consulado.consulado {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires io.github.cdimascio.dotenv.java;
    requires java.sql;

    opens com.consulado.consulado to javafx.fxml;
    exports com.consulado.consulado;
    exports com.consulado.consulado.controllers;
    exports clases;
    exports enums;
    opens com.consulado.consulado.controllers to javafx.fxml;
    opens com.consulado.consulado.controllers.trabajo to javafx.fxml;
}