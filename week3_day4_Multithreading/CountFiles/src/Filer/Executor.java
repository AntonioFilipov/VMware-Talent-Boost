package Filer;

public class Executor {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        final String firstDirectoryName = "C:\\Windows";
        final String secondDirectoryName = "C:\\Program Files";

        long start;
        long stop;
        long result;

        Filer filer1 = new Filer(firstDirectoryName);
        Filer filer2 = new Filer(secondDirectoryName);

        Thread first = new Thread(filer1);

        Thread second = new Thread(filer2);

        start = System.currentTimeMillis();
        first.start();
        second.start();
        first.join();
        second.join();
        stop = System.currentTimeMillis();
        result = stop - start;

        System.out.println();
        System.out.println("Result:" + result);

    }

}
