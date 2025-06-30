package org.upe.business;

package business;

import model.Exercicio;
import model.PlanoTreino;

public class TreinoBusiness {
    public void verificarAlteracoesEAtualizar(PlanoTreino plano, String nomeExercicio, double cargaReal, int repeticoesReais) {
        for (Exercicio ex : plano.getExercicios()) {
            if (ex.getNome().equalsIgnoreCase(nomeExercicio)) {
                if (ex.getCarga() != cargaReal || ex.getRepeticoes() != repeticoesReais) {
                    System.out.println("Deseja atualizar o plano com os novos valores? (s/n)");
                    // Aqui, a decisão virá da camada ui
                }
            }
        }
    }
}
