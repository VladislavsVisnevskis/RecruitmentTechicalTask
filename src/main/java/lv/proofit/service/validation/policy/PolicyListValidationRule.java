package lv.proofit.service.validation.policy;

import lv.proofit.domain.policy.Policy;
import org.springframework.stereotype.Component;

@Component

public class PolicyListValidationRule implements PolicyValidationRule{

    @Override
    public void validatePolicy(Policy policy) {
        checkNotNull(policy);
        if (policy.getPolicyObjectList().isEmpty())
            throw new PolicyValidationException("List of assigned objects is empty");
    }
}
