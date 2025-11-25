package com.consulado.consulado.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SolicitudController {
    @FXML private TextField codigoField;
    @FXML private TextField nombreField;
    @FXML private TextField pasaporteField;
    @FXML private TextField fechaViajeField;
    @FXML private TextField semanasField;
    @FXML private TextArea motivoField;

    public TextField getCodigoField() {
        return codigoField;
    }

    public void setCodigoField(TextField codigoField) {
        this.codigoField = codigoField;
    }

    public TextField getNombreField() {
        return nombreField;
    }

    public void setNombreField(TextField nombreField) {
        this.nombreField = nombreField;
    }

    public TextField getPasaporteField() {
        return pasaporteField;
    }

    public void setPasaporteField(TextField pasaporteField) {
        this.pasaporteField = pasaporteField;
    }

    public TextField getFechaViajeField() {
        return fechaViajeField;
    }

    public void setFechaViajeField(TextField fechaViajeField) {
        this.fechaViajeField = fechaViajeField;
    }

    public TextField getSemanasField() {
        return semanasField;
    }

    public void setSemanasField(TextField semanasField) {
        this.semanasField = semanasField;
    }

    public TextArea getMotivoField() {
        return motivoField;
    }

    public void setMotivoField(TextArea motivoField) {
        this.motivoField = motivoField;
    }
}
