package thirdassignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class App {
	public static final int SIZE = 500;
	public static final int RANGE = 1000;

	public static void main(String[] args) {
		String fileName = "testResult.txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

			Random random = new Random();

			Set set = new HashSet<Integer>(SIZE);

			while (set.size() < SIZE) {
				while (set.add(random.nextInt(RANGE)) != true);
			}
			assert set.size() == SIZE;
			List<Integer> numlist = new ArrayList<Integer>(set);
			System.out.println("Random Numbers\n"+set );

			System.out.println("Enter the kth number: \n");
			Scanner in = new Scanner(System.in);
			int index = in.nextInt();
			int smallest = findSmallest(numlist, index);
			System.out.println(index+"th smallest"+smallest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int findSmallest(List<Integer> numlist, Integer small) {
		Collections.sort(numlist);
		int smallest = numlist.get(small - 1);
		return smallest;
	}
}
