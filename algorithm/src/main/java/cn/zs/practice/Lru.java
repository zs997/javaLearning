package cn.zs.practice;

import java.util.LinkedHashMap;

public class Lru {
    LinkedHashMap<String,String> map = new LinkedHashMap<>();
    Lru(){}
    public void  put(String key,String value){
        if (map.containsKey(key)){
            map.remove(key);
        }
        map.put(key,value);
    }
    public String get(String key){
        if (map.containsKey(key)){
            String res = map.get(key);
            map.remove(key);
            map.put(key,res);
            return res;
        }
        return null;
    }
}
