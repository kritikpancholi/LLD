package Design.BookMyShow.Strategy.locking;

public interface LockProvider {
    boolean tryLock(String key, int userId, long ttlMs);
    void unlock(String key);
    boolean isLockExpired(String key);
    boolean isLockBy(String key, int userId);
}
