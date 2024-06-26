package edu.Escola.core.domain.services;

import edu.Escola.core.domain.entities.Aluno;
import edu.Escola.core.domain.valueObject.Cpf;
import edu.Escola.core.domain.valueObject.Email;

public class CriarAluno {

    private Aluno aluno;

    public CriarAluno comNomeCpfEmail(String nome, String cpf, String email){

        if (this.aluno != null) {
            throw new IllegalStateException();
        }

        this.aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
        return this;
    }

    public CriarAluno comTelefone(String ddd, String numero){
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar(){
        return this.aluno;
    }
}
