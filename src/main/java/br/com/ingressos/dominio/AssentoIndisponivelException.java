package br.com.ingressos.dominio;

public class AssentoIndisponivelException extends RuntimeException {
    public AssentoIndisponivelException(String codigo, StatusAssento status) {
        super("Não é possível realizar ação, pois o assento " + codigo + " está: " + status);
    }
}
