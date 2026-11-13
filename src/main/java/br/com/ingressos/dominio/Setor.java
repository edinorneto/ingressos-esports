package br.com.ingressos.dominio;

import java.util.HashSet;
import java.util.Set;

public class Setor {
    private final String nome;
    private final Set<Assento> assentos = new HashSet<>();

    public Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAssento(Assento assento) {
        boolean entrou = assentos.add(assento);
        if (!entrou) {
            throw new IllegalArgumentException("Assento " + assento.getCodigo() + " já existe no setor " + nome);
        }
    }

    public int quantidadeDeAssentos() {
        return assentos.size();
    }
}