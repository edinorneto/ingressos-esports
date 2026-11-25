package br.com.ingressos.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngressoTest {

    @Test
    void criarIngressoComCampoVazioOuNuloLancaErro() {
        assertThrows(IllegalArgumentException.class, () -> new IngressoInteira(null, "Final CBLOL", "Pista", 300.0));
        assertThrows(IllegalArgumentException.class, () -> new IngressoInteira("C01", "", "Pista", 300.0));
        assertThrows(IllegalArgumentException.class, () -> new IngressoInteira("C01", "Final CBLOL", " ", 300.0));
    }

    @Test
    void criarMeiaSemDocumentoLancaErro() {
        assertThrows(IllegalArgumentException.class, () -> new IngressoMeia("C02", "Final CBLOL", "Pista", 300.0, null));
        assertThrows(IllegalArgumentException.class, () -> new IngressoMeia("C02", "Final CBLOL", "Pista", 300.0, " "));
    }

    @Test
    void criarVipSemBeneficioLancaErro() {
        assertThrows(IllegalArgumentException.class, () -> new IngressoVip("C03", "Final CBLOL", "Camarote", 300.0, 150.0, null));
        assertThrows(IllegalArgumentException.class, () -> new IngressoVip("C03", "Final CBLOL", "Camarote", 300.0, 150.0, ""));
    }
}
