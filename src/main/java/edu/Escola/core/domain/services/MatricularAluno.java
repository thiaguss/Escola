package edu.Escola.core.domain.services;

import edu.Escola.application.dtos.MatricularAlunoDto;
import edu.Escola.core.domain.interfaces.AlunoRepository;

public class MatricularAluno {


    private final AlunoRepository alunoRepository;

    public MatricularAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void matricular(MatricularAlunoDto dados){}
}
