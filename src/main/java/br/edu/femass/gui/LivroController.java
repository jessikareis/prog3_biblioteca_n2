package br.edu.femass.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.LivroDao;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LivroController implements Initializable {

    @FXML
    private TextField txtLivro;

    @FXML
    private ComboBox<Livro> comboAutor;

    @FXML
    private DatePicker dateAquisicao;

    @FXML
    private TableView<Livro> tableListaLivros = new TableView<Livro>();

    @FXML
    private TableColumn<Livro, Long> colIdLivros = new TableColumn<>();

    @FXML
    private TableColumn<Livro, String> colLivro = new TableColumn<>();

    @FXML
    private TableColumn<Livro, String> colAutorLivro = new TableColumn<>();

    @FXML
    private Button BtnSalvarLivro;

    @FXML
    private Button BtnRemoverLivro;

    @FXML
    private TableView<Exemplar> tableListaExemplares = new TableView<Exemplar>();

    @FXML
    private TableColumn<Exemplar, Long> colIdExemplar = new TableColumn<>();

    @FXML
    private TableColumn<Exemplar, String> colLivroExemplar = new TableColumn<>();

    @FXML
    private TableColumn<Exemplar, String> colAutorExemplar = new TableColumn<>();

    @FXML
    private Button BtnSalvarExemplar;

    @FXML
    private Button BtnRemoverExemplar;

   // private LivroDao dao = new LivroDao();
    private Livro livro;
    private Exemplar exemplares;

    private Boolean incluindo;

    @FXML
    private void btnSalvarLivro_Click(ActionEvent event) {

        livro.setNome(txtLivro.getText());
       // livro.setAutores(comboAutor.getText());
        
        if (incluindo) {
           // dao.inserir(livro);
        } else {
            //dao.alterar(livro);
        }

        preencherTableLivro();
        preencherTableExemplares();
        preencherListaAutor();
       
    }

    @FXML
    private void btnRemoverLivro_Click(ActionEvent event) {
       // dao.apagar(livro);
        preencherTableLivro();
        preencherTableExemplares();
    }

    @FXML
    private void btnSalvarExemplar_Click(ActionEvent event) {

        livro.setNome(txtLivro.getText());
       // livro.setAutores(comboAutor.getText());
        
        if (incluindo) {
           // dao.inserir(livro);
        } else {
            //dao.alterar(livro);
        }

        preencherTableLivro();
        preencherTableExemplares();
        preencherListaAutor();
       
    }

    @FXML
    private void btnRemoverExemplar_Click(ActionEvent event) {
       // dao.apagar(livro);
        preencherTableLivro();
        preencherTableExemplares();
    }

    private void preencherListaAutor() {
        List<Livro> livros = new ArrayList<>();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
    }

    private void preencherTableLivro() {
       List<Livro> livros = new ArrayList<>();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        tableListaLivros.setItems(data);
    }

    private void preencherTableExemplares() {
        List<Livro> livros = new ArrayList<>();

        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        tableListaExemplares.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdLivros.setCellValueFactory(
                new PropertyValueFactory<Livro, Long>("id"));

        colLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("livro"));

        colAutorLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("autor"));

        colIdExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, Long>("idExemplar"));

                
        System.out.println("Passei aqui3");
        preencherTableLivro();

        
        System.out.println("Passei aqui4");
        preencherTableExemplares();

        
        System.out.println("Passei aqui5");
        preencherListaAutor();

        
        System.out.println("Passei aqui 2");

    }
}
