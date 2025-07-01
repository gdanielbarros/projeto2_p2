package org.upe.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.upe.model.Usuario;

public class UsuarioRepository {
    private static final String CAMINHO_ARQUIVO = "usuarios.csv";

    public void salvar(List<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Usuario ex : usuarios) {
                writer.write(ex.getId() + "," + ex.getNome() + "," + ex.getEmail() + "," + ex.getSenha() + "," + ex.getTipo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar exercícios: " + e.getMessage());
        }
    }

    public List<Usuario> carregar() {
        List<Usuario> Usuarios = new ArrayList<>();

        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) return Usuarios;

        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    Usuario ex = new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4]);
                    Usuarios.add(ex);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar exercícios: " + e.getMessage());
        }

        return Usuarios;
    }
}
