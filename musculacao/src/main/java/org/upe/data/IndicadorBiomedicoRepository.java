package org.upe.data;

import org.upe.model.IndicadorBiomedico;
import org.upe.interfaces.IndicadorBiomedicoInterface;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IndicadorBiomedicoRepository implements IndicadorBiomedicoInterface {

    protected String CAMINHO_ARQUIVO = "indicadores_biomedicos.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    public IndicadorBiomedicoRepository() {
        init();
    }

    private void init() {
        try {
            Files.createDirectories(Paths.get("data"));
        } catch (IOException e) {
            System.err.println("Erro ao criar csv: " + e.getMessage());
        }
    }

    protected String getCAMINHO_ARQUIVO() {
        return CAMINHO_ARQUIVO;
    }

    @Override
    public IndicadorBiomedico salvar(IndicadorBiomedico indicador) {
        List<IndicadorBiomedico> indicadores = carregar();

        long maiorId = 0;

        for ( IndicadorBiomedico indicadorBiomedico : indicadores) {
            if (indicador.getId() > maiorId) {
                maiorId = indicador.getId();
            }     
        }
        long novoId = maiorId + 1;
        indicador.setId(novoId);
        indicadores.add(indicador);
        salvarVarios(indicadores);
        return indicador;
    }

    @Override
    public List<IndicadorBiomedico> encontrarPeloUsuario(long id) {
        List<IndicadorBiomedico> indicadores = carregar();

        List<IndicadorBiomedico> indicadoresDoUsuario = new ArrayList<IndicadorBiomedico>();

        for ( int i = 0; i < indicadores.size(); i++ ) {
            if (indicadores.get(i).getUsuarioId() == id) {
                indicadoresDoUsuario.add(indicadores.get(i));
            }
        }

        return indicadoresDoUsuario;
    }

    private List<IndicadorBiomedico> carregar() {
        List<IndicadorBiomedico> indicadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                if (record.length == 7) { 
                    indicadores.add(new IndicadorBiomedico(
                            Long.parseLong(record[0]),
                            Long.parseLong(record[1]),
                            LocalDate.parse(record[2], DATE_FORMATTER),
                            Double.parseDouble(record[3]),
                            Double.parseDouble(record[4]),
                            Double.parseDouble(record[5]),
                            Double.parseDouble(record[6])
                    ));
                }
            }
        } catch (IOException e) {
            // File might not exist yet, or is empty, which is fine for initial state
        }
        return indicadores;
    }


    private void salvarVarios(List<IndicadorBiomedico> indicadores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (IndicadorBiomedico indicador : indicadores) {
                writer.write(indicador.getId() + "," +
                             indicador.getUsuarioId() + "," +
                             indicador.getData().format(DATE_FORMATTER) + "," +
                             indicador.getPeso() + "," +
                             indicador.getAltura() + "," +
                             indicador.getPercentualGordura() + "," +
                             indicador.getPercentualMassaMagra() + "," +
                             indicador.getImc());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
