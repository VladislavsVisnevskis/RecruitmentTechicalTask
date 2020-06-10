package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.domain.policySubObject.RiskType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SubObjectRiskTypeValidationRuleTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    SubObjectRiskTypeValidationRule victim = new SubObjectRiskTypeValidationRule();
    PolicySubObject input;

    @Test
    public void shouldThrowSubObjectRiskTypeValidationRule(){
        input = subObject (null);
        exception.expect(SubObjectValidationException.class);
        exception.expectMessage("Choose at least one risk type for test");
        victim.validateSubObject(input);
    }

    private PolicySubObject subObject(RiskType riskType){
        PolicySubObject policySubObject = new PolicySubObject();
        policySubObject.setSubObjectName("test");
        return policySubObject;
    }
}