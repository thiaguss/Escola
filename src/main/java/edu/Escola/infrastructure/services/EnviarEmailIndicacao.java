package edu.Escola.infrastructure.services;

import edu.Escola.application.interfaces.EnviarEmail;
import edu.Escola.core.domain.entities.Aluno;

public class EnviarEmailIndicacao implements EnviarEmail {
    @Override
    public void enviarParaAluno(Aluno indicado) {
        // logica de envio de email com alguma lib de preferencia
    }
}
