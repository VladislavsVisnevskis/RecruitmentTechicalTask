package lv.proofit.service.validation.object;

import lv.proofit.domain.policyObject.PolicyObject;
import org.springframework.stereotype.Component;

@Component

public class ObjectNameValidationRule implements ObjectValidationRule {

    @Override
    public void validateObject(PolicyObject policyObject) {
        checkNotNull(policyObject);
        if (!policyObject.getName().matches("[A-Za-z0-9]+")
                || policyObject.getName().length() < 2
                || policyObject.getName().length() > 32) {
            throw new ObjectValidationException("Policy object name is invalid - " +
                    "only letters and numbers are allowed" + '\n' + "Minimal Length 2 and maximal 32 characters");
        }
    }
}
