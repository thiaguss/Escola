package edu.Escola.core.domain.valueObject;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if (!isValidDdd(ddd)) {
            throw new IllegalArgumentException("DDD inválido");
        }
        if (!isValidNumero(numero)) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }

        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    private boolean isValidDdd(String ddd) {
        // Verifica se o DDD consiste exatamente em 2 dígitos
        return ddd != null && ddd.matches("\\d{2}");
    }

    private boolean isValidNumero(String numero) {
        // Verifica se o número consiste em 8 ou 9 dígitos
        return numero != null && numero.matches("\\d{8}|\\d{9}");
    }

}
