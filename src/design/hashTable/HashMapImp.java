package design.hashTable;

import java.util.ArrayList;

public class HashMapImp<K, V> {

    private ArrayList<LinkListNode<K, V>> mapData;
    private int capacity;
    private int totalItem;

    HashMapImp(int capacity) {
        this.capacity = capacity;
        mapData = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            mapData.add(null);
        }
    }

    public void put(K k, V v) {

        LinkListNode<K, V> node = getNode(k);
        if (node != null) {
            node.v = v;
            totalItem++;
            return;
        }
        int index = getIndex(k);
        node = new LinkListNode(k, v);

        if (mapData.get(index) != null) {
            mapData.get(index).previous = node;
            node.next = mapData.get(index);
        }
        mapData.set(index, node);
    }

    public boolean remove(K key) {
        LinkListNode<K, V> node = getNode(key);
        if (node == null) {
            return false;
        }

        //if head need to be deleted
        if (node.previous == null) {
            int index = getIndex(key);
            mapData.set(index, null);
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        return true;
    }

    public V getValue(K key) {
        LinkListNode<K, V> node = getNode(key);
        if(node==null){
            return null;
        }
        return node.v;
    }


    private LinkListNode<K, V> getNode(K k) {

        int index = getIndex(k);
        LinkListNode<K, V> node = mapData.get(index);
        while (node != null) {

            if (node.k == k) {
                return node;
            }
            node = node.next;
        }
        return null;

    }

    private int getIndex(K k) {
        return Math.abs(k.hashCode() % mapData.size());
    }


    private class LinkListNode<K, V> {
        private K k;
        private V v;
        LinkListNode<K, V> next;
        LinkListNode<K, V> previous;

        LinkListNode(K k, V v) {
            this.k = k;
            this.v = v;
            this.next = null;
            this.previous = null;
        }
    }


}
