
public class Executable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashTable table = new HashTable(2);
        table.insert("adad");
        table.insert("okde");

        System.out.println(table.collisionCount());
        System.out.println("Capacity:"+table.capacity());
        System.out.println("Size:"+ table.size());
        System.out.println("Find adad:"+table.find("adad"));
        System.out.println("Find okde:"+table.find("okde"));
        System.out.println("Find smth else:"+table.find("smth else"));


    }

}
