package org.upe.ui;

import java.util.List;

import org.upe.interfaces.ExercicioInterface;
import org.upe.model.Exercicio;

public class ExercicioUI {

  private ExercicioInterface repository;
  
  public void visualizar() {

    List<Exercicio> exercicios = repository.carregar();

    for ( Exercicio exercicio : exercicios) {
      System.out.println("Nome do exercício: " + exercicio.getNome());
      System.out.println("Descrição: " + exercicio.getDescricao());
      System.out.println("Gif: " + exercicio.getGifPath());   
      System.out.println("");
      System.out.println("==================================================================================");   
      System.out.println("==================================================================================");
      System.out.println("");
    }
  }

  public void salvar() {
    
  }
}