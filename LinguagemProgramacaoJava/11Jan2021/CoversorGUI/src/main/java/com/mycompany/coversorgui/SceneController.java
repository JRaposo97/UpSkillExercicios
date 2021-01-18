/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coversorgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author joaor
 */
public class SceneController implements Initializable {

    @FXML
    private TextField txtCelcius;
    @FXML
    private TextField txtFahrenheit;
    @FXML
    private Button btnConverter;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionConverter(ActionEvent event) {
    }

    @FXML
    private void actionLimpar(ActionEvent event) {
    }

    @FXML
    private void actonSair(ActionEvent event) {
    }
    
}
