package edu.Escola.application.dtos;

import edu.Escola.core.domain.entities.Aluno;
import edu.Escola.core.domain.valueObject.Telefone;

import java.util.List;

public class MatricularAlunoDto{

    private String nome;
    private String cpf;
    private String email;

    public MatricularAlunoDto(String nome, String cpf, String email) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
