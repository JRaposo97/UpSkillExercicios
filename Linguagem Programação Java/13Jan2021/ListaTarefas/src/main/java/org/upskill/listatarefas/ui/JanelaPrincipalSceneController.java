package org.upskill.listatarefas.ui;

import java.io.File;
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
import javafx.stage.FileChooser;
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

    private static final String CABECALHO_IMPORTAR = "Importar Lista.";
    private static final String CABECALHO_EXPORTAR = "Exportar Lista.";

    private static final int SERIALIZACAO = 1;
    private static final String DESCRICAO_SERIALIZACAO = "ListaTarefas";
    private static final String EXTENSAO_SERIALIZACAO = "*.ltf";

    private static final int TEXTO = 2;
    private static final String DESCRICAO_TEXTO = "ListaTarefas";
    private static final String EXTENSAO_TEXTO = "*.txt";

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
        exportarLista(TEXTO);
    }

    @FXML
    private void mnuSerializacao(ActionEvent event) {
        importarLista(SERIALIZACAO);
    }

    @FXML
    private void mnuDesserializacao(ActionEvent event) {
        exportarLista(SERIALIZACAO);
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

    private void exportarLista(int tipoFicheiro) {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;

            case TEXTO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
        }

        FileChooser flChooser = FileChooserListaTarefaUI.criarFileChooserListaTelefonica(descricao, extensao);
        File ficheiroExportar = flChooser.showSaveDialog(txtAreaTarefas.getScene().getWindow());

        if (ficheiroExportar != null) {
            boolean gravou = false;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    gravou = appController.serializar(ficheiroExportar);
                    break;

                case TEXTO:
                    gravou = appController.exportarTexto(ficheiroExportar);
                    break;

            }
            if (gravou) {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Lista Tarefas", CABECALHO_EXPORTAR,
                        "Contactos exportados com sucesso.").show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista Tarefas", CABECALHO_EXPORTAR,
                        "Problema a exportar a lista de contactos!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista Tarefas", CABECALHO_EXPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

    private void importarLista(int tipoFicheiro) {
        String descricao, extensao;

        switch (tipoFicheiro) {
            case SERIALIZACAO:
                descricao = DESCRICAO_SERIALIZACAO;
                extensao = EXTENSAO_SERIALIZACAO;
                break;

            case TEXTO:
                descricao = DESCRICAO_TEXTO;
                extensao = EXTENSAO_TEXTO;
                break;

            default:
                throw new IllegalArgumentException("Tipo de ficheiro desconhecido.");
        }

        FileChooser flChooser = FileChooserListaTarefaUI.criarFileChooserListaTelefonica(descricao, extensao);
        File ficheiroImportar = flChooser.showOpenDialog(txtAreaTarefas.getScene().getWindow());

        if (ficheiroImportar != null) {
            int numeroContactosImportados = 0;

            switch (tipoFicheiro) {
                case SERIALIZACAO:
                    numeroContactosImportados = appController.desserializar(ficheiroImportar);
                    break;

                case TEXTO:
                    numeroContactosImportados = appController.importarTexto(ficheiroImportar);
                    break;
            }

            if (numeroContactosImportados > 0) {
                atualizaTextAreaListaTarefas();

                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Lista Tarefas", CABECALHO_IMPORTAR,
                        String.format("%d contacto(s) importado(s).", numeroContactosImportados)).show();
            } else {
                AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Lista Tarefas", CABECALHO_IMPORTAR,
                        "Ficheiro sem contactos telefónicos para importar!").show();
            }
        } else {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Lista Tarefas", CABECALHO_IMPORTAR,
                    "Não foi seleccionado nenhum ficheiro!").show();
        }
    }

}
