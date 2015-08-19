package Racer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Racer.Racer;

public class Executor {

	public static int counter=0;
	
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newFixedThreadPool(100);
//		ExecutorService executor = Executors.newSingleThreadExecutor();


		List<Future<?>> threads = new ArrayList<Future<?>>();

		for (int i = 0; i < 10000; i++) {
			Future<?> exec = executor.submit(new Racer("Racer "+i));
			threads.add(exec);
		}

		Thread.sleep(1000);
		System.out.println(counter);
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).get();
		}
		
		executor.shutdown();

	}
}
