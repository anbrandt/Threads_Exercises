package IntroToThread;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {


		//example of anonim class that in fact it is a new interface
		Runnable example = new Runnable() {
			@Override
			public void run() {

				System.out.println("One Thread");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread1 = new Thread(example);
		thread1.start();


		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("End of the program");
	}
}
