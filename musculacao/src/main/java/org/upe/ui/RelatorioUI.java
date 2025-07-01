package org.upe.ui;

import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import org.upe.model.IndicadorBiomedico;

public class RelatorioUI {

    private SimpleDateFormat dataRelatorio = new SimpleDateFormat("dd-MM-yyyy");

    public void visualizar(List<IndicadorBiomedico> indicadores, Scanner scanner){
        if (indicadores == null || indicadores.isEmpty()){
            System.out.println("Não há indicadores biomédicos cadastrados.");
            return;
        }
        
        System.out.println("Histórico de indicadores biomédicos cadastrados");
        for (IndicadorBiomedico i : indicadores){
            System.out.println("Data: " + dataRelatorio.format(i.data));
            System.out.println("Peso " + i.peso + " KG");
            System.out.println("Altura: " + i.altura + "cm");
            System.out.println("Percentual de gordura " + i.percentualGordura);
            System.out.println("percentual de massa magra" + i.percentualMassaMagra);
            System.out.println("IMC: " + i.imc);
        }
    }
}
