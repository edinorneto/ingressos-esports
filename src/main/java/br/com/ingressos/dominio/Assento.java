package br.com.ingressos.dominio;

import java.util.Objects;

public class Assento {
    private StatusAssento status;
    private String codigo;
    private String setor;

    public Assento(String codigo, String setor) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código do assento é obrigatório.");
        }
        if (setor == null || setor.isBlank()) {
            throw new IllegalArgumentException("Setor do assento é obrigatório.");
        }
        this.status = StatusAssento.DISPONIVEL;
        this.codigo = codigo;
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
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
        return codigo.equals(outro.codigo) && setor.equals(outro.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, setor);
    }
}
