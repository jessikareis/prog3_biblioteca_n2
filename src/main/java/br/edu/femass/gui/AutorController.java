package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AutorController implements Initializable {

    @FXML
    private TextField txtAutorNome;
    @FXML
    private TextField txtAutorNacionalidade;
    @FXML
    private ListView<Autor> ListaAutores;

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

    private DaoAutor dao_autor = new DaoAutor();
    private Autor autor;

    // private Boolean incluindo;

    @FXML
    private void btnSalvarAutor_Click(ActionEvent event) {
        autor = new Autor();
        autor.setNome(txtAutorNome.getText());
        autor.setNacionalidade(txtAutorNacionalidade.getText());

        // if (incluindo) {
        // dao.inserir(autor);
        // } else {
        // dao.alterar(autor);
        // }
        dao_autor.inserir(autor);
        preencherLista();
    }

    // @FXML
    // private void btnRemoverAutor_Click(ActionEvent event) {
    // dao_autor.apagar(autor);
    // preencherLista();
    // }

    @FXML
    private void btnRemoverAutor_Click(ActionEvent event) {
        Autor autorSelecionado = tableListaAutores.getSelectionModel().getSelectedItem();

        if (autorSelecionado != null) {
            dao_autor.apagar(autorSelecionado);
            preencherLista();
        }
    }

    @FXML
    private void tableListaAutores_MouseClicked(MouseEvent event) {
        exibirDados();
    }

    private void exibirDados() {
        this.autor = tableListaAutores.getSelectionModel().getSelectedItem();

        if (autor == null)
            return;

        txtAutorNome.setText(autor.getNome());
        txtAutorNacionalidade.setText(autor.getNacionalidade());

    }

    private void preencherLista() {
        List<Autor> autores = dao_autor.buscarTodosPorId();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        tableListaAutores.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // System.out.println(1);
        colIdAutor.setCellValueFactory(
                new PropertyValueFactory<Autor, Long>("id"));

        colNomeAutor.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nome"));

        colNacionalidadeAutor.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nacionalidade"));

        preencherLista();
    }

}
