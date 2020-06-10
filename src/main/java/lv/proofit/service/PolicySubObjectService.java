package lv.proofit.service;

import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.domain.policySubObject.RiskType;
import org.springframework.stereotype.Service;

@Service
public class PolicySubObjectService {

    public void addRiskTypeToSubObject (PolicySubObject policySubObject, RiskType risk){
        if (policySubObject == null || risk == null){
            throw new NullPointerException("Incorrect input");
        }
        policySubObject.addRiskType(risk);
    }

    public RiskType removeRiskTypeToSubObject (PolicySubObject policySubObject, RiskType risk){
        if (policySubObject == null || risk == null){
            throw new NullPointerException("Incorrect input");
        }
        policySubObject.removeRiskType(risk);
        return risk;
    }
}
