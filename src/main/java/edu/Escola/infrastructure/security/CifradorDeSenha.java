package edu.Escola.infrastructure.security;

import edu.Escola.core.application.interfaces.SegurancaSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorDeSenha implements SegurancaSenha {
    @Override
    public String cifrarSenha(String senha) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Erro ao gerar o hash", e);
        }
    }

    @Override
    public boolean validarSenha(String senhaCifrada, String senha) {
       return senhaCifrada.equals(cifrarSenha(senha));
    }
}
