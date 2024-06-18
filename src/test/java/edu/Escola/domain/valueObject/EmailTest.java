package edu.Escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveCriarEmailsComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("emailinvalido")); //sem caracteres especial
        assertThrows(IllegalArgumentException.class,
                () -> new Email("email@dominio")); // sem o .
        assertThrows(IllegalArgumentException.class,
                () -> new Email("@dominio.com")); // sem o @ no meio
        assertThrows(IllegalArgumentException.class,
                () -> new Email("email@.com")); // @ e . juntos
        assertThrows(IllegalArgumentException.class,
                () -> new Email("email@dominio.")); // terminado em .
        assertThrows(IllegalArgumentException.class,
                () -> new Email("email@dominio.com.")); // com . no final
        assertThrows(IllegalArgumentException.class,
                () -> new Email("email@dominio.com@")); // com @ no final
    }

    @Test
    void deveCriarEmailComEnderecoValido() {
        assertDoesNotThrow(() -> new Email("email@dominio.com"));
        assertDoesNotThrow(() -> new Email("email123@dominio.com.br"));
        assertDoesNotThrow(() -> new Email("email.teste@sub.dominio.com"));
    }
}