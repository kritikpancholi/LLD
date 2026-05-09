package Design.RateLimiter;

import Design.RateLimiter.entites.Rule;
import Design.RateLimiter.entites.User;
import Design.RateLimiter.enums.PlanType;
import Design.RateLimiter.strategy.RateLimit.RateLimiterStrategy;
import Design.RateLimiter.strategy.RateLimit.SlidingWindowLog;
import Design.RateLimiter.strategy.RateLimit.TokenBucket;

public class RateLimiterDriver {

    public void run(){
    try {
        RateLimiter rateLimiter = new RateLimiter();
        User freeUser = rateLimiter.createUser(PlanType.FREE);
        User premiumUser = rateLimiter.createUser(PlanType.PREMIUM);

        rateLimiter.setRateLimiter(PlanType.FREE, new SlidingWindowLog(new Rule(3, 5)));

        rateLimiter.setRateLimiter(PlanType.PREMIUM, new TokenBucket(new Rule(5, 5)));

//        for (int i = 0; i < 30; i++) {
//            boolean freeCheck = rateLimiter.checkRequest(freeUser.getUserId());
////            boolean premiumCheck = rateLimiter.checkRequest(premiumUser.getUserId());
//
//            System.out.println("For free = " + freeCheck + " at i= "+i);
////            System.out.println("For premium = " + premiumCheck + " at i= " + i);
//                Thread.sleep(1000L);
//        }

        System.out.println("Consume all");

        for (int i = 1; i <= 5; i++) {
            System.out.println(rateLimiter.checkRequest(premiumUser.getUserId()));
        }

        System.out.println("Should fail:");
        System.out.println(rateLimiter.checkRequest(premiumUser.getUserId()));

        Thread.sleep(2000);

        System.out.println("After 2 sec refill");

        System.out.println(rateLimiter.checkRequest(premiumUser.getUserId()));
        System.out.println(rateLimiter.checkRequest(premiumUser.getUserId()));
        System.out.println(rateLimiter.checkRequest(premiumUser.getUserId()));
    }
    catch (Exception e){
        System.out.println(e);
    }

    }
}
