package org.upe.model;

public class Usuario{

    public int id;
    public String nome;
    public String email;
    public String senha;
    public String tipo;

    public Usuario(int id, String nome, String email, String senha, String tipo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;

    }
}