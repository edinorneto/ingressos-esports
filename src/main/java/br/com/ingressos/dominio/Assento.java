package br.com.ingressos.dominio;

import java.util.Objects;

public class Assento {
    private StatusAssento status;
    private String codigo;

    public Assento(String codigo) {
        this.status = StatusAssento.DISPONIVEL;
        this.codigo = codigo;
    }

    public StatusAssento getStatus() {
        return status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void reservar() {
        if (status != StatusAssento.DISPONIVEL) {
            throw new AssentoIndisponivelException(codigo, status);
        }
        status = StatusAssento.RESERVADO;
    }

    public void vender() {
        if (status != StatusAssento.RESERVADO) {
            throw new AssentoIndisponivelException(codigo, status);
        }
        status = StatusAssento.VENDIDO;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Assento outro)) return false;
        return codigo.equals(outro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
