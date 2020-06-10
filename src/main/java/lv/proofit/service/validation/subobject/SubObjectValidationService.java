package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component

public class SubObjectValidationService {

    private final Set<SubObjectValidationRule> validationRules;

    @Autowired
    public SubObjectValidationService(Set<SubObjectValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate (PolicySubObject policySubObject){
        validationRules.forEach(rule ->
                rule.validateSubObject(policySubObject));
    }
}
