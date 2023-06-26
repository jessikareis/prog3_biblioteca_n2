package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Leitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class LeitorController implements Initializable {

        @FXML
        private TextField txtLeitorNome;
        @FXML
        private TextField txtLeitorEndereco;
        @FXML
        private TextField txtLeitorTelefone;
        @FXML
        private TextField txtLeitorExtra;

        @FXML
        private Label funcao1;
        @FXML
        private Button BtnSalvarLeitor;
        @FXML
        private Button BtnRemoverLeitor;

        @FXML
        private CheckBox checkBoxProfessor;

        @FXML
        private ListView<Leitor> ListaLeitores;
        @FXML
        private TableView<Leitor> tableListaLeitores = new TableView<Leitor>();
        @FXML
        private TableColumn<Leitor, Long> colIdLeitor = new TableColumn<>();
        @FXML
        private TableColumn<Leitor, String> colExtraLeitor = new TableColumn<>();
        @FXML
        private TableColumn<Leitor, String> colNomeLeitor = new TableColumn<>();
        @FXML
        private TableColumn<Leitor, String> colEnderecoLeitor = new TableColumn<>();
        @FXML
        private TableColumn<Leitor, String> colTelLeitor = new TableColumn<>();
        @FXML
        private TableColumn<Leitor, String> colFuncaoLeitor = new TableColumn<>();

        private DaoLeitor dao_leitor = new DaoLeitor();
        private Leitor leitor;

        @FXML
        private void checkBoxProfessor_Select(ActionEvent event) {
                if (checkBoxProfessor.isSelected()) {
                        funcao1.setText("Disciplina:");
                } else {
                        funcao1.setText("Matrícula:");
                }
        }

        @FXML
        private void btnSalvarLeitor_Click(ActionEvent event) {
                leitor = new Leitor();
                leitor.setNome(txtLeitorNome.getText());
                leitor.setEndereco(txtLeitorEndereco.getText());
                leitor.setTelefone(txtLeitorTelefone.getText());

                // if (checkBoxFuncao.isSelected()) {
                // leitor.setFuncao("Professor");
                // } else {
                // leitor.setFuncao("Aluno");
                // }
                leitor.setExtra(txtLeitorExtra.getText());

                // if (incluindo) {
                // dao.inserir(leitor);
                // } else {
                // dao.alterar(leitor);
                // }

                dao_leitor.inserir(leitor);
                preencherLista();

        }

        @FXML
        private void btnRemoverLeitor_Click(ActionEvent event) {

                Leitor leitorSelecionado = tableListaLeitores.getSelectionModel().getSelectedItem();

                if (leitorSelecionado != null) {
                        dao_leitor.apagar(leitorSelecionado);
                        preencherLista();
                }
        }

        @FXML
        private void tableListaLeitores_MouseClicked(MouseEvent event) {
                exibirDados();
        }

        private void exibirDados() {
                this.leitor = tableListaLeitores.getSelectionModel().getSelectedItem();

                if (leitor == null)
                        return;

                txtLeitorNome.setText(leitor.getNome());
                txtLeitorEndereco.setText(leitor.getEndereco());
                txtLeitorTelefone.setText(leitor.getTelefone());
                if (leitor.getFuncao().equals("Aluno")) {
                        checkBoxProfessor.setSelected(false);
                }
                if (leitor.getFuncao().equals("Professor")) {
                        checkBoxProfessor.setSelected(true);
                }
                txtLeitorExtra.setText(leitor.getExtra());
                txtLeitorExtra.setText(leitor.getFuncao());
        }

        private void preencherLista() {
                List<Leitor> leitores = dao_leitor.buscarTodos();

                ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
                tableListaLeitores.setItems(data);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                colIdLeitor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, Long>("id"));
                colExtraLeitor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("extra"));
                colNomeLeitor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("nome"));
                colEnderecoLeitor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("endereco"));
                colTelLeitor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("telefone"));
                colFuncaoLeitor.setCellValueFactory(
                                new PropertyValueFactory<Leitor, String>("funcao"));

                preencherLista();

        }

}
