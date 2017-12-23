package design.hashTable;

public class HashMapTest {
    public static void main(String[] args) {
        HashMapImp<Integer, Integer> yeahNumberMap = new HashMapImp<>(10);

        for (int i = 0; i < 20; i++) {
            yeahNumberMap.put(i, 11 * i);
        }


        System.out.println(yeahNumberMap.getValue(0));
        System.out.println(yeahNumberMap.getValue(14));

        yeahNumberMap.remove(14);
        yeahNumberMap.remove(14);
        System.out.println(yeahNumberMap.getValue(14));
    }


}
