package br.com.ingressos.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssentoTest {

    @Test
    void reservarAssentoDisponivelMudaParaReservado() {
        Assento assento = new Assento("A12");
        boolean conseguiu = assento.reservar();

        assertTrue(conseguiu);
        assertEquals(StatusAssento.RESERVADO, assento.getStatus());
    }
}
