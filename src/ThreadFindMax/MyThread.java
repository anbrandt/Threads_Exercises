package ThreadFindMax;

import java.util.Random;

/**
 * Created by andrzej on 21.06.17.
 */
public class MyThread extends Thread {
	//separate the table in 4 seperate threads
	private int[] table;
	private int maxInThread;
	private int lowInThread;
	int tempMax = 0;


	public MyThread(int[] table, int lowInThread, int maxInThread) {
		this.table = table;
		this.lowInThread = lowInThread;
		this.maxInThread = maxInThread;
	}

	@Override
	public void run() {
		for (int i = lowInThread; i < maxInThread; i++) {
			if (table[i] > tempMax) {
				tempMax = table[i];

			}
		}
	}


	public static int findMax(int[] table) throws InterruptedException {
		int length = table.length;
		int maxFromAllThreads = 0;


		MyThread[] mythread = new MyThread[4];

		//separate the table into four threads
		for (int i = 0; i < 4; i++) {

			mythread[i] = new MyThread(table, (i * length) / 4, ((i + 1) * length / 4));

			//initialize all threads inside the for loop
			mythread[i].start();
		}


		for (int i = 0; i < 4; i++) {

			mythread[i].join();

			if (mythread[i].tempMax > maxFromAllThreads) {
				maxFromAllThreads = mythread[i].tempMax;
			}


		}
		return maxFromAllThreads;

	}



}