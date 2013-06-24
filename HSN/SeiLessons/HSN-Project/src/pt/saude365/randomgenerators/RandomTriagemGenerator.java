package pt.saude365.randomgenerators;

import java.io.File;
import java.util.List;
import java.util.Random;

public class RandomTriagemGenerator extends RandomGenerator {
	List<String> tipo;
	List<String> nivel;

	public RandomTriagemGenerator(String tipoFilePath, String nivelFilePath,
			Random random) {
		super(random);
		initTipo(tipoFilePath);
		initUrgencia(nivelFilePath);
	}

	private void initTipo(String tipoFilePath) {
		File tipoFile = new File(tipoFilePath);
		tipo = fileToList(tipoFile);
	}

	private void initUrgencia(String nivelFilePath) {
		File nivelFile = new File(nivelFilePath);
		nivel = fileToList(nivelFile);
	}

	/** Generate random triagem */
	public String nextTriagem() {
		int i = getRandom().nextInt(tipo.size());
		int j = getRandom().nextInt(nivel.size());

		return tipo.get(i) + "$" + nivel.get(j);
	}
}
