// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

/*
Design and Implement and LRU
- LRU has a limited capacity
- LRU contains key, value pairs
- k, v are non-negative integers
- "use": add, get or update existing

LRU(capacity=5)
Put (1, 10), (2, 20), (3, 30), (4, 40), (5, 50)
Get 2  # expect 20 
Put (6, 60) # evict 1

void put(int key, int value)
int get(int key)

hashmap + doubly-linked list

runtime:

get(): O(?) O(1)

put(): O(?) O(log(n))

*/
import java.util.*;

public class LRUCache {
    
    class LinkedListNode {
        int key;
        int value;
        LinkedListNode prev;
        LinkedListNode next;
        LinkedListNode() {
            this.key = 0;
            this.value = 0;
        }
        
        LinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    final int CAPACITY;
    int count; 
    Map<Integer, LinkedListNode> cacheMap;
    LinkedListNode head;
    LinkedListNode tail;
    
    
    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.count = 0;
        cacheMap = new HashMap<Integer, LinkedListNode>();
        head = new LinkedListNode();
        tail = new LinkedListNode();
        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        LinkedListNode curr = cacheMap.get(key);
        if(curr == null) {
            return -1;
        }
        
        return curr.value;
    }
    
    // runtime: O(log(n))
    public void put(int key, int value) {
        LinkedListNode curr = cacheMap.get(key);
        if(curr == null) {
            curr = new LinkedListNode(key, value);
            cacheMap.put(key, curr);
            insert(curr);
            count += 1;
        } else {
            curr.value = value;
            update(curr);
        }
        
        if(count > CAPACITY) {
            LinkedListNode temp = tail.prev;
            delete(temp);
            cacheMap.remove(temp.key);
            count -= 1;
        }
    }
    
    void insert(LinkedListNode node) {
        // insert after head
        LinkedListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    void update(LinkedListNode node) {
        // move to front
        delete(node);
        insert(node);
    }
    
    void delete(LinkedListNode node) {
        // delete node from linked list
        LinkedListNode prev = node.prev;
        LinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    
    static void testEmptyCache() {
        // tests empty cache cache miss
        LRUCache myCache1 = new LRUCache(1);
        assert myCache1.get(0)==-1;
        System.out.println("Empty Cache test PASS");
    }
    
    static void testInsertion() {
        LRUCache myCache2 = new LRUCache(1);
        myCache2.put(1, 10);
        assert myCache2.get(1) == 10;
        System.out.println("Insertion test PASS");
    }
    
    static void testRetrievingMultipleElements() {
        LRUCache myCache3 = new LRUCache(3);
        myCache3.put(1, 10);
        myCache3.put(2, 20);
        myCache3.put(3, 30);
        assert (myCache3.get(1) == 10) && (myCache3.get(2) == 20) && (myCache3.get(3) == 30);
        System.out.println("Retrieving Multiple Elements test PASS");
    }
    
    static void testUpdatingElements() {
        LRUCache myCache4 = new LRUCache(3);
        myCache4.put(1, 10);
        myCache4.put(2, 20);
        myCache4.put(1, 30);
        assert (myCache4.get(1) == 30) && (myCache4.get(2) == 20);
        System.out.println("Updating Elements test PASS");
    }
     
    // eviction
    static void testEviction() {
        LRUCache myCache5 = new LRUCache(5);
        myCache5.put(1, 10);
        myCache5.put(2, 20);
        myCache5.put(3, 30);
        myCache5.put(4, 40);
        myCache5.put(5, 50);
        myCache5.put(6, 60); // evict 1
        assert (myCache5.get(1) == -1) && (myCache5.get(2) == 20) && (myCache5.get(3) == 30) && (myCache5.get(4) == 40) && (myCache5.get(5) == 50) && (myCache5.get(6) == 60);
        System.out.println("Eviction test PASS");
    }
    
    public static void main(String[] args) {
        testEmptyCache(); 
        testInsertion(); 
        testRetrievingMultipleElements(); 
        testUpdatingElements(); 
        testEviction(); 
    }
}

// is this LRUCache thread-safe? No. 





