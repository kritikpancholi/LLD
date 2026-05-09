package Design.RateLimiter.entites;

import Design.RateLimiter.enums.PlanType;

public class User {
    private String userId;
    private PlanType planType;

    public User(String userId, PlanType planType){
        this.userId = userId;
        this.planType = planType;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public String getUserId() {
        return userId;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }
}
