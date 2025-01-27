package Design.Cache.Cache;

import Design.Cache.Eviction.LruPolicy;

public class LruCache<Key,Value> extends Cache<Key,Value> {


    public LruCache(int capacity){
        this.evictionPolicy = new LruPolicy<>(capacity);
    }

    @Override
    public void addKey(Key key, Value value){
        evictionPolicy.addKey(key, value);
    }

    @Override
    public Value get(Key key){
        Value val = (Value)evictionPolicy.keyAccessed(key);
        return val;
    }


}
