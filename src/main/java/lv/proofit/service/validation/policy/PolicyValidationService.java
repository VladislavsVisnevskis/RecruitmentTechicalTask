package lv.proofit.service.validation.policy;

import lv.proofit.domain.policy.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component

public class PolicyValidationService {

    private final Set<PolicyValidationRule> validationRules;

    @Autowired
    public PolicyValidationService(Set<PolicyValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate (Policy policy){
        validationRules.forEach(rule ->
                rule.validatePolicy(policy));
    }
}
