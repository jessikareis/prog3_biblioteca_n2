package br.edu.femass.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.EmprestimoDao;
import br.edu.femass.model.Emprestimo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmprestismoController implements Initializable {

    @FXML
    private ComboBox<Emprestimo> comboBoxLivro;

    @FXML
    private ComboBox<Emprestimo> comboBoxExemplar;

    @FXML
    private ComboBox<Emprestimo> comboBoxLeitor;

    @FXML
    private CheckBox checkBoxAluno;

    @FXML
    private CheckBox checkBoxProfessor;

    @FXML
    private DatePicker dateEmprestimo;

    @FXML
    private TextField txtDataDevolucao;

    @FXML
    private Button BtnSalvarEmprestimo;

    @FXML
    private TableView<Emprestimo> tableListaEmprestimos = new TableView<Emprestimo>();

    @FXML
    private TableColumn<Emprestimo, Long> colIdEmprestimo = new TableColumn<>();

    @FXML
    private TableColumn<Emprestimo, String> colNomeEmprestimo = new TableColumn<>();

    @FXML
    private TableColumn<Emprestimo, String> colDataEmprestimo = new TableColumn<>();

    @FXML
    private Button BtnRemoverEmprestimo;

    @FXML
    private ListView listaAtrasados;

    private EmprestimoDao dao_emprestimo = new EmprestimoDao();
    private Emprestimo emprestimo;

    private Boolean incluindo;

    @FXML
    private void btnSalvarEmprestimo_Click(ActionEvent event) {
        // Implementação básica para salvar o empréstimo
        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setLivro(comboBoxLivro.getSelectionModel().getSelectedItem());
        novoEmprestimo.setExemplar(comboBoxExemplar.getSelectionModel().getSelectedItem());
        novoEmprestimo.setLeitor(comboBoxLeitor.getSelectionModel().getSelectedItem());
        novoEmprestimo.setDataEmprestimo(dateEmprestimo.getValue());
        novoEmprestimo.setDataDevolucao(txtDataDevolucao.getText());

        // Emprestimo.setLivro(comboBoxLivro.getSelectionModel());
        // Emprestimo.setExemplar(comboBoxExemplar.getSelectionModel());
        // Emprestimo.setLeitor(comboBoxLeitor.getSelectionModel());
        // Emprestimo.setDataEmprestimo(dateEmprestimo.getValue());
        // Emprestimo.setDataDevolucao(txtDataDevolucao.getText());

        if (incluindo) {
            // dao.inserir(emprestimo);
        } else {
            // dao.alterar(emprestimo);
        }

        preencherTableEmprestimos();
        preencherListaAtrasados();

    }

    // @FXML
    // private void excluir_click(ActionEvent event) {
    // dao.apagar(emprestimo);
    // preencherTableEmprestimos();
    // preencherListaAtrasados();
    // }

    @FXML
    private void btnRemoverEmprestimo_Click(ActionEvent event) {
        Emprestimo emprestimoSelecionado = tableListaEmprestimos.getSelectionModel().getSelectedItem();

        if (emprestimoSelecionado != null) {
            dao_emprestimo.apagar(emprestimoSelecionado);
            preencherTableEmprestimos();
            preencherListaAtrasados();
        }
    }

    private void preencherListaAtrasados() {
        List<Emprestimo> emprestimosAtrasados = new ArrayList<>();

        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimosAtrasados);
        listaAtrasados.setItems(data);
    }

    private void preencherTableEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<>();

        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
        tableListaEmprestimos.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdEmprestimo.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, Long>("id"));

        colNomeEmprestimo.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, String>("nome"));

        preencherTableEmprestimos();
        preencherListaAtrasados();

        System.out.println("Passei aqui");
    }

}
