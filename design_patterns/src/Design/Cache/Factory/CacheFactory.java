package Design.Cache.Factory;

import Design.Cache.Cache.Cache;

public interface CacheFactory<Key,Value> {

     Cache<Key,Value> creatCache(int capacity);

}
