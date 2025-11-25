package com.consulado.consulado.controllers.trabajo;

import clases.Trabajo;
import com.consulado.consulado.controllers.SolicitudController;
import db.TrabajoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

public class InsertViewController extends SolicitudController {
    @FXML private TextField entidadContratadoraField;
    @FXML private TextField tipoTrabajoField;
    @FXML private TextField tarifaHorasField;
    @FXML private TextField horasLaborablesField;

    public void InsertNewTrabajo() throws SQLException {
        Trabajo trabajo = new Trabajo(
                getCodigoField().getText(),
                getNombreField().getText(),
                getPasaporteField().getText(),
                Date.from(Instant.now()),
                Integer.parseInt(getSemanasField().getText()),
                getMotivoField().getText(),
                entidadContratadoraField.getText(),
                tipoTrabajoField.getText(),
                Integer.parseInt(tarifaHorasField.getText()),
                Integer.parseInt(horasLaborablesField.getText()));

        TrabajoDAO.insert(trabajo);
    }
}
