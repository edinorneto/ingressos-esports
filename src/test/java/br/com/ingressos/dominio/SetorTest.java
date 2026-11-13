package br.com.ingressos.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetorTest {

    @Test
    void adicionarAssentoRepetidoLancaErro() {
        Setor pista = new Setor("Pista");
        pista.adicionarAssento(new Assento("A1"));

        assertThrows(IllegalArgumentException.class, () -> pista.adicionarAssento(new Assento("A1")));
    }

    @Test
    void adicionarDoisAssentosDiferentesDeixaSetorComDois() {
        Setor pista = new Setor("Pista");

        pista.adicionarAssento(new Assento("A1"));
        pista.adicionarAssento(new Assento("A2"));

        assertEquals(2, pista.quantidadeDeAssentos());
    }
}