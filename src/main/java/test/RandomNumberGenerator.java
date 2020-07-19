package test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
	public static final int SIZE = 500;
	public static void main(String[] args) {
		Set<Integer> randomNumbers = new TreeSet<Integer>();
		while (randomNumbers.size() < SIZE) {
			randomNumbers.add(ThreadLocalRandom.current().nextInt());
		}
		System.out.println("Random Numbers\n" + randomNumbers);
		System.out.println("Enter the kth number: \n");
		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();
		int smallest = findSmallest(randomNumbers, index);
		System.out.println(index+"th smallest"+smallest);
	}

	private static int findSmallest(Set<Integer> set, int small) {
		int smallest =  (Integer) set.toArray()[small - 1];
		return smallest;
	}
}
