
public class Execution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue<Integer> a = new Queue<Integer>();
        a.enqueueBack(2);
        a.enqueueBack(3);
        a.enqueueBack(4);
        a.enqueueBack(5);
        a.enqueueFront(6);
        System.out.println(a.dequeFront());
        System.out.println(a.dequeFront());
        System.out.println(a.dequeFront());



    }

}
