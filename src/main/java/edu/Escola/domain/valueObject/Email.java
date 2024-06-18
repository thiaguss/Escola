package edu.Escola.domain.valueObject;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if (!isValidEmail(endereco)){
            throw new IllegalArgumentException("E-mail inválido");
        };

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    private boolean isValidEmail(String endereco){
        if (endereco == null) {
            return false;
        }
        // Regex to match CPF format: XXX.XXX.XXX-XX
        return endereco.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
