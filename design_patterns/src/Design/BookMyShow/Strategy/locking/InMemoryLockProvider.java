package Design.BookMyShow.Strategy.locking;

import java.util.concurrent.*;

public class InMemoryLockProvider implements LockProvider{

    private static class Expiry{
        final int owner;
        final long deadline;

        Expiry(long deadline, int owner){
            this.deadline = deadline;
            this.owner = owner;
        }
    }
    private final ConcurrentHashMap<String, Expiry> locks = new ConcurrentHashMap<>();
    private final ScheduledExecutorService sweeper = Executors.newSingleThreadScheduledExecutor();

    public InMemoryLockProvider(){
        this.sweeper.scheduleAtFixedRate(this::sweep, 1, 1, TimeUnit.MINUTES);
    }

    private void sweep(){
        long now  = System.currentTimeMillis();
        locks.entrySet().removeIf(e -> (e.getValue().deadline <= now));
    }

    @Override
    public boolean tryLock(String key, int userId, long ttlMs) {
        long now = System.currentTimeMillis();
        Expiry expiry = new Expiry(now + ttlMs , userId);
        // if true we are successful on locking else not
        return locks.compute(key, (k,v) -> (v == null || v.deadline <= now) ? expiry : v) == expiry;
    }

    @Override
    public void unlock(String key) {
        locks.remove(key);
    }

    @Override
    public boolean isLockExpired(String key) {
        Expiry e = locks.get(key);
        return e != null && e.deadline < System.currentTimeMillis();
    }

    @Override
    public boolean isLockBy(String key, int userId) {
        Expiry e = locks.get(key);
        return e != null && e.owner == userId;
    }
}
