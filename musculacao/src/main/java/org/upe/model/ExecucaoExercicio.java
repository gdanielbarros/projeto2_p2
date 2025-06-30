package org.upe.model;

public class ExecucaoExercicio extends Exercicio {
    private double carga;      // peso usado na execução (kg)
    private int repeticoes;    // número de repetições realizadas

    public ExecucaoExercicio(String nome, String descricao, String gifPath, double carga, int repeticoes) {
        super(nome, descricao, gifPath);
        this.carga = carga;
        this.repeticoes = repeticoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCarga: " + carga + " kg | Repetições: " + repeticoes;
    }
}
