package org.upe.ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n Tela Inicial ");
            System.out.println("1. Plano de Treino");
            System.out.println("2. Indicadores Biomédicos");
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
                    System.out.println("Indicadores Biomédicos");
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