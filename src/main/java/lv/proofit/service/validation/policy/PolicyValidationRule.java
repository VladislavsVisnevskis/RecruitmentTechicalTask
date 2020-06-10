package lv.proofit.service.validation.policy;

import lv.proofit.domain.policy.Policy;

public interface PolicyValidationRule {

    public void validatePolicy(Policy policy);

    default void checkNotNull(Policy policy) throws NullPointerException {
        if (policy == null) {
            throw new IllegalArgumentException("Policy must not be null");
        }
    }
}
