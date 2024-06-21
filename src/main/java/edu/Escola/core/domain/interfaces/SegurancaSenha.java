package edu.Escola.core.domain.interfaces;

public interface SegurancaSenha {
    String cifrarSenha(String senha);
    boolean validarSenha(String senhaCifrada, String senha);
}
