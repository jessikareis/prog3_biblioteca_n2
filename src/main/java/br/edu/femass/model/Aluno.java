package br.edu.femass.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;

    public Aluno (){}
    public Aluno(String endereco, String telefone, String nome, String matricula) {
        super(endereco, telefone, nome, 15);
        this.matricula = matricula;
    }
    public static void atualizarProxCod(List<Aluno> alunos){
        for (Aluno aluno : alunos){
            if (aluno.getId() > proxCod){
                proxCod = aluno.getId();
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
                "Matrícula: " + this.matricula);
    }
}
