package org.upe.model;

import java.util.ArrayList;
import java.util.List;

public class PlanoTreino {
    private List<Exercicio> exercicios;

    public PlanoTreino() {
        this.exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicio ex) {
        exercicios.add(ex);
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void atualizarExercicio(String nome, double novaCarga, int novasRepeticoes) {
        for (Exercicio ex : exercicios) {
            if (ex.getNome().equalsIgnoreCase(nome)) {
                ex.setCarga(novaCarga);
                ex.setRepeticoes(novasRepeticoes);
            }
        }
    }
}
