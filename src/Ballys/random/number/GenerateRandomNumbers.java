package Ballys.random.number;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

public class GenerateRandomNumbers {

	
	public static void main (String[] args) {
			
			try (FileWriter writer = new FileWriter("randomNumbers.txt");) {
				
				// Generate 1,000,000 sorted random numbers
				GenerateRandomNumbers genRandomNum = new GenerateRandomNumbers();
				IntStream nbrStream = genRandomNum.generateStream(1000000, 1, 2000000).sorted();
				
				// Create IntStream iterator
				PrimitiveIterator.OfInt itr = nbrStream.iterator();
				
				// Write IntStream to .txt file
				while (itr.hasNext()) {
					
					writer.write(itr.nextInt() + "\t" + "");
		           
		        }
				
			} catch (IOException e) {
				
				e.printStackTrace();

			}
		
	}
	
	private IntStream generateStream(int size, int min, int max) {
		
		Random random = new Random();
		return random.ints(size, min, max).sorted();
        
	}
	
}