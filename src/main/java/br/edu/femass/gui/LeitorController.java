package br.edu.femass.gui;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
        private CheckBox checkBoxProfessor;

        @FXML
        private Label funcao1;

        @FXML
        private Button BtnSalvarLeitor;

        @FXML
        private TableView<Aluno> tableListaAlunos = new TableView<Aluno>();

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

        private AlunoDao dao_aluno = new AlunoDao();
        private ProfessorDao dao_professor = new ProfessorDao();

        private Aluno aluno;
        private Professor professor;
        private Leitor leitor;

        private Boolean incluindo;

        @FXML
        private void checkBoxProfessor_Select(ActionEvent event){
                
                if(checkBoxProfessor.isSelected()){
                        funcao1.setText("Disciplina:");
                }else{
                        funcao1.setText("Matrícula:");
                }
        //         checkBoxProfessor.setSelected(false);
        }

        @FXML
        private void btnSalvarLeitor_Click(ActionEvent event) {

                leitor.setNome(txtNome.getText());
                leitor.setEndereco(txtEndereco.getText());
                leitor.setTelefone(txtTelefone.getText());
                leitor.setFuncao(checkBoxProfessor.isSelected());
                leitor.setExtra(txtExtra.getText());
                

                
                //  if (incluindo) {
                //  dao.inserir(leitor);
                //  } else {
                //  dao.alterar(leitor);
                //  }
                
                dao_aluno.inserir(leitor);


                // preencherTableAlunos();
                // preencherTableProfessores();
        }

        @FXML
        private void btnRemoverAluno_Click(ActionEvent event) {
                /* dao.apagar(leitor); */
                preencherTableAlunos();
                preencherTableProfessores();
        }

        @FXML
        private void btnRemoverProfessor_Click(ActionEvent event) {
                /* dao.apagar(leitor); */
                preencherTableAlunos();
                preencherTableProfessores();
        }

        private void preencherTableAlunos() {
                /* List<Leitor> leitores = dao.buscarTodosPorId(); */
                List<Aluno> leitores = new ArrayList<>();

                ObservableList<Aluno> data = FXCollections.observableArrayList(leitores);
                tableListaAlunos.setItems(data);
        }

        private void preencherTableProfessores() {
                List<Professor> leitores = new ArrayList<>();

                ObservableList<Professor> data = FXCollections.observableArrayList(leitores);
                tableListaProfessores.setItems(data);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {

                colIdAluno.setCellValueFactory(
                                new PropertyValueFactory<>("id"));

                colMatriculaAluno.setCellValueFactory(
                                new PropertyValueFactory<>("matricula"));

                colNomeAluno.setCellValueFactory(
                                new PropertyValueFactory<>("nome"));

                colEnderecoAluno.setCellValueFactory(
                                new PropertyValueFactory<>("endereco"));

                colTelAluno.setCellValueFactory(
                                new PropertyValueFactory<>("telefone"));

                colIdProfessor.setCellValueFactory(
                                new PropertyValueFactory<>("id"));

                colDisciplinaProfessor.setCellValueFactory(
                                new PropertyValueFactory<>("disciplina"));

                colNomeProfessor.setCellValueFactory(
                                new PropertyValueFactory<>("nome"));

                colEnderecoProfessor.setCellValueFactory(
                                new PropertyValueFactory<>("endereco"));

                colTelefoneProfessor.setCellValueFactory(
                                new PropertyValueFactory<>("telefone"));

                // preencherTableAlunos();
                // preencherTableProfessores();

        }

}
