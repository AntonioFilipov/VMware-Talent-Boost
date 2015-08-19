
public class BenchmarkMain {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Fibonacci fib = new Fibonacci();
//		SumNNumbers num = new SumNNumbers();
//		GivenTask1 res = new GivenTask1();
//		TripleFor calc = new TripleFor();
		FinalTask task = new FinalTask();
		long start = System.currentTimeMillis();
//		fib.fibCacl(20);
//		num.sum(400000000);
//		res.calculate(200000000);
//		calc.calculate(100000);
		task.calculate(2000);
		long stop = System.currentTimeMillis();
		long result = stop - start;
		System.out.println("Time:" + result);

	}

}
