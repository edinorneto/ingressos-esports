package br.com.ingressos.dominio;

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
}
