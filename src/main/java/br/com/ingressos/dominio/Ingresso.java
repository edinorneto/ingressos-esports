package br.com.ingressos.dominio;

public abstract class Ingresso {
    private String codigo;

    private String nomeEvento;

    private String setor;

    private double precoBase;

    public Ingresso(String codigo, String nomeEvento, String setor, double precoBase) {
        this.codigo = codigo;
        this.nomeEvento = nomeEvento;
        this.setor = setor;
        this.precoBase = precoBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getSetor() {
        return setor;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();

    public String descricao() {
        return "[" + codigo + "] " + nomeEvento + " - " + setor + " - R$ " + calcularPreco();
    }

}

