package Design.RateLimiter.strategy.RateLimit;

import Design.RateLimiter.entites.Rule;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SlidingWindowLog extends  RateLimiterStrategy{

    public SlidingWindowLog(Rule rule){
        super(rule);
    }

    private ConcurrentHashMap<String, Queue<Long>> windowQueue = new ConcurrentHashMap<>();

    @Override
    public boolean handleRequest(String userId) {

        AtomicBoolean allowed = new AtomicBoolean(false);
        Long now = System.currentTimeMillis()/1000;
        windowQueue.compute(userId, (id, log)->{
            if(log == null) {
                log = new ArrayDeque<>();
            }
            while(!log.isEmpty()){
                long time = (now - log.peek());
                if(time > getRule().getWindowDuration()){
                    log.poll();
                }else {
                    break;
                }
            }
            if(log.size() < getRule().getMaxRequest()){
                log.add(now);
                allowed.set(true);
            }
            return log;
        });
        return allowed.get();
    }
}
