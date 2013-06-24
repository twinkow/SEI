package pt.saude365.randomgenerators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
	private Random random;

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public RandomGenerator(Random random) {
		this.random = random;
		initRandom(this.random);
	}

	public List<String> fileToList(File file) {
		List<String> list = new ArrayList<String>();

		FileReader fileReader = null;
		BufferedReader in = null;
		try {
			fileReader = new FileReader(file);
			in = new BufferedReader(fileReader);

			// fill array with file data
			String line;
			while ((line = in.readLine()) != null)
				list.add(line);

		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		} finally {
			if (in != null) {
				try {
					in.close();

				} catch (IOException ioe) {
					// ignore
				}
			}
		}

		return list;
	}

	private void initRandom(Random random) {
		this.random = random;
	}
}
