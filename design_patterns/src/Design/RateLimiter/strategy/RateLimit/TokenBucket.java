package Design.RateLimiter.strategy.RateLimit;

import Design.RateLimiter.entites.Rule;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TokenBucket extends RateLimiterStrategy {

    private final ConcurrentHashMap<String, Integer> userTokenBucket;
    private final ConcurrentHashMap<String, Long> lastRefill;

    public TokenBucket(Rule rule) {
        super(rule);
        this.userTokenBucket = new ConcurrentHashMap<>();
        this.lastRefill = new ConcurrentHashMap<>();
    }

    @Override
    public boolean handleRequest(String userId) {
        long now = System.currentTimeMillis();
        AtomicBoolean allowed = new AtomicBoolean(false);

        userTokenBucket.compute(userId, (id, existingTokens) -> {

            if (existingTokens == null) {
                existingTokens = getRule().getMaxRequest();
                lastRefill.put(id, now);
            }

            int currentTokens = refillToken(id, existingTokens, now);

            if (currentTokens > 0) {
                allowed.set(true);
                return currentTokens - 1;
            }

            return currentTokens;
        });

        return allowed.get();
    }

    private int refillToken(String id, int currentTokens, long now) {

        long lastRefilled = lastRefill.get(id);

        long refillIntervalMillis =
                (getRule().getWindowDuration() * 1000L)
                        / getRule().getMaxRequest();

        long elapsed = now - lastRefilled;

        int tokensToAdd = (int)(elapsed / refillIntervalMillis);

        if (tokensToAdd > 0) {
            currentTokens = Math.min(
                    getRule().getMaxRequest(),
                    currentTokens + tokensToAdd
            );

            lastRefill.put(
                    id,
                    lastRefilled + (tokensToAdd * refillIntervalMillis)
            );
        }

        return currentTokens;
    }
}