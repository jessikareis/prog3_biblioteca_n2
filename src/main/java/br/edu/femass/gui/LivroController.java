package br.edu.femass.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.dao.ExemplarDao;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Autor;
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
import javafx.scene.input.MouseEvent;

public class LivroController implements Initializable {

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtCod;

    @FXML
    private ComboBox<Autor> comboAutor;

    @FXML
    private DatePicker dateAquisicao;

    @FXML
    private TableView<Livro> tableListaLivros = new TableView<Livro>();

    @FXML
    private TableColumn<Livro, Long> colIdLivro = new TableColumn<>();

    @FXML
    private TableColumn<Livro, String> colTituloLivro = new TableColumn<>();

    @FXML
    private TableColumn<Livro, Autor> colAutorLivro = new TableColumn<>();

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

    private DaoLivro dao_livro = new DaoLivro();
    private ExemplarDao dao_exemplar = new ExemplarDao();
    private DaoAutor dao_autor = new DaoAutor();
    private Livro livros;
    private Exemplar exemplares;
    private Autor autores;
    private String titulo;

    private Boolean incluindo;

    @FXML
    private void btnSalvarLivro_Click(ActionEvent event) {
        livros = new Livro();
        livros.setTitulo(txtTitulo.getText());
        dao_livro.inserir(livros);

        autores = new Autor();
        autores = comboAutor.getValue();
        autores.adicionarLivros(titulo, 0, autores);
        dao_autor.alterar(autores);

        Autor c = new Autor();
        c = comboAutor.getValue();
        c.adicionarLivros(txtTitulo.getText(), Long.parseLong(txtCod.getText()), c);
        dao_autor.alterar(c);

        // if (incluindo) {
        // dao.inserir(livros);
        // } else {
        // dao.alterar(livros);
        // }

        preencherTableLivro();
        preencherTableExemplares();
        preencherListaAutor();

    }

    @FXML
    private void btnRemoverLivro_Click(ActionEvent event) {
        Livro livroSelecionado = tableListaLivros.getSelectionModel().getSelectedItem();

        if (livroSelecionado != null) {
            dao_livro.apagar(livroSelecionado);
            preencherTableLivro();
            preencherTableExemplares();
        }
    }

    // {
    // dao.apagar(livros);
    // preencherTableLivro();
    // preencherTableExemplares();
    // }

    @FXML
    private void btnSalvarExemplar_Click(ActionEvent event) {
        livros.setTitulo(txtTitulo.getText());

        if (incluindo) {
            dao_livro.inserir(livros);
        } else {
            dao_livro.alterar(livros);
        }

        preencherTableLivro();
        preencherTableExemplares();
        preencherListaAutor();

    }

    @FXML
    private void btnRemoverExemplar_Click(ActionEvent event) {
        Exemplar exemplarSelecionado = tableListaExemplares.getSelectionModel().getSelectedItem();

        if (exemplarSelecionado != null) {
            dao_exemplar.apagar(exemplarSelecionado);
            preencherTableLivro();
            preencherTableExemplares();
        }
    }

    // {
    // dao_livro.apagar(livros);
    // preencherTableLivro();
    // preencherTableExemplares();
    // }

    // @FXML
    // private void tableListaLivros_MouseClicked(MouseEvent event) {
    // exibirDados();
    // }

    // private void exibirDados() {
    // this.livros = tableListaLivros.getSelectionModel().getSelectedItem();

    // if (livros == null)
    // return;

    // txtTitulo.setText(livros.getTitulo());
    // comboAutor.setText(livros.());

    // }

    private void preencherListaAutor() {
        List<Autor> autores = dao_autor.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        comboAutor.setItems(data);
    }

    private void preencherTableLivro() {
        List<Livro> livros = dao_livro.buscarTodosPorId();

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
        colIdLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, Long>("id"));

        colTituloLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("titulo"));

        colAutorLivro.setCellValueFactory(
                new PropertyValueFactory<Livro, Autor>("autores"));

        colIdExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, Long>("idExemplar"));

        colLivroExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, String>("livroExemplar"));

        colAutorExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, String>("autorExemplar"));
        // System.out.println("Passei aqui");
        preencherTableLivro();
        preencherTableExemplares();
        preencherListaAutor();
    }
}
