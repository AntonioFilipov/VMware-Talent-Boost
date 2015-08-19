
public class Executable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> a = new Stack<Integer>();
        a.push(3);
        a.push(4);
        a.push(5);
        System.out.println("Size: "+a.size()+"  Capacity: "+a.capacity());
        a.push(6);
        System.out.println("Size: "+a.size()+"  Capacity: "+a.capacity());
        a.push(6);
        System.out.println("Size: "+a.size()+"  Capacity: "+a.capacity());
        a.pop();
        System.out.println("Size: "+a.size()+"  Capacity: "+a.capacity());
        a.pop();
        System.out.println("Size: "+a.size()+"  Capacity: "+a.capacity());
        System.out.println(a.isEmpty());
        a.clear();
        System.out.println("Size: "+a.size()+"  Capacity: "+a.capacity());
    }

}
