package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import org.springframework.stereotype.Component;

@Component

public class SubObjectNameValidationRule implements SubObjectValidationRule {

    @Override
    public void validateSubObject(PolicySubObject policySubObject) throws SubObjectValidationException {
        checkNotNull(policySubObject);
        if (!policySubObject.getSubObjectName().matches("[A-Za-z0-9]+")
                || policySubObject.getSubObjectName().length() < 2
                || policySubObject.getSubObjectName().length() > 32) {
            throw new SubObjectValidationException("Policy sub-object name is invalid - " +
                    "only letters and numbers are allowed" + '\n' + "Minimal Length 2 and maximal 32 characters");
        }
    }
}
