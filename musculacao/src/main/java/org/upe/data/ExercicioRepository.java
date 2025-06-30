package org.upe.data;
import org.upe.model.Exercicio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExercicioRepository {
    private static final String CAMINHO_ARQUIVO = "exercicios.csv";

    public void salvar(List<Exercicio> exercicios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Exercicio ex : exercicios) {
                writer.write(ex.getNome() + "," + ex.getDescricao() + "," + ex.getGifPath());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar exercícios: " + e.getMessage());
        }
    }

    public List<Exercicio> carregar() {
        List<Exercicio> exercicios = new ArrayList<>();

        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) return exercicios;

        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    Exercicio ex = new Exercicio(partes[0], partes[1], partes[2]);
                    exercicios.add(ex);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar exercícios: " + e.getMessage());
        }

        return exercicios;
    }
}