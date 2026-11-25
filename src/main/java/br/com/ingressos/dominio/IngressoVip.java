package br.com.ingressos.dominio;

public class IngressoVip extends Ingresso {

    private double taxaVip;
    private String beneficio;

    public IngressoVip(String codigo, String nomeEvento, String setor, double precoBase, double taxaVip, String beneficio) {
        super(codigo, nomeEvento, setor, precoBase);
        if (beneficio == null || beneficio.isBlank()) {
            throw new IllegalArgumentException("Benefício do VIP é obrigatório.");
        }
        if (taxaVip <= 0) {
            throw new IllegalArgumentException("Taxa VIP deve ser maior que zero.");
        }
        this.taxaVip = taxaVip;
        this.beneficio = beneficio;
    }

    @Override
    public double calcularPreco() {
        double preco = getPrecoBase();

        return preco + taxaVip;
    }

    @Override
    public String descricao() {
        return super.descricao() + " | Benefício: " + beneficio;
    }

}
