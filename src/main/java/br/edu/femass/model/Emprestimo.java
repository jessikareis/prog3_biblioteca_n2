package br.edu.femass.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javafx.scene.control.DatePicker;
import javafx.scene.control.SingleSelectionModel;

public class Emprestimo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private DatePicker dataEmprestimo;
    private DatePicker dataPrevistaDevolucao;
    private DatePicker dataDevolucao;
    private Exemplar exemplar;
    private Leitor leitor;

    public Emprestimo(){}
    public Emprestimo(DatePicker dataEmprestimo, Exemplar exemplar, Leitor leitor) {
        this.dataEmprestimo = dataEmprestimo;
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(leitor.getPrazoMaxDevolucao());
    }

    public DatePicker getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(DatePicker dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public DatePicker getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(DatePicker dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public DatePicker getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(DatePicker dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }
    @Override
    public String toString() {
        return ("Código do exemplar: " + this.exemplar.getCodigo() + ", " +
                "Nome: " + this.leitor.getNome() + ", " +
                "Dia: " + this.dataEmprestimo + ", "
                );
    }
   
}
