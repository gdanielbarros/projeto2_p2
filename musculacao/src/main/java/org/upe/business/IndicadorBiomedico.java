package org.upe.business;

import java.util.Date;
import org.upe.model.Usuario;


public class IndicadorBiomedico {
    

    public int id;
    public Usuario usuario;
    public Date data;
    public double peso;
    public double altura;
    public double percentualGordura;
    public double percentualMassaMagra;
    public double imc;

    public IndicadorBiomedico(int id, Usuario usuario, Date data, double peso, double altura, double gordura, double massaMagra){
        this.id =id;
        this.usuario = usuario;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.percentualGordura = gordura;
        this.percentualMassaMagra = massaMagra;
        this.imc = calcularIMC(peso, altura);
    }

    private double calcularIMC(double peso, double altura){
        return peso/(altura*altura);
    }



}
