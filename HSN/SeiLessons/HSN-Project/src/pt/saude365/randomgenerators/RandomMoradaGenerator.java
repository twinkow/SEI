package pt.saude365.randomgenerators;

import java.io.File;
import java.util.List;
import java.util.Random;

public class RandomMoradaGenerator extends RandomGenerator {

	List<String> morada;

	public RandomMoradaGenerator(String moradaFilePath, Random random) {
		super(random);
		initMorada(moradaFilePath);
	}

	private void initMorada(String moradaFilePath) {
		File moradaFile = new File(moradaFilePath);
		morada = fileToList(moradaFile);
	}

	/** Generate random Morada */
	public String nextMorada() {
		int i = getRandom().nextInt(morada.size());
		return morada.get(i);
	}
}
