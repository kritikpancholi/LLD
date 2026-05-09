package Design.RateLimiter.entites;

public class Rule {
    private final int maxRequest;
    private final long windowDuration;

    public Rule(int maxRequest, long windowDuration){
        this.maxRequest = maxRequest;
        this.windowDuration = windowDuration;
    }

    public int getMaxRequest() {
        return maxRequest;
    }

    public long getWindowDuration() {
        return windowDuration;
    }
}
