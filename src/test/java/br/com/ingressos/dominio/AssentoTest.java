package br.com.ingressos.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssentoTest {

    private Assento assento;

    @BeforeEach
    void criarAssento() {
        assento = new Assento("A12");
    }

    @Test
    void reservarAssentoDisponivelMudaParaReservado() {
        assento.reservar();
        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }

    @Test
    void venderAssentoReservadoMudaParaVendido() {
        assento.reservar();
        assento.vender();
        assertEquals(StatusAssento.VENDIDO, assento.getStatus());
    }

    @Test
    void reservarUmAssentoReservadoErro() {
        assento.reservar();
        assertThrows(AssentoIndisponivelException.class, () -> assento.reservar());
    }

    @Test
    void venderUmAssentoDisponivelErro() {
        assertThrows(AssentoIndisponivelException.class, () -> assento.vender());
    }

    @Test
    void reservarUmAssentoVendidoErro() {
        assento.reservar();
        assento.vender();
        assertThrows(AssentoIndisponivelException.class, () -> assento.reservar());
    }

    @Test
    void venderUmAssentoVendidoErro() {
        assento.reservar();
        assento.vender();
        assertThrows(AssentoIndisponivelException.class, () -> assento.vender());
    }
}
