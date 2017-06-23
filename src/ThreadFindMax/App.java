package ThreadFindMax;

import java.util.Random;

import static ThreadFindMax.MyThread.findMax;

/**
 * Created by andrzej on 21.06.17.
 */
public class App {


	public static void main(String[] args) throws InterruptedException {
		Random randomgenerator = new Random();
		int[] table = new int[100];

		for (int i = 0; i < table.length; i++) {
			table[i] = randomgenerator.nextInt(100);
			System.out.println(i + ": " + table[i]);
		}



		int max = findMax(table);

		System.out.println("Max in all threads is  " + max);


	}
}
