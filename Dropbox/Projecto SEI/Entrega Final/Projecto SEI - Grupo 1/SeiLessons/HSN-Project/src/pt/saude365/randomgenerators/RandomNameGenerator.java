package pt.saude365.randomgenerators;

import java.io.*;
import java.util.*;

public class RandomNameGenerator extends RandomGenerator {

	List<String> names;
	List<String> surnames;

	public RandomNameGenerator(String nameFilePath, String surnameFilePath,
			Random random) {
		super(random);
		initNames(nameFilePath);
		initSurnames(surnameFilePath);
	}

	private void initNames(String nameFilePath) {
		File nameFile = new File(nameFilePath);
		names = fileToList(nameFile);
	}

	private void initSurnames(String surnameFilePath) {
		File surnameFile = new File(surnameFilePath);
		surnames = fileToList(surnameFile);
	}

	/** Generate a random name */
	public String nextName() {
		int i = getRandom().nextInt(names.size());
		int j = getRandom().nextInt(surnames.size());

		return names.get(i) + " " + surnames.get(j);
	}
}
