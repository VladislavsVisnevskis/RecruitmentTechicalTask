package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SubObjectNameValidationRuleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    SubObjectNameValidationRule victim = new SubObjectNameValidationRule();
    PolicySubObject input;

    @Test
    public void shouldThrowSubObjectNameValidationRule(){
    input = subObject ("Telev!sion");
    exception.expect(SubObjectValidationException.class);
    exception.expectMessage("Policy sub-object name is invalid - " +
            "only letters and numbers are allowed" + '\n' + "Minimal Length 2 and maximal 32 characters");
    victim.validateSubObject(input);
    }

    private PolicySubObject subObject(String name){
    PolicySubObject policySubObject = new PolicySubObject();
    policySubObject.setSubObjectName(name);
    return policySubObject;
    }
}