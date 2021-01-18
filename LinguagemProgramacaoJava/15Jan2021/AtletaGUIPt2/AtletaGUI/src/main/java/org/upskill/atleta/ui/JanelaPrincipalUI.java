/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.atleta.ui;

import java.awt.event.ActionListener;
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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import org.upskill.atleta.controller.AppController;
import org.upskill.atleta.model.Atleta;

/**
 * FXML Controller class
 *
 * @author joaor
 */
public class JanelaPrincipalUI implements Initializable {

    private AppController appController;
    private Stage novoAtletaStage;
    private Stage novoAtletaProfissional;

    @FXML
    private MenuItem Amador;
    @FXML
    private MenuItem SemiProfissional;
    @FXML
    private MenuItem Profissional;
    @FXML
    private ListView<Atleta> lstAreaAtletas;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarNovoAtleta.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            novoAtletaStage = new Stage();
            novoAtletaStage.initModality(Modality.APPLICATION_MODAL);
            novoAtletaStage.setTitle("Adicionar Atleta");
            novoAtletaStage.setResizable(false);
            novoAtletaStage.setScene(scene);

            appController = new AppController();
            atualizaLstAreaAtletas();

            
            AdicionarNovoAtletaAmadorUI novoAtletaUI = loader.getController();
            novoAtletaUI.associarParentUI(this);
            
            
            
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/fxml/AdicionarNovoAtletaProfissional.fxml"));
            Parent root1 = loader1.load();

            Scene scene1 = new Scene(root1);

            novoAtletaProfissional = new Stage();
            novoAtletaProfissional.initModality(Modality.APPLICATION_MODAL);
            novoAtletaProfissional.setTitle(MainApp.TITULO_APLICACAO);
            novoAtletaProfissional.setResizable(false);
            novoAtletaProfissional.setScene(scene);

            appController = new AppController();
            atualizaLstAreaAtletas();

            AdicionarNovoAtletaProfissionalUI novoAtletaProfissionalUI = loader1.getController();
            novoAtletaProfissionalUI.associarParentUI(this);
            
            
            
            
            
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, MainApp.TITULO_APLICACAO, "Erro.", ex.getMessage());
        }
    }

    public AppController getAplicacaoController() {
        return appController;
    }

    @FXML
    private void mnuNewAmador(ActionEvent event) {
        novoAtletaStage.show();
    }

    @FXML
    private void mnuNewSemiProfissional(ActionEvent event) {
        novoAtletaStage.show();
    }

    @FXML
    private void mnuNewProfissional(ActionEvent event) {
        novoAtletaProfissional.show();
    }

    @FXML
    private void mnuSair(ActionEvent event) {
        Window window = lstAreaAtletas.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void atualizaLstAreaAtletas() {
        lstAreaAtletas.setItems(appController.getListaAtletas());
    }

}
