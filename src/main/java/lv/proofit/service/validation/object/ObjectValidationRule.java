package lv.proofit.service.validation.object;

import lv.proofit.domain.policyObject.PolicyObject;

public interface ObjectValidationRule {

    public void validateObject(PolicyObject policyObject);

    default void checkNotNull(PolicyObject policyObject) throws NullPointerException {
        if (policyObject == null) {
            throw new IllegalArgumentException("Policy object must not be null");
        }
    }
}
