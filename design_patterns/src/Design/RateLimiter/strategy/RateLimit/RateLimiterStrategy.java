package Design.RateLimiter.strategy.RateLimit;

import Design.RateLimiter.entites.Rule;

public abstract class RateLimiterStrategy {

    private Rule rule;

    public RateLimiterStrategy(Rule rule){
        this.rule = rule;
    }

    public abstract boolean handleRequest(String userId);

    public Rule getRule(){
        return rule;
    }
}
