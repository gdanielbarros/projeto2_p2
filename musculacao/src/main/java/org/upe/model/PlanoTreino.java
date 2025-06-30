package org.upe.model;

import java.util.ArrayList;
import java.util.List;

public class PlanoTreino {
    private List<ExecucaoExercicio> exercicios;

    public PlanoTreino() {
        this.exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(ExecucaoExercicio ex) {
        exercicios.add(ex);
    }

    public List<ExecucaoExercicio> getExercicios() {
        return exercicios;
    }

    public void atualizarExercicio(String nome, double novaCarga, int novasRepeticoes) {
        for (ExecucaoExercicio ex : exercicios) {
            if (ex.getNome().equalsIgnoreCase(nome)) {
                ex.setCarga(novaCarga);
                ex.setRepeticoes(novasRepeticoes);
            }
        }
    }
}
