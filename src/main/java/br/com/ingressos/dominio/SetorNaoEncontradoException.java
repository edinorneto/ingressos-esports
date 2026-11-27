package br.com.ingressos.dominio;

public class SetorNaoEncontradoException /* buraco 1: extends ... */ {
    public SetorNaoEncontradoException(String nomeDoSetor, String nomeDoEvento) {
        // buraco 2: chamar o construtor da mãe com a mensagem, ex.: "Setor Camarote não existe no evento Final CBLOL."
    }
}
