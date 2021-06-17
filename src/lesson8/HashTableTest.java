package lesson8;

public class HashTableTest {
    public static void main(String[] args) {
        HashTableList hashTableTest = new HashTableList(15);
        hashTableTest.add(245, 150);
        hashTableTest.add(8, 100);
        hashTableTest.add(1, 320);
        hashTableTest.add(7, 190);
        hashTableTest.add(13, 550);
        hashTableTest.add(5, 340);

        System.out.println(hashTableTest.display()); // [ {  } {  320  } {  } {  } {  } {  150  340  } {  } {  190  } {  100  } {  } {  } {  } {  } {  550  } {  } ]

        System.out.println(hashTableTest.indexOf(8));
        hashTableTest.remove(8);

        System.out.println(hashTableTest.display());
    }

}
