package lv.proofit.service.validation.policy;

import lv.proofit.domain.policy.Policy;
import lv.proofit.service.validation.object.ObjectValidationException;
import org.springframework.stereotype.Component;

@Component

public class PolicyNameValidationRule implements PolicyValidationRule{

    @Override
    public void validatePolicy(Policy policy) {
        checkNotNull(policy);
        if (!policy.getPolicyNumber().matches("[A-Za-z0-9-]+")
                || policy.getPolicyNumber().length() < 2
                || policy.getPolicyNumber().length() > 32) {
            throw new ObjectValidationException("Policy number is invalid - " +
                    "only letters,numbers and sign \"-\"  are allowed" + '\n' + "Minimal Length 2 and maximal 32 characters");
        }
    }
}
