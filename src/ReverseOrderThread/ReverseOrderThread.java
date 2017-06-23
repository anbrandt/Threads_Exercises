package ReverseOrderThread;

import java.util.Random;

/**
 * Created by andrzej on 21.06.17.
 */
public class ReverseOrderThread extends Thread {

	private int[] table;
	private int temp;
	public ReverseOrderThread(int[] table) {
		this.table = table;
	}


	public void run() {
		for (int i = 0; i < table.length; i++) {
			temp = table[table.length -i - 1];
//			System.out.println(temp);
		}
	}


	public static int[] reverseOrder(int[] table) {
		int length = table.length;
		int temp = 0;

		//create threads
		ReverseOrderThread[] mythread = new ReverseOrderThread[4];
		for (int i = 0; i < 4; i++) {
			mythread[i] = new ReverseOrderThread(table);
			mythread[i].start();
		}


		for (int i = 0; i < 4; i++) {
			try {
				mythread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		for (int i = 0; i < table.length; i++) {
//			temp = table[length -i - 1];
//			System.out.println(temp);
//		}

		return table;
	}


	public static void main(String[] args) {
		Random randomgenerator = new Random();

		int tempMax = 0;

		int[] table = new int[50];
		for (int i = 0; i < table.length; i++) {
			table[i] = randomgenerator.nextInt(50);
			System.out.println(table[i]);
		}
		System.out.println("--------------------------------------------------------------------------");
		reverseOrder(table);


	}
}
