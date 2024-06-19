package edu.Escola.core.application.interfaces;

public interface SegurancaSenha {
    String cifrarSenha(String senha);
    boolean validarSenha(String senhaCifrada, String senha);
}
