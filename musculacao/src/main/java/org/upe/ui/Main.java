package org.upe.ui;

import java.sql.Date;
import java.util.Scanner;

import org.upe.business.IndicadorBiomedico;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println("Relatórios");
                    break;
                case 4:
                    System.out.println("Fechando programa");
                    break;

                //Cadastro de exercicio. 
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