package lv.proofit.service;

import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.service.validation.subobject.SubObjectValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyObjectService {

    private final SubObjectValidationService subObjectValidationService;

    @Autowired
    public PolicyObjectService(SubObjectValidationService subObjectValidationService) {
        this.subObjectValidationService = subObjectValidationService;
    }

    public PolicySubObject assignSubObject(PolicyObject policyObject, PolicySubObject policySubObject){
        subObjectValidationService.validate(policySubObject);
        policyObject.addSubObject(policySubObject);
        return policySubObject;
    }

    public PolicySubObject withdrawSubObject(PolicyObject policyObject, PolicySubObject policySubObject) {
        policyObject.removeSubObject(policySubObject);
        return policySubObject;
    }
}

