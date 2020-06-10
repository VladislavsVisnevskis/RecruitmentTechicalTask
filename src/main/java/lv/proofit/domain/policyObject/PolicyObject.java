package lv.proofit.domain.policyObject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lv.proofit.domain.policySubObject.PolicySubObject;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
@Component

public class PolicyObject {

    @Setter
    private String name;
    private Set<PolicySubObject> subObjects = new HashSet<>();

    public PolicySubObject addSubObject(PolicySubObject policySubObject){
        subObjects.add(policySubObject);
        return policySubObject;
    }

    public PolicySubObject removeSubObject(PolicySubObject policySubObject){
        subObjects.remove(policySubObject);
        return policySubObject;
    }

}

