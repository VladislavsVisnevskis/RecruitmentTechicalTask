package lv.proofit.service;

import lv.proofit.domain.policy.Policy;
import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.service.validation.object.ObjectValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    private final ObjectValidationService objectValidationService;

    @Autowired
    public PolicyService(ObjectValidationService objectValidationService) {
        this.objectValidationService = objectValidationService;
    }

    public PolicyObject assignObjectToPolicy(Policy policy, PolicyObject policyObject){
        objectValidationService.validate(policyObject);
        policy.addPolicyObject(policyObject);
        return policyObject;
    }

    public PolicyObject withdrawObjectFromPolicy(Policy policy, PolicyObject policyObject) {
        policy.removePolicyObject(policyObject);
        return policyObject;
    }
}
