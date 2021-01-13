package org.upskill.listatarefas.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.upskill.listatarefas.controller.AplicacaoController;

public class MainApp extends Application {

    private AplicacaoController appController;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Lista de Tarefas");
        stage.setScene(scene);

        stage.sizeToScene();
        stage.setResizable(false);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, "Lista de Tarefas",
                            "Confirmação da ação.", "Deseja mesmo encerrar a aplicação?");
                    
                    if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                        event.consume();
                    }
                }
            });
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
