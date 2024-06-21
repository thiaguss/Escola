package edu.Escola.application.interfaces;

import edu.Escola.core.domain.entities.Aluno;

public interface EnviarEmail {
    void enviarParaAluno(Aluno indicado);
}
