package br.com.ingressos.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetorTest {

    @Test
    void adicionarAssentoRepetidoLancaErro() {
        Setor pista = new Setor("Pista");
        pista.adicionarAssento(new Assento("A1", "Pista"));

        assertThrows(IllegalArgumentException.class, () -> pista.adicionarAssento(new Assento("A1", "Pista")));
    }

    @Test
    void adicionarDoisAssentosDiferentesDeixaSetorComDois() {
        Setor pista = new Setor("Pista");

        pista.adicionarAssento(new Assento("A1", "Pista"));
        pista.adicionarAssento(new Assento("A2", "Pista"));

        assertEquals(2, pista.quantidadeDeAssentos());
    }
}