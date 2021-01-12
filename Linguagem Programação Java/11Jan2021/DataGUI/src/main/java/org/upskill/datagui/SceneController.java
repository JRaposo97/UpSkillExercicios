/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.datagui;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.converter.DateStringConverter;

import org.upskill.datagui.model.Data;
import org.upskill.datagui.model.DiaInvalidoException;
import org.upskill.datagui.model.MesInvalidoException;

/**
 * FXML Controller class
 *
 *
 */
public class SceneController implements Initializable {

    @FXML
    private TextArea txtDiaSemana;
    @FXML
    private Text txtResult;
    @FXML
    private DatePicker dpDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void actionDiaSemana(ActionEvent event) {
        dpDate.getValue().getYear();
        Data d = new Data(dpDate.getValue().getYear(), dpDate.getValue().getMonthValue(), dpDate.getValue().getDayOfMonth());
        txtDiaSemana.setText(d.diaDaSemana());
    }

    @FXML
    private void actionDataExtenso(ActionEvent event) {
        dpDate.getValue().getYear();
        Data d = new Data(dpDate.getValue().getYear(), dpDate.getValue().getMonthValue(), dpDate.getValue().getDayOfMonth());
        txtResult.setText("" + d);
    }

    @FXML
    private void actionLimpar(ActionEvent event) {
        txtDiaSemana.clear();
        txtResult.setText("");
        dpDate.getEditor().clear();
        dpDate.requestFocus();
    }

    @FXML
    private void enter(javafx.scene.input.KeyEvent event) {
        dpDate.getValue().getYear();
        Data d = new Data(dpDate.getValue().getYear(), dpDate.getValue().getMonthValue(), dpDate.getValue().getDayOfMonth());
        txtDiaSemana.setText(d.diaDaSemana());
        txtResult.setText("" + d);
    }

}
