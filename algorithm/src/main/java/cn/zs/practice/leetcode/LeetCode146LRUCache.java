package cn.zs.practice.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LeetCode146LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap();
    public LeetCode146LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.keySet().contains(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
       // ArrayList
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() == capacity){
            return;
        }
        if(map.keySet().contains(key)){
            map.remove(key);
        }
        map.put(key,value);
    }
}

/**
 *
 */