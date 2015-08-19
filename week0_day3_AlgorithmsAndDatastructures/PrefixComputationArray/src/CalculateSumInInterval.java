import java.util.Iterator;


public class CalculateSumInInterval {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = new int[]{1,2,3,4,5};
        int[] sums = new int[input.length+1];
        sums[0] = 0;
        for (int i = 0; i < input.length; i++) {
            sums[i+1] = sums[i] + input[i];
        }
        
        int a = 0;
        int b = 4;
        System.out.println("Result="+(sums[b+1] - sums[a]));
    }

}
