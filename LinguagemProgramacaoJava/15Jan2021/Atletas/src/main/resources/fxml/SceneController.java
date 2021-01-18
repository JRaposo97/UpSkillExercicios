/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.mycompany.controller.AppController;
import com.mycompany.model.Atleta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author joaor
 */
public class SceneController implements Initializable {

    private AppController appController;
    private Stage novoAtletaStageAmador;
    private Stage novoAtletaProfissional;
    private Stage novoAtletaSemiProfissional;

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
        
    }

    public AppController getAplicacaoController() {
        return appController;
    }

    @FXML
    private void mnuNewAmador(ActionEvent event) {
        novoAtletaStageAmador.show();
    }

    @FXML
    private void mnuNewSemiProfissional(ActionEvent event) {
        novoAtletaSemiProfissional.show();
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
