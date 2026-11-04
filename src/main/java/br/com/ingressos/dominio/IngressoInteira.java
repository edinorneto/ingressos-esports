package br.com.ingressos.dominio;

public class IngressoInteira extends Ingresso {

    public IngressoInteira(String codigo, String nomeEvento, String setor, double precoBase) {
        super(codigo, nomeEvento, setor, precoBase);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }
}
