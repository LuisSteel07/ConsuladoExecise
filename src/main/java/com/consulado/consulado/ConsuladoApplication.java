package com.consulado.consulado;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ConsuladoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.changeScene("principal-view.fxml", "Consulado");
    }

    public static void main(String[] args) {
        launch();
    }
}