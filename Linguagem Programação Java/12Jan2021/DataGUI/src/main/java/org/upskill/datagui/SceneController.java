/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.datagui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

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
    private TextField txtData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void actionDiaSemana(ActionEvent event) {
        Data d = validadeData(txtData.getText());
        txtDiaSemana.setText(d.diaDaSemana());
    }

    @FXML
    private void actionDataExtenso(ActionEvent event) {
        Data d = validadeData(txtData.getText());
        txtResult.setText("" + d);
    }

    @FXML
    private void actionLimpar(ActionEvent event) {
        txtDiaSemana.clear();
        txtResult.setText("");
        txtData.clear();
        txtData.requestFocus();
    }

    private Data validadeData(String data) {

        String[] arrSplit = txtData.getText().trim().split("/");
        Data d = new Data();

        try {
            d.setData(Integer.parseInt(arrSplit[0]), Integer.parseInt(arrSplit[1]), Integer.parseInt(arrSplit[2]));
        } catch (MesInvalidoException e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Contador",
                    "Mes Incorreto.", e.getMessage()).show();

        } catch (DiaInvalidoException e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Contador",
                    "Dia Incorreto.", e.getMessage()).show();
            txtData.clear();
        } catch (Exception e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Contador",
                    "Data Invalida.", e.getMessage()).show();
        }

        return d;

    }

    @FXML
    private void OnKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER:
                Data d = validadeData(txtData.getText());
                txtDiaSemana.setText(d.diaDaSemana());
                txtResult.setText("" + d);
        }
    }

}
