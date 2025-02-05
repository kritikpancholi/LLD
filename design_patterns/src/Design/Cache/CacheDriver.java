package Design.Cache;

import Design.Cache.Cache.Cache;
import Design.Cache.Factory.LruFactory;
public class CacheDriver {

    LruFactory<Integer,String> lru;

    public CacheDriver(){
        this.lru = new LruFactory<Integer,String>();
        Cache<Integer,String> cache = lru.creatCache(5);
        cache.addKey(1,"this is kritik_1");
        cache.addKey(2,"this is kritik_2");
        cache.addKey(3,"this is kritik_3");
        cache.addKey(4,"this is kritik_4");
        cache.addKey(5,"this is kritik_5");


//        should give capacity full and then add 6 so will remove key 1
        cache.addKey(6,"this is kritik_6");
//        cache.addKey(3,"this is kritik_3");
        String key2 = cache.get(2);
        System.out.println("got key 2 value = " + key2);
//        now when we add new one it will evict 3 bcoz 2 is recently used.
        cache.addKey(7,"this is kritik_8");

    }
}
