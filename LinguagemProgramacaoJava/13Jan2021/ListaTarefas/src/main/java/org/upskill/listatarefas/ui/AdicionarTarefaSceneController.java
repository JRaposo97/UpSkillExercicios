package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Prioridade;

public class AdicionarTarefaSceneController implements Initializable {

    private JanelaPrincipalSceneController janelaPrincipalUI;

    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<Prioridade> cmbPrioridade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * @return the cmbPrioridade
     */
    public ComboBox<Prioridade> getCmbPrioridade() {
        return cmbPrioridade;
    }

    /**
     * @param cmbPrioridade the cmbPrioridade to set
     */
    public void setCmbPrioridade() {
        cmbPrioridade.getItems().addAll(Prioridade.getPrioridades());
    }

    public void associarParentUI(JanelaPrincipalSceneController janelaPrincipalUI) {
        this.janelaPrincipalUI = janelaPrincipalUI;
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        try {
            AplicacaoController appController = janelaPrincipalUI.getAplicacaoController();

            boolean adicionou = appController.adicionarTarefa(txtTarefa.getText().trim(),
                    cmbPrioridade.getValue());

            if (adicionou) {
                janelaPrincipalUI.atualizaTextAreaListaTarefas();
            }

            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Lista De Tarefas", "Adicionar nova Tarefa.",
                    adicionou ? "Tarefa adicionada com sucesso."
                            : "Não foi possível adicionar o contacto.").show();

            encerrarNovaTarefaUI(event);
        } catch (IllegalArgumentException iae) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista de Tarefas", "Erro nos dados.",
                    iae.getMessage()).show();
        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        encerrarNovaTarefaUI(event);
    }

    private void encerrarNovaTarefaUI(ActionEvent event) {
        this.txtTarefa.clear();
        getCmbPrioridade().getSelectionModel().clearSelection();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
