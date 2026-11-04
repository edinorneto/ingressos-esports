package br.com.ingressos.dominio;

public class IngressoMeia extends Ingresso {

    private String documento;

    public IngressoMeia(String codigo, String nomeEvento, String setor, double precoBase, String documento) {
        super(codigo, nomeEvento, setor, precoBase);
        this.documento = documento;
    }

    @Override
    public double calcularPreco() {
        double preco = getPrecoBase();

        return preco / 2;
    }
}
