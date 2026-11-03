package br.com.ingressos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Teste de fumaça: só confirma que o JUnit 5 está configurado.
// Pode apagar quando os testes de verdade chegarem (Fase 1, tema 10).
class AmbienteTest {

    @Test
    void junitEstaFuncionando() {
        assertEquals(2, 1 + 1);
    }
}
