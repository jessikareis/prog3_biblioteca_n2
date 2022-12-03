package br.edu.femass.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.time.LocalDate;

public class Emprestimo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private Exemplar exemplar;
    private Leitor leitor;

    public Emprestimo(){}
    public Emprestimo(LocalDate dataEmprestimo, Exemplar exemplar, Leitor leitor) {
        this.dataEmprestimo = dataEmprestimo;
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(leitor.getPrazoMaxDevolucao());
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
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
        return ("Código do exemplar: " + this.exemplar.getId() + ", " +
                "Nome: " + this.leitor.getNome() + ", " +
                "Dia: " + this.dataEmprestimo + ", "
                );
    }
   
}
