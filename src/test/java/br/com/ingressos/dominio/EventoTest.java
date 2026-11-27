package br.com.ingressos.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void criarEventoComCampoVazioOuNuloLancaErro() {
        assertThrows(IllegalArgumentException.class, () -> new Evento(null));
        assertThrows(IllegalArgumentException.class, () -> new Evento(""));
        assertThrows(IllegalArgumentException.class, () -> new Evento(" "));
    }

    @Test
    void adicionarSetorNuloLancaErro() {
        Evento finalCblol = new Evento("Final CBLOL");

        assertThrows(IllegalArgumentException.class, () -> finalCblol.adicionarSetor(null));
    }

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

    @Test
    void buscarSetorInexistenteLancaErro() {
        Evento finalCblol = new Evento("Final CBLOL");
        finalCblol.adicionarSetor(new Setor("Pista"));

        // buraco 3: garantir que buscarSetor("Camarote") lança SetorNaoEncontradoException
    }
}
