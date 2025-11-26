package com.consulado.consulado.controllers;

import clases.Solicitud;
import com.consulado.consulado.SceneManager;
import db.SolicitudesDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.Date;

public class PrincipalViewController {
    @FXML
    private TableView<Solicitud> tableSolicitudes;
    @FXML
    private TableColumn<Solicitud, String> codigoCol;
    @FXML
    private TableColumn<Solicitud, String> nombreCol;
    @FXML
    private TableColumn<Solicitud, String> pasaporteCol;
    @FXML
    private TableColumn<Solicitud, Date> fechaViajeCol;
    @FXML
    private TableColumn<Solicitud, Integer> semanasCol;
    @FXML
    private TableColumn<Solicitud, String> motivoCol;

    public void initialize() throws SQLException {
        codigoCol.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        pasaporteCol.setCellValueFactory(new PropertyValueFactory<>("Pasaporte"));
        fechaViajeCol.setCellValueFactory(new PropertyValueFactory<>("FechaViaje"));
        semanasCol.setCellValueFactory(new PropertyValueFactory<>("Semanas"));
        motivoCol.setCellValueFactory(new PropertyValueFactory<>("Motivo"));

        ObservableList<Solicitud> solicitudes = FXCollections.observableList(SolicitudesDAO.listAll());
        tableSolicitudes.setItems(solicitudes);
    }

    public void goToInsertTrabajo() {
        SceneManager.changeScene("trabajo/insert-view.fxml", "Insertando Nueva Visa Trabajo");
    }
}
