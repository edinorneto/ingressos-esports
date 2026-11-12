package br.com.ingressos.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    void assentosComMesmoCodigoSaoIguais() {
        Assento outro = new Assento("A12");
        assertEquals(assento, outro);
    }

    @Test
    void assentosComCodigosDiferentesNaoSaoIguais() {
        Assento outro = new Assento("B7");
        assertNotEquals(assento, outro);
    }

    @Test
    void assentoReservadoContinuaIgualAoDisponivel() {
        Assento outro = new Assento("A12");
        outro.reservar();
        assertEquals(assento, outro);
    }

    @Test
    void assentosIguaisTemMesmoHashCode() {
        Assento outro = new Assento("A12");
        assertEquals(assento.hashCode(), outro.hashCode());
    }

    @Test
    void assentoNaoEIgualANull() {
        assertNotEquals(assento, null);
    }

    @Test
    void hashSetNaoGuardaAssentoDuplicado() {
        Set<Assento> vendidos = new HashSet<>();
        vendidos.add(assento);
        vendidos.add(new Assento("A12"));
        assertEquals(1, vendidos.size());
    }
}
