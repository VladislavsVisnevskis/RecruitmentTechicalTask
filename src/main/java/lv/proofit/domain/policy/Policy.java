package lv.proofit.domain.policy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lv.proofit.domain.policyObject.PolicyObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
@Component

public class Policy {

    @Setter
    private String policyNumber;
    @Setter
    private PolicyStatus status;
    private List<PolicyObject> policyObjectList = new ArrayList<>();

    public PolicyObject addPolicyObject( PolicyObject policyObject){
        policyObjectList.add(policyObject);
        return policyObject;
    }

    public PolicyObject removePolicyObject( PolicyObject policyObject){
        policyObjectList.remove(policyObject);
        return policyObject;
    }

}
