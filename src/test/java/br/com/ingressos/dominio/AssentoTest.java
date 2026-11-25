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
        assento = new Assento("A12", "Pista");
    }

    @Test
    void criarAssentoComCampoVazioOuNuloLancaErro() {
        assertThrows(IllegalArgumentException.class, () -> new Assento(null, "Pista"));
        assertThrows(IllegalArgumentException.class, () -> new Assento("A1", null));
        assertThrows(IllegalArgumentException.class, () -> new Assento("", "Pista"));
        assertThrows(IllegalArgumentException.class, () -> new Assento("A1", " "));
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
    void reservarAssentoReservadoLancaErro() {
        assento.reservar();
        assertThrows(AssentoIndisponivelException.class, () -> assento.reservar());
    }

    @Test
    void venderAssentoDisponivelLancaErro() {
        assertThrows(AssentoIndisponivelException.class, () -> assento.vender());
    }

    @Test
    void reservarAssentoVendidoLancaErro() {
        assento.reservar();
        assento.vender();
        assertThrows(AssentoIndisponivelException.class, () -> assento.reservar());
    }

    @Test
    void venderAssentoVendidoLancaErro() {
        assento.reservar();
        assento.vender();
        assertThrows(AssentoIndisponivelException.class, () -> assento.vender());
    }

    @Test
    void assentosComMesmoCodigoSaoIguais() {
        Assento outro = new Assento("A12", "Pista");
        assertEquals(assento, outro);
    }

    @Test
    void assentosComCodigosDiferentesNaoSaoIguais() {
        Assento outro = new Assento("B7", "Pista");
        assertNotEquals(assento, outro);
    }

    @Test
    void assentosComSetoresDiferentesNaoSaoIguais() {
        Assento outro = new Assento("A12", "VIP");
        assertNotEquals(assento, outro);
    }

    @Test
    void assentoReservadoContinuaIgualAoDisponivel() {
        Assento outro = new Assento("A12", "Pista");
        outro.reservar();
        assertEquals(assento, outro);
    }

    @Test
    void assentosIguaisTemMesmoHashCode() {
        Assento outro = new Assento("A12", "Pista");
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
        vendidos.add(new Assento("A12", "Pista"));
        assertEquals(1, vendidos.size());
    }
}
