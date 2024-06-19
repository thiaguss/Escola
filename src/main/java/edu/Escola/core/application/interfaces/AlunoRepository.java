package edu.Escola.core.application.interfaces;

import edu.Escola.core.domain.entities.Aluno;
import edu.Escola.core.domain.valueObject.Cpf;

import java.util.List;

public interface AlunoRepository {
    void matricular(Aluno aluno);
    Aluno buscarPorCPF(Cpf cpf);
    List<Aluno> listarTodosAlunos();

}
