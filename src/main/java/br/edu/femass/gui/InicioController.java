package br.edu.femass.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioController implements Initializable {

    @FXML
    private void btnLivro_Click(ActionEvent event) {
        preencherLista("Livro");
    }

    @FXML
    private void btnLeitor_Click(ActionEvent event) {
        preencherLista("Leitor");
    }

    @FXML
    private void btnExemplar_Click(ActionEvent event) {
        preencherLista("Exemplar");
    }

    @FXML
    private void btnEmprestimo_Click(ActionEvent event) {
        preencherLista("Emprestimo");
    }

    @FXML
    private void btnAutor_Click(ActionEvent event) {
        preencherLista("Autor");
    }

    private void preencherLista(String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + path + ".fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Cadastro de " + path);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
