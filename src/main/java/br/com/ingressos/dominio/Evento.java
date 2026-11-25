package br.com.ingressos.dominio;

import java.util.HashMap;
import java.util.Map;

public class Evento {
    private final String nome;
    private final Map<String, Setor> setores = new HashMap<>();

    public Evento(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do evento é obrigatório.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarSetor(Setor setor) {
        if (setor == null) {
            throw new IllegalArgumentException("Setor é obrigatório.");
        }
        if (setores.containsKey(setor.getNome())) {
            throw new IllegalArgumentException("Setor " + setor.getNome() + " já existe no evento " + nome + ".");
        }
        setores.put(setor.getNome(), setor);
    }

    public Setor buscarSetor(String nomeDoSetor) {
        return setores.get(nomeDoSetor);
    }
}
