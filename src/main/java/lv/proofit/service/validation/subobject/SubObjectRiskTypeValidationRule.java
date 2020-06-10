package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import org.springframework.stereotype.Component;

@Component

public class SubObjectRiskTypeValidationRule implements SubObjectValidationRule{

    @Override
    public void validateSubObject(PolicySubObject policySubObject) {
        checkNotNull(policySubObject);
        if (policySubObject.getRiskTypes().isEmpty()){
            throw new SubObjectValidationException("Choose at least one risk type for " + policySubObject.getSubObjectName());
        }
    }
}
