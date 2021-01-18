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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author joaor
 */
public class AdicionarNovoAtletaSemiProfissionalUI implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSeguinteAction(ActionEvent event) {
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
    }
    
}
