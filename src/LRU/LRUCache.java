package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> m = new HashMap<>();
    Node head = null;
    Node end = null;


    public int get(int key) {
        if (m.containsKey(key)) {
            Node n = m.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    /*
    this will put the give node to the head/frond of the doubly linkedlist
     */
    public  void setHead(Node n) {
        if(head==null){
            n.prev=null;
            head=n;
        } else{
            head.prev=n;
            n.next=head;
            head=n;
        }
        if(end==null){
            end=head;
        }

    }

    /**
     * this will completely first remove the node from the doubly linkedlist
     * @param n
     */
    private  void remove(Node n) {

        if(n.prev !=null){
            n.prev.next=n.next;
        } else{
            head = n.next;
        }
        if(n.next !=null){
            n.next.prev=n.prev;
        } else{
            end =n.prev;
        }
    }

    public void set(int key, int value){
        if(m.containsKey(key)){
            Node old = m.get(key);
            old.value=value;
            remove(old);
            setHead(old);
        } else {
            Node newNode = new Node(key,value);
            if(m.size()>=capacity){
                System.out.println("Max capacity reached , deleting "+end.value);
                m.remove(end);
                remove(end);
                m.put(key,newNode);
            } else{
                setHead(newNode);
                m.put(key,newNode);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.capacity=1;
        lruCache.set(3,4);
        lruCache.set(5,7);
        lruCache.set(5,99);
        lruCache.set(8,8);
        System.out.println(lruCache.get(8));

    }
}
