package com.zmm.interview.LRU;

import java.util.HashMap;

/**
 * @author: zmm
 * @time: 2021/3/9 16:31
 */
public class LRUTest {

}

class CacheMap extends HashMap {
    HashMap<String, LRUEntry> hashMap = new HashMap<>();
    LRUEntry head = null;
    LRUEntry tail = null;
    static int cacheSize = 10;
    int size = 0;

    public synchronized void put(String key, Object value){
        if(hashMap.containsKey(key)){
            removeEntry(hashMap.get(key));
        }
        addTail(key, value);
    }

    public synchronized Object get(String key){
        LRUEntry cache = hashMap.get(key);
        removeEntry(cache);
        addTail(key, cache.getValue());
        return cache.getValue();
    }

    private void addTail(String key, Object value){
        if(size >= cacheSize){
            removeEntry(head);
            hashMap.remove(head.getKey());
        }
        LRUEntry entry = new LRUEntry(tail, null, key, value);
        size++;
        tail = entry;
        if(head == null){
            head = entry;
        }
    }

    private void removeEntry(LRUEntry entry){
        LRUEntry pre = entry.getPre();
        LRUEntry next = entry.getNext();
        pre.setNext(next);
        size--;
        if(entry.equals(head)){
            head = next;
        }
        if(entry.equals(tail)){
            tail = next;
        }
    }
}

class LRUEntry{
    private LRUEntry pre;
    private LRUEntry next;
    private String key;
    private Object value;

    public LRUEntry(LRUEntry pre, LRUEntry next, String key, Object value) {
        this.pre = pre;
        this.next = next;
        this.key = key;
        this.value = value;
    }

    public LRUEntry getPre() {
        return pre;
    }

    public void setPre(LRUEntry pre) {
        this.pre = pre;
    }

    public LRUEntry getNext() {
        return next;
    }

    public void setNext(LRUEntry next) {
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}