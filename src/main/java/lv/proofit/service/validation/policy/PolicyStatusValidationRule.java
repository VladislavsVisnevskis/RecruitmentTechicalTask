package lv.proofit.service.validation.policy;

import lv.proofit.domain.policy.Policy;
import org.springframework.stereotype.Component;

@Component

public class PolicyStatusValidationRule implements PolicyValidationRule {
    @Override
    public void validatePolicy(Policy policy) {
        checkNotNull(policy);
        if (policy.getStatus() == null){
            throw new PolicyValidationException("Choose the policy status");
        }
    }
}
