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

    @Test
    void precoBaseNegativoLancaErroEZeroEhPermitido() {
        assertThrows(IllegalArgumentException.class, () -> new IngressoInteira("C04", "Final CBLOL", "Pista", -1));
        assertDoesNotThrow(() -> new IngressoInteira("C05", "Final CBLOL", "Pista", 0));
    }

    @Test
    void taxaVipZeroLancaErroEPositivaEhPermitida() {
        assertThrows(IllegalArgumentException.class, () -> new IngressoVip("C03", "Final CBLOL", "Camarote", 300.0, 0, "Open Bar"));
        assertDoesNotThrow(() -> new IngressoVip("C03", "Final CBLOL", "Camarote", 300.0, 0.01, "Open Bar"));
    }

    @Test
    void inteiraCobraOPrecoBase() {
        Ingresso ingresso = new IngressoInteira("C08", "Final CBLOL", "Pista", 300.0);

        assertEquals(300.0, ingresso.calcularPreco());
    }

    @Test
    void meiaCobraMetadeDoPrecoBase() {
        Ingresso ingresso = new IngressoMeia("C09", "Final CBLOL", "Pista", 300.0, "RG 1234567");

        assertEquals(150.0, ingresso.calcularPreco());
    }

    @Test
    void vipCobraPrecoBaseMaisTaxa() {
        Ingresso ingresso = new IngressoVip("C10", "Final CBLOL", "Camarote", 300.0, 150.0, "Open Bar");

        assertEquals(450.0, ingresso.calcularPreco());
    }

}
