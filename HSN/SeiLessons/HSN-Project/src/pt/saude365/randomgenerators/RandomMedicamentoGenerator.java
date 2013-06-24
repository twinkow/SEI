package pt.saude365.randomgenerators;
import java.io.File;
import java.util.List;
import java.util.Random;

public class RandomMedicamentoGenerator extends RandomGenerator {
	List<String> medicamento;

	public RandomMedicamentoGenerator(String medicamentoFilePath, Random random) {
		super(random);
		initMedicamento(medicamentoFilePath);
	}

	private void initMedicamento(String medicamentoFilePath) {
		File medicamentoFile = new File(medicamentoFilePath);
		medicamento = fileToList(medicamentoFile);
	}

	/** Generate random Medicamento */
	public String nextMedicamento() {
		int i = getRandom().nextInt(medicamento.size());
		return medicamento.get(i);
	}
}
