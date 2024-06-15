package tn.esprit.oumaimarouis.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DonationAspect {

    @After("execution(* tn.esprit.oumaimarouis.service.IDonation.addDonation(..))")
    public void afterAddDonation() {
        System.out.println("Merci pour ce don");
    }
}