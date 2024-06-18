package edu.Escola.domain.valueObject;

public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if (!isValidCpf(numero)){
            throw new IllegalArgumentException("CPF inválido");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    private boolean isValidCpf(String numero) {
        if (numero == null) {
            return false;
        }
        if(!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return false;
        }

        String cleanCpf = numero.replaceAll("[\\.\\-]", "");
        return !isSequenciaRepetida(cleanCpf);
    }

    private boolean isSequenciaRepetida(String cpf) {
        String[] sequenciasInvalidas = {
                "00000000000", "11111111111", "22222222222",
                "33333333333", "44444444444", "55555555555",
                "66666666666", "77777777777", "88888888888",
                "99999999999"
        };
        for (String sequencia : sequenciasInvalidas) {
            if (cpf.equals(sequencia)) {
                return true;
            }
        }
        return false;
    }
}
