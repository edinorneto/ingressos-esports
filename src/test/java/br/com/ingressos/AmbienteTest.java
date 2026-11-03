package br.com.ingressos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Teste de fumaça: só confirma que o JUnit 5 está configurado.
class AmbienteTest {

    @Test
    void junitEstaFuncionando() {
        assertEquals(2, 1 + 1);
    }
}
