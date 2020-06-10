package lv.proofit.service.validation.object;

import lv.proofit.domain.policy.Policy;
import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.service.validation.policy.PolicyValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ObjectValidationService {

    @Autowired
    private final Set<ObjectValidationRule> validationRules;

    public ObjectValidationService(Set<ObjectValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate (PolicyObject policyObject){
        validationRules.forEach(rule ->
                rule.validateObject(policyObject));
    }
}
