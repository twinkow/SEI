package pt.saude365;

import java.io.File;

import java.util.Random;

import pt.saude365.patientreport.MedicamentoType;
import pt.saude365.patientreport.TriagemType;
import pt.saude365.randomgenerators.RandomMedicamentoGenerator;
import pt.saude365.randomgenerators.RandomTriagemGenerator;

public class ReexecuteTriage {

    public static String generateTriage(){
        RandomTriagemGenerator triagemGen = new RandomTriagemGenerator(
                        "tipotriagem.txt", "niveltriagem.txt", new Random());
        return triagemGen.nextTriagem();
    }

    public static String generateMedicine(){
        RandomMedicamentoGenerator medicamentosGen = new RandomMedicamentoGenerator(
                        "medicamentosvalidos.txt", new Random());
        String medicamentoString = medicamentosGen.nextMedicamento();
        return medicamentoString;
    }
}
