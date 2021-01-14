package org.upskill.listatarefas.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import org.upskill.listatarefas.controller.AplicacaoController;

public class JanelaPrincipalSceneController implements Initializable {

    private AplicacaoController appController = new AplicacaoController();
    private Stage novaTarefaStage;

    @FXML
    private Button btnAdicionarTarefas;
    @FXML
    private Button btnLimparTarefas;
    @FXML
    private TextArea txtAreaTarefas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);
            novaTarefaStage.setTitle("Novo Tarefa");
            novaTarefaStage.setResizable(false);
            novaTarefaStage.setScene(scene);

            atualizaTextAreaListaTarefas();

            AdicionarTarefaSceneController novaTarefaUI = loader.getController();
            novaTarefaUI.setCmbPrioridade();
            novaTarefaUI.associarParentUI(this);
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista de Tarefas", "Erro.", ex.getMessage());
        }
    }

    public void atualizaTextAreaListaTarefas() {
        txtAreaTarefas.setText(appController.getListaTarefas());
    }

    public AplicacaoController getAplicacaoController() {
        return appController;
    }

    @FXML
    private void adicionarTarefaAction(ActionEvent event) throws IOException {
        atualizaTextAreaListaTarefas();
        novaTarefaStage.show();
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
        try {
            appController.eliminarTarefas();
            atualizaTextAreaListaTarefas();
        } catch (IllegalArgumentException e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista de Tarefas", "Erro.", "Não Pode limpar porque não ha tarefas");
        }

    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {

        if (event.isControlDown()) {
            switch (event.getCode()) {
                case Z:
                    if (appController.listaVazia()) {
                        AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista de Tarefas", "Erro.", "Não Pode limpar porque não ha tarefas");
                    } else {
                        appController.eliminarUltimaTarefa();
                        atualizaTextAreaListaTarefas();
                    }
                case O:
                    if (appController.listaVazia()) {
                        AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista de Tarefas", "Erro.", "Não Pode ordenar uma lista vazia");
                    } else {
                        txtAreaTarefas.setText(appController.getListaTarefas());
                    }

                case P:
                    if (appController.listaVazia()) {
                        AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista de Tarefas", "Erro.", "Não Pode ordenar uma lista vazia");
                    } else {
                        txtAreaTarefas.setText(appController.getListaTarefas());
                    }
            }
        }

    }

    @FXML
    private void mnuGuardarComoTexto(ActionEvent event) {
    }

    @FXML
    private void mnuSerializacao(ActionEvent event) {
    }

    @FXML
    private void mnuDesserializacao(ActionEvent event) {
    }

    @FXML
    private void mnuSair(ActionEvent event) {
        Window window = txtAreaTarefas.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void mnuAdicionarTarefa(ActionEvent event) {
        atualizaTextAreaListaTarefas();
        novaTarefaStage.show();
    }

}
