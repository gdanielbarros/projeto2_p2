package org.upe.model;

public class Exercicio {
    private String nome;
    private String descricao;
    private String gifPath;

    public Exercicio(String nome, String descricao, String gifPath) {
        this.nome = nome;
        this.descricao = descricao;
        this.gifPath = gifPath;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getGifPath() {
        return gifPath;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao + "\nGIF: " + gifPath;
    }
}