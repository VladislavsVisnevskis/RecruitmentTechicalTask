package lv.proofit.service.calculation;

import lv.proofit.domain.policy.Policy;
import lv.proofit.service.validation.policy.PolicyValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class PremiumCalculator {

    private final Set<PremiumCalculable> premiumCalculations;
    private final PolicyValidationService policyValidationService;

    @Autowired
    public PremiumCalculator(Set<PremiumCalculable> premiumCalculations, PolicyValidationService policyValidationService) {
        this.premiumCalculations = premiumCalculations;
        this.policyValidationService = policyValidationService;
    }

    public BigDecimal calculateTotalPremium(Policy policy){
        policyValidationService.validate(policy);
        BigDecimal totalPremium = new BigDecimal(0);
        for (PremiumCalculable premium : premiumCalculations){
            totalPremium = totalPremium.add(premium.calculatePremium(policy));
        }
        return totalPremium;
    }
}
