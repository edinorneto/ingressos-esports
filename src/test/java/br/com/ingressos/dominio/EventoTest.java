package br.com.ingressos.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void adicionarSetorComNomeRepetidoLancaErro() {
        Evento finalCblol = new Evento("Final CBLOL");
        finalCblol.adicionarSetor(new Setor("VIP"));

        assertThrows(IllegalArgumentException.class,
                () -> finalCblol.adicionarSetor(new Setor("VIP")));
    }

    @Test
    void buscarSetorPeloNomeDevolveOSetorCerto() {
        Evento finalCblol = new Evento("Final CBLOL");
        finalCblol.adicionarSetor(new Setor("Pista"));

        Setor encontrado = finalCblol.buscarSetor("Pista");

        assertEquals("Pista", encontrado.getNome());
    }
}