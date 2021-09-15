package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class LRU<E>{

    LinkedList<Node> linkedList = new LinkedList();

    Map<String,Node>  map = new HashMap();

    //最大容量默认3
    private int cap = 3;


     public void put(String key,E e){
         Node node = new Node(key,e);
         map.put(key,node);
         if(cap == linkedList.size()){
          Node last = linkedList.removeLast();
          map.remove(last.getKey());
         }else{
             if(map.get(key)!= null){
                 linkedList.remove(e);
             }
         }
         linkedList.addFirst(node);
     }

     public  E  get(String key){
         return  map.get(key).value;
     }

     public LinkedList<E> getLRUList(){
         LinkedList valueList = new LinkedList();
         linkedList.stream().map(p -> p.value).forEach(valueList :: add);
         return valueList;
     }


    public static void main(String[] args) {
          LRU<String> lru = new LRU();
          lru.put("1","2");
          lru.put("2","3");
          lru.put("1","2");
          lru.put("4","4");
          lru.put("5","5");
          lru.getLRUList().forEach(System.out ::println );

    }


    public class Node{
       private   String key;
       private   E value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        Node(String key, E value){
            this.key = key;
            this.value = value;
        }

    }

     
}
