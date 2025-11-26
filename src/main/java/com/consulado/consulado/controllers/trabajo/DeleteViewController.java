package com.consulado.consulado.controllers.trabajo;

import com.consulado.consulado.SceneManager;
import db.TrabajoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.security.InvalidParameterException;
import java.sql.SQLException;

public class DeleteViewController {
    @FXML private Label message;
    @FXML private TextField codigoField;

    public void goBack() {
        SceneManager.changeScene("principal-view.fxml", "Principal View");
    }

    public void DeleteTrabajo() {
        try {
            message.setText("");

            if(codigoField.getText().isEmpty()) throw new InvalidParameterException();

            TrabajoDAO trabajoDAO = new TrabajoDAO();

            if(trabajoDAO.getByCode(codigoField.getText()).getCodigo().isEmpty()) throw new InvalidParameterException();

            trabajoDAO.delete(codigoField.getText());

            message.setText("Se elimino la visa");
            message.setStyle("-fx-text-fill: green");

        } catch (SQLException e) {
            message.setText("Ocurrio un error al eliminar.");
            message.setStyle("-fx-text-fill: red");
        } catch (InvalidParameterException invalidParameterException) {
            message.setText("Campo del codigo esta vacio.");
            message.setStyle("-fx-text-fill: red");
        } catch (Exception exception) {
            message.setText(exception.getMessage());
            message.setStyle("-fx-text-fill: red");
        }
    }
}
