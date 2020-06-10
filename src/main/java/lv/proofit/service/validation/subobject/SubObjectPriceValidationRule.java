package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component

public class SubObjectPriceValidationRule implements SubObjectValidationRule {

    @Override
    public void validateSubObject(PolicySubObject policySubObject) {
        checkNotNull(policySubObject);
        if (policySubObject.getSumInsured().compareTo(BigDecimal.valueOf(0)) <= 1){
            throw new SubObjectValidationException("Insurance sum must be higher than 0");
        }
    }
}
