package lv.proofit.service.validation.object;

import lv.proofit.domain.policyObject.PolicyObject;
import org.springframework.stereotype.Component;

@Component

public class ObjectContentValidation implements ObjectValidationRule{

    @Override
    public void validateObject(PolicyObject policyObject) {
        checkNotNull(policyObject);
        if (policyObject.getSubObjects().isEmpty()) {
            throw new ObjectValidationException("No sub-objects are assigned to object " + policyObject.getName());
        }
    }
}
