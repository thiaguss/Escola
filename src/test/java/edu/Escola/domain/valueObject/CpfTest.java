package edu.Escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void naoDeveCriarCpfComCpfInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("113.221.85433")); // Sem o - no final
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("123.456.789-0")); // Menos de 2 dígitos no final
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("123.456.78-123")); // Menos de 3 dígitos no meio
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("123.456.789.123")); // Ponto em vez de traço
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("111.111.111-11")); // Sequência repetida
    }

    @Test
    void deveCriarCpfComCpfValido() {
        assertDoesNotThrow(() -> new Cpf("123.456.789-09"));
        assertDoesNotThrow(() -> new Cpf("987.654.321-00"));
    }

    @Test
    void naoDeveCriarCpfComLetras() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("123.456.789-ab")); // Letras no final
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("abc.def.ghi-jk")); // Letras em todo lugar
    }

}