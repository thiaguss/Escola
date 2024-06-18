package edu.Escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {


    @Test
    void naoDeveCriarTelefoneComDddInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(null, "123456789")); // DDD null
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("", "123456789")); // DDD vazio
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("1", "123456789")); // DDD com menos de 2 dígitos
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("1234", "123456789")); // DDD com mais de 2 dígitos
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("ab", "123456789")); // DDD com caracteres não numéricos
    }

    @Test
    void naoDeveCriarTelefoneComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11", null)); // Número null
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11", "")); // Número vazio
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11", "12345")); // Número com menos de 8 dígitos
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11", "1234567890")); // Número com mais de 9 dígitos
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("11", "12345a789")); // Número com caracteres não numéricos
    }

    @Test
    void deveCriarTelefoneComDddENumeroValidos() {
        assertDoesNotThrow(() -> new Telefone("11", "123456789"));
        assertDoesNotThrow(() -> new Telefone("99", "98765432"));
    }

}