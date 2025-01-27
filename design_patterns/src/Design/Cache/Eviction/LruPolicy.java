package Design.Cache.Eviction;

import Design.Cache.Eviction.EvictionPolicy;
import Design.Cache.algoritham.DoublyLinkedList;
import Design.Cache.algoritham.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LruPolicy<Key,Value> implements EvictionPolicy<Key,Value> {

    private final Map<Key, DoublyLinkedListNode<Key, Value>> map;
    private final DoublyLinkedList<Key,Value> dll;
    private final int capacity ;
    public LruPolicy(int capacity){
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public Key evict(){
        final DoublyLinkedListNode<Key, Value> lruNode = dll.getFirstNode();
        if (!Objects.isNull(lruNode)){

            dll.detachNode(lruNode);

            map.remove(lruNode.getKey());
            return  lruNode.getKey();

        }else return null;}

    @Override
    public Value keyAccessed(Key key)
    {

        if(map.containsKey(key)){
            final DoublyLinkedListNode<Key,Value> lruNode = map.get(key);
            if(!Objects.isNull(lruNode)){
                dll.detachNode(lruNode);
                dll.insertNodeAtEnd(lruNode);
            }
            return lruNode.getValue();
        }else{
            System.out.println("Cache miss add key to cache");
        }
        return  null;
    }

    @Override
    public void addKey(Key key, Value value){
        if(capacity == map.size()){
            System.out.println("Capacity is full , evicting..");
            Key evictedKey = evict();
            System.out.println("Key evicted = " + evictedKey);

        }
        DoublyLinkedListNode<Key, Value> node = dll.insertElementAtEnd(key, value);
        map.put(key,node);
        System.out.println("Key = " + key +" added ");
    }
}
