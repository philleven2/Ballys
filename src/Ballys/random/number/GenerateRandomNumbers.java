package Ballys.random.number;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateRandomNumbers {

	/*
	 * Generate 1,000,000 random numbers to a text file. Read the text file and sort the numbers.
	 * Write the sorted numbers to another text file.
	 * 
	 * IMO it's more efficient to sort the IntStream when it's created. There is
	 * really no need for a second text file.
	 */
	public static void main(String[] args) {

		String fileName = "randomNumbers.txt";
		String fileName2 = "randomNumbers2.txt";

		try (FileWriter writer = new FileWriter(fileName);) {

			// Create instance of GenerateRandomNumbers.java
			GenerateRandomNumbers genRandomNum = new GenerateRandomNumbers();

			// Generate 1,000,000 random numbers and write to a file
			genRandomNum.writeFile(fileName);

			// Read file, sort and write to a new file
			genRandomNum.writeFile2(fileName, fileName2);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeFile(String fileName) {

		try (FileWriter writer = new FileWriter(fileName);) {

			Random random = new Random();

			// Generate 1,000,000 sorted random numbers to IntStream
			IntStream nbrStream = random.ints(1000000, 1, 2000000).sorted();

			// Create IntStream iterator
			PrimitiveIterator.OfInt itr = nbrStream.iterator();

			// Write IntStream to file
			while (itr.hasNext()) {
				writer.write(itr.nextInt() + "\t" + "");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeFile2(String fileName, String fileName2) {

		String line;
		ArrayList<String> aList = new ArrayList<String>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName));
				BufferedReader br = new BufferedReader(new FileReader(fileName));) {

			stream.sorted();

			// Read file and add to ArrayList
			while ((line = br.readLine()) != null) {
				aList.add(line);
			}

			// Write to new file
			Path output = Paths.get(fileName2);
			Files.write(output, aList);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}