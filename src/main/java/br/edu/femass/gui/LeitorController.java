package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.AlunoDao;
import br.edu.femass.dao.ProfessorDao;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Professor;
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

public class LeitorController implements Initializable {

        @FXML
        private TextField txtNome;
        @FXML
        private TextField txtEndereco;
        @FXML
        private TextField txtTelefone;
        @FXML
        private TextField txtExtra;

        @FXML
        private Button BtnSalvarLeitor;

        @FXML
        private TableView<Aluno> tableListaLivros = new TableView<Aluno>();

        @FXML
        private TableColumn<Aluno, Long> colIdAluno = new TableColumn<>();

        @FXML
        private TableColumn<Aluno, String> colMatriculaAluno = new TableColumn<>();

        @FXML
        private TableColumn<Aluno, String> colNomeAluno = new TableColumn<>();

        @FXML
        private TableColumn<Aluno, String> colEnderecoAluno = new TableColumn<>();

        @FXML
        private TableColumn<Aluno, String> colTelAluno = new TableColumn<>();

        @FXML
        private Button BtnRemoverAluno;

        @FXML
        private TableView<Professor> tableListaProfessores = new TableView<Professor>();

        @FXML
        private TableColumn<Professor, Long> colIdProfessor = new TableColumn<>();

        @FXML
        private TableColumn<Professor, String> colDisciplinaProfessor = new TableColumn<>();

        @FXML
        private TableColumn<Professor, String> colNomeProfessor = new TableColumn<>();

        @FXML
        private TableColumn<Professor, String> colEnderecoProfessor = new TableColumn<>();

        @FXML
        private TableColumn<Professor, String> colTelefoneProfessor = new TableColumn<>();
        @FXML
        private Button BtnRemoverProfessor;

        private Aluno aluno;
        private Professor professor;
        private Leitor leitor;

        private Boolean incluindo;

        @FXML
        private void btnSalvarLeitor_Click(ActionEvent event) {

                leitor.setNome(txtNome.getText());
                leitor.setEndereco(txtEndereco.getText());
                leitor.setTelefone(txtTelefone.getText());

                // if (incluindo) {
                // dao.inserir(leitor);
                // } else {
                // dao.alterar(leitor);
                // }

                preencherTableAlunos();
                preencherTableProfessores();
        }

        // @FXML
        // private void excluir_click(ActionEvent event) {
        // dao.apagar(leitor);
        // preencherTableAlunos();
        // preencherTableProfessores();
        // }

        private void preencherTableAlunos() {
                List<Leitor> leitores = dao.buscarTodosPorId();

                ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
                tableListaAlunos.setItems(data);
        }

        private void preencherTableProfessores() {
                List<Leitor> leitores = dao.buscarTodosPorId();

                ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
                tableListaProfessores.setItems(data);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                colIdAluno.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("id"));

                colMatriculaAluno.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("matricula"));

                colNomeAluno.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("nome"));

                colEnderecoAluno.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("endereco"));

                colTelAluno.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("telefone"));

                colIdProfessor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("id"));

                colDisciplinaProfessor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("disciplina"));

                colNomeProfessor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("nome"));

                colEnderecoProfessor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("endereco"));

                colTelefoneProfessor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("telefone"));

                preencherTableAlunos();
                preencherTableProfessores();

        }

}
