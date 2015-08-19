package Filer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        final String firstDirectoryName = "C:\\Windows";
        final String secondDirectoryName = "C:\\Program Files";

        long start;
        long stop;
        long result;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        List<Future<?>> threads = new ArrayList<Future<?>>();
        
        Filer[] filers = {
                new Filer(firstDirectoryName),
                new Filer(secondDirectoryName)
        };

        start = System.currentTimeMillis();

        for (int i = 0; i < filers.length; i++) {
        	Future<?> exec = executor.submit(filers[i]);
            threads.add(exec);
        }
        
        for (int i = 0; i < threads.size(); i++) {
        	threads.get(i).get();
		}
        
        stop = System.currentTimeMillis();
        result = stop - start;

        System.out.println();
        System.out.println("Result:" + result);
        
        executor.shutdown();

    }

}
