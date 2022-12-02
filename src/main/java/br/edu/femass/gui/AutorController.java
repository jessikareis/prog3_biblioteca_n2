package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.AutorDao;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AutorController implements Initializable {

    @FXML
    private TextField txtAutorNome;

    @FXML
    private TextField txtAutorNacionalidade;

    @FXML
    private TableView<Autor> tableListaAutores = new TableView<Autor>();

    @FXML
    private TableColumn<Autor, Long> colIdAutor = new TableColumn<>();

    @FXML
    private TableColumn<Autor, String> colNomeAutor = new TableColumn<>();

    @FXML
    private TableColumn<Autor, String> colNacionalidadeAutor = new TableColumn<>();

    @FXML
    private Button BtnSalvarAutor;

    @FXML
    private Button BtnRemoverAutor;

    private AutorDao dao = new AutorDao();
    private Autor autor;

    private Boolean incluindo;

    @FXML
    private void btnSalvarAutor_Click(ActionEvent event) {

        autor.setNome(txtAutorNome.getText());
        autor.setNacionalidade(txtAutorNacionalidade.getText());
        
        if (incluindo) {
            dao.inserir(autor);
        } else {
            dao.alterar(autor);
        }

        preencherTableAutores();
    }

    @FXML
    private void btnRemoverAutor_Click(ActionEvent event) {
        dao.apagar(autor);
        preencherTableAutores();
    }

    private void preencherTableAutores(){
        List<Autor> autores = dao.buscarTodosPorId();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        tableListaAutores.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdAutor.setCellValueFactory(
                new PropertyValueFactory<Autor, Long>("id"));

        colNomeAutor.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nome"));

        colNacionalidadeAutor.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nacionalidade"));

        preencherTableAutores();

    }

}
