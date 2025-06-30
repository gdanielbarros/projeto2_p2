package org.upe.business;


import org.upe.model.Exercicio;
import org.upe.model.PlanoTreino;
import org.upe.model.ExecucaoExercicio;

public class TreinoBusiness {
    public void verificarAlteracoesEAtualizar(PlanoTreino plano, String nomeExercicio, double cargaReal, int repeticoesReais) {
        for (ExecucaoExercicio ex : plano.getExercicios()) {
            if (ex.getNome().equalsIgnoreCase(nomeExercicio)) {
                if (ex.getCarga() != cargaReal || ex.getRepeticoes() != repeticoesReais) {
                    System.out.println("Deseja atualizar o plano com os novos valores? (s/n)");
                    // Aqui, a decisão virá da camada ui
                }
            }
        }
    }
}
