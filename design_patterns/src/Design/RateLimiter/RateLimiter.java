package Design.RateLimiter;

import Design.RateLimiter.entites.Rule;
import Design.RateLimiter.entites.User;
import Design.RateLimiter.enums.PlanType;
import Design.RateLimiter.exception.UserNotFoundException;
import Design.RateLimiter.strategy.RateLimit.RateLimiterStrategy;

import java.util.*;

public class RateLimiter {

    private Map<String, User> usermap;
    private Map<PlanType, RateLimiterStrategy> rateLimiterStrategyMap;

    public RateLimiter(){
        this.usermap = new HashMap<>();
        this.rateLimiterStrategyMap = new HashMap<>();
    }

    public boolean checkRequest(String userId){
        // get user plan type
        User user = usermap.get(userId);
        if(user != null){
            PlanType userPlanType = user.getPlanType();
           RateLimiterStrategy rateLimiter = rateLimiterStrategyMap.get(userPlanType);

           if(rateLimiter != null){
               return rateLimiter.handleRequest(user.getUserId());
           }else {
               System.out.println("No rate limiter present");
           }
        }else {
            throw new UserNotFoundException("User with user id = " + userId + " not available");
        }
        return false;
    }

    public User createUser(PlanType planType){
        User newUser = new User(UUID.randomUUID().toString(), planType);
        usermap.put(newUser.getUserId(), newUser);
        return newUser;
    }

    public void setRateLimiter(PlanType planType, RateLimiterStrategy rateLimiterStrategy){
        rateLimiterStrategyMap.put(planType, rateLimiterStrategy);
        System.out.println("New Config setup for planType " + planType + " maxRequest = " + rateLimiterStrategy.getRule().getMaxRequest()
                +" in second = " + rateLimiterStrategy.getRule().getWindowDuration());
    }
}
