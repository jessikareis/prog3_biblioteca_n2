package br.edu.femass.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dataAquisicao;
    private Long id;

    private Boolean emprestado;
    public static Long proxCod ;
    public Exemplar() {};

    public Exemplar(String dataAquisicao, long id) {
        this.dataAquisicao = dataAquisicao;
        this.id =  proxCod;
        proxCod++;
        this.emprestado = false;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Long getId() {
        return id;
    }

    public void setCodigo(Long id) {
        this.id = id;
    }

    public static Long getProxCod() {
        proxCod++;
        return proxCod;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static void setProxCod(long proxCod) {
        Exemplar.proxCod = proxCod;
    }


    public static void atualizarProxCod(List<Exemplar> exemplares){
        for (Exemplar exemplar : exemplares){
            if (exemplar.getId() > proxCod){
                proxCod = exemplar.getId();
               return;
            }
        }
    }

    @Override
    public String toString() {
        return ("Data de aquisição: " +this.dataAquisicao + ", " + " Código: " + this.id);
    }


    @Override
    public boolean equals(Object obj) {
        Exemplar exemplar = (Exemplar) obj;
        return this.id.equals(exemplar.getId());
    }

}