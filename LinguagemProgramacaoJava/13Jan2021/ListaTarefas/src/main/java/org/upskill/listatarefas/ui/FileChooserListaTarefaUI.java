package org.upskill.listatarefas.ui;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserListaTarefaUI {

    private FileChooser fileChooser;

    private FileChooserListaTarefaUI(String descricao, String extensao) {
        fileChooser = new FileChooser();

        associarFiltro(descricao, extensao);
    }

    public static FileChooser criarFileChooserListaTarefa(String descricao, String extensao) {
        FileChooserListaTarefaUI fcListaTarefa = new FileChooserListaTarefaUI(descricao, extensao);

        return fcListaTarefa.fileChooser;
    }

    private void associarFiltro(String descricao, String extensao) {
        ExtensionFilter filtro = new ExtensionFilter(descricao, extensao);
        fileChooser.getExtensionFilters().add(filtro);
    }
}
