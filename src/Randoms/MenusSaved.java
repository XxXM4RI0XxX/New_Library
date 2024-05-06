package Randoms;

import java.util.HashMap;

public class MenusSaved {

    HashMap<Integer,String> map = new HashMap<>();

    public void addToMap(Integer key, String content){
        map.put(key,content);
    }
    public String getFromMap(Integer key){
        return map.get(key);
    }
    public void removeFromMap(Integer key){
        map.remove(key);
    }

}
