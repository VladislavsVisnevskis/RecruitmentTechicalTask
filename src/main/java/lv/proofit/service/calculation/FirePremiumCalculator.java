package lv.proofit.service.calculation;

import lv.proofit.domain.policy.Policy;
import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.domain.policySubObject.RiskType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FirePremiumCalculator implements PremiumCalculable{

    @Override
        public BigDecimal calculatePremium(Policy policy) {
        BigDecimal fireCoefficient;
        BigDecimal firePremium = new BigDecimal(0);
        for (PolicyObject policyObject : policy.getPolicyObjectList()){
            for (PolicySubObject policySubObject :policyObject.getSubObjects()){
                if (policySubObject.getRiskTypes().contains(RiskType.FIRE)){
                    if (policySubObject.getSumInsured().compareTo(BigDecimal.valueOf(100)) == 1){
                        fireCoefficient = InsuranceCoefficient.COEFFICIENT_FIRE_INCREASED;
                    }
                    else {
                        fireCoefficient = InsuranceCoefficient.COEFFICIENT_FIRE;
                    }
                    firePremium = firePremium.add(policySubObject.getSumInsured().multiply(fireCoefficient));
                }
            }
        }
        return firePremium;
    }
}
