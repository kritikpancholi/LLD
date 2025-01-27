package Design.Cache.Eviction;

public interface EvictionPolicy<Key, Value> {

    Key evict();
    Value keyAccessed(Key key);
    void addKey(Key key, Value value);
}
