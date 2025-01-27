package Design.Cache.Cache;

import Design.Cache.Eviction.EvictionPolicy;

public abstract class Cache<Key,Value> {


    public EvictionPolicy<Key,Value> evictionPolicy;
    public abstract void addKey(Key key, Value value);
    public abstract Value get(Key key);
}
