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

    public boolean reservar() {
        if (status == StatusAssento.DISPONIVEL) {
            status = StatusAssento.RESERVADO;
            return true;
        }
        return false;
    }

    public boolean vender() {
        if (status == StatusAssento.RESERVADO) {
            status = StatusAssento.VENDIDO;
            return true;
        }
        return false;
    }
}
