package br.com.ingressos;

import br.com.ingressos.dominio.Ingresso;
import br.com.ingressos.dominio.IngressoInteira;
import br.com.ingressos.dominio.IngressoMeia;
import br.com.ingressos.dominio.IngressoVip;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ingresso worlds = new IngressoInteira("W01", "Worlds 2026 - Final", "Arquibancada", 300.0);
        Ingresso vct = new IngressoMeia("V07", "VCT Champions", "Arquibancada", 180.0, "Carteirinha UNE 12345");
        Ingresso cblol = new IngressoVip("C12", "CBLOL - Final", "Camarote", 250.0, 150.0, "Lounge exclusivo + camisa oficial");

        List<Ingresso> eventos = new ArrayList<>();

        eventos.add(worlds);
        eventos.add(vct);
        eventos.add(cblol);

        for (Ingresso i : eventos) {
            System.out.println(i.descricao());
        }
    }
}