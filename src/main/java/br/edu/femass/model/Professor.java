package br.edu.femass.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor extends Leitor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String disciplina;

    public Professor(){}
    public Professor(String endereco, String telefone, String nome, String disciplina) {
        // super(endereco, telefone, nome, 30);
        this.disciplina = disciplina;
    }
    public static void atualizarProxCod(List<Professor> professores){
        for (Professor professor : professores){
            if (professor.getId() > proxCod){
                proxCod = professor.getId();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return ("Id: " + this.id + ", " +
                "Nome: " + this.nome + ", " +
                "Endereço: " + this.endereco + ", " +
                "Telefone: " + this.telefone + ", " +
                "Disciplina: " + this.disciplina);
    }
}
