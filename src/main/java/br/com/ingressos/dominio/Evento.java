package br.com.ingressos.dominio;

import java.util.HashMap;
import java.util.Map;

public class Evento {
    private final String nome;
    private final Map<String, Setor> setores = new HashMap<>();

    public Evento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarSetor(Setor setor) {
        if (setores.containsKey(setor.getNome())) {
            throw new IllegalArgumentException("Setor " + setor.getNome() + " já existe no evento " + nome);
        }
        setores.put(setor.getNome(), setor);
    }

    public Setor buscarSetor(String nomeDoSetor) {
        return setores.get(nomeDoSetor);
    }
}