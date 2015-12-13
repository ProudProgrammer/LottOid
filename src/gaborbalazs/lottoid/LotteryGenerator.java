package gaborbalazs.lottoid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LotteryGenerator {

	private ArrayList<Integer> pool;
	private TreeSet<Integer> drawnNumbers;
	private Random random;
	
	public LotteryGenerator(int poolLength, int drawnNumbersLength) {
		drawnNumbers = new TreeSet<Integer>();
		
		if(poolLength > drawnNumbersLength) {
			
			pool = new ArrayList<Integer>(poolLength);
			random = new Random();
			
			for(int i = 0; i < poolLength; i++) {
				pool.add(i+1);
			}
		
			int poolIndex;
			for(int i = 0; i < drawnNumbersLength; i++) {
				Collections.shuffle(pool);
				poolIndex = random.nextInt(poolLength-i);
				drawnNumbers.add(pool.get(poolIndex));
				pool.remove(poolIndex);
			}
			
		}
	}
	
	public Set<Integer> getDrawnNumbers() {
		return drawnNumbers;
	}
	
	public String toString() {
		if(drawnNumbers.isEmpty())
			return "Pool length should be longer than drawn numbers'.";
		String numbers = "";
		for(Integer number : drawnNumbers) {
			numbers += number + ", ";
		}
		return numbers.substring(0, numbers.length()-2);
	}
}
