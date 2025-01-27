package Design.Cache.Factory;

import Design.Cache.Cache.Cache;
import Design.Cache.Eviction.EvictionPolicy;
import Design.Cache.Eviction.LruPolicy;
import Design.Cache.Cache.LruCache;

public class LruFactory<Key,Value> implements CacheFactory<Key,Value> {

    public LruCache<Key,Value> creatCache(int capacity){
        return new LruCache<Key,Value>(capacity);
    }

}
