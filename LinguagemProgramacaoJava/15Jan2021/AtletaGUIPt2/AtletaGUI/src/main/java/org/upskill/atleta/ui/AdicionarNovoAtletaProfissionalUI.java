/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.atleta.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.upskill.atleta.controller.AppController;

/**
 * FXML Controller class
 *
 * @author joaor
 */
public class AdicionarNovoAtletaProfissionalUI implements Initializable {

    private JanelaPrincipalUI janelaPrincipalUI;

    @FXML
    private Button txtBtnSeguinte;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtNIC;
    @FXML
    private DatePicker dateNascimento;
    @FXML
    private DatePicker dateRegisto;
    @FXML
    private ComboBox<?> cmbGenero;
    @FXML
    private ComboBox<?> cmbAtividade;
    @FXML
    private TextField txtFCR;
    @FXML
    private TextField txtSalario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnSeguinteAction(ActionEvent event) {
        try {
            AppController appController = janelaPrincipalUI.getAplicacaoController();

            boolean adicionou = appController.adicionarAtletaProfissional(txtNome.getText(),
                    Integer.parseInt(txtNIC.getText()),
                    dateNascimento.getValue().getDayOfMonth(),
                    dateNascimento.getValue().getMonthValue() - 1,
                    dateNascimento.getValue().getYear(),
                    cmbGenero.getValue().toString(),
                    cmbAtividade.getValue().toString(),
                    Integer.parseInt(txtFCR.getText()),
                    dateRegisto.getValue().getDayOfMonth(),
                    dateRegisto.getValue().getMonthValue() - 1,
                    dateRegisto.getValue().getYear(),
                    Integer.parseInt(txtSalario.getText()));
            if (adicionou) {
                janelaPrincipalUI.atualizaLstAreaAtletas();
            }

            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.TITULO_APLICACAO, "Adicionar Novo Atleta Profissional.",
                    adicionou ? "Atleta Profissional adicionado com sucesso."
                            : "Não foi possível adicionar o contacto.").show();

            encerrarAdicionarNovoAtletaProfissionalUI(event);
        } catch (NumberFormatException nfe) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro nos dados.",
                    "Introduza valores numericos no devido sitio!").show();
        } catch (IllegalArgumentException iae) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro nos dados.",
                    iae.getMessage()).show();
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        encerrarAdicionarNovoAtletaProfissionalUI(event);
    }

    private void encerrarAdicionarNovoAtletaProfissionalUI(ActionEvent event) {
        this.txtNome.clear();
        this.txtNIC.clear();
        this.dateNascimento.getEditor().clear();
        this.dateRegisto.getEditor().clear();
        this.cmbGenero.getSelectionModel().clearSelection();
        this.cmbAtividade.getSelectionModel().clearSelection();
        this.txtSalario.clear();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    void associarParentUI(JanelaPrincipalUI aThis) {
        this.janelaPrincipalUI = janelaPrincipalUI;
    }

}
