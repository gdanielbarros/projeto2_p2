package org.upe.ui;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.upe.model.IndicadorBiomedico;
import org.upe.model.Usuario;
import org.upe.ui.VerRelatorio;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<IndicadorBiomedico> indicadores = new ArrayList<>();
        Usuario user = new Usuario(01, "LuanGameplay", "luanzito225@email.com", "batata123", "comum");
        
        int opcao;

        do { 
            System.out.println("\n Tela Inicial ");
            System.out.println("1. Plano de Treino");
            System.out.println("2. Adicionar indicadores Biomédicos");
            System.out.println("3. Ver Relatórios");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Plano de Treino");
                    break;
                case 2:
                    System.out.println("Adicionar indicadores Biomédicos: ");
                    System.out.print("Peso (KG): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura em centímetros: ");
                    double altura = scanner.nextDouble();
                    System.out.print("Percentual de Gordura: ");
                    double gordura = scanner.nextDouble();
                    System.out.print("Percentual de massa magra");
                    double massaMagra = scanner.nextDouble();
                    scanner.nextLine();
                

                    IndicadorBiomedico novoBiomedico = new IndicadorBiomedico(
                        indicadores.size() + 1,
                        user,
                        new Date(),
                        peso,
                        altura,
                        gordura,
                        massaMagra
                    );
                    indicadores.add(novoBiomedico);
                    System.out.println("Indicadores cadastrados!");
                    break;
                case 3:
                    System.out.println("Ver Relatórios");
                    VerRelatorio verRelatorio = new VerRelatorio();
                    verRelatorio.visualizar(indicadores, scanner);
                    break;
                case 4:
                    System.out.println("Fechando programa");
                    break;

                case 5: 
                    System.out.println("Cadastrar novo exercicio");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}