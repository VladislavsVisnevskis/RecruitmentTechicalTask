package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;

public interface SubObjectValidationRule {

    public void validateSubObject(PolicySubObject policySubObject);

    default void checkNotNull(PolicySubObject policySubObject) throws NullPointerException {
        if (policySubObject == null) {
            throw new IllegalArgumentException("Policy sub-object must not be null");
        }
    }
}
