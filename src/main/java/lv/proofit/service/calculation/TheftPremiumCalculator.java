package lv.proofit.service.calculation;

import lv.proofit.domain.policy.Policy;
import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.domain.policySubObject.RiskType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TheftPremiumCalculator implements PremiumCalculable{

    @Override
    public BigDecimal calculatePremium(Policy policy) {
        BigDecimal theftCoefficient;
            BigDecimal firePremium = new BigDecimal(0);
            for (PolicyObject policyObject : policy.getPolicyObjectList()){
                for (PolicySubObject policySubObject :policyObject.getSubObjects()){
                    if (policySubObject.getRiskTypes().contains(RiskType.THEFT)){
                        if (policySubObject.getSumInsured().compareTo(BigDecimal.valueOf(15)) >= 0){
                            theftCoefficient = InsuranceCoefficient.COEFFICIENT_THEFT_DECREASED;
                        }
                        else {
                            theftCoefficient = InsuranceCoefficient.COEFFICIENT_THEFT;
                        }
                        firePremium = firePremium.add(policySubObject.getSumInsured().multiply(theftCoefficient));
                    }
                }
            }
            return firePremium;
        }
}
