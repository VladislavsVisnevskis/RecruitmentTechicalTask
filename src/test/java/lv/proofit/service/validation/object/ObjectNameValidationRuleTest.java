package lv.proofit.service.validation.object;

import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.service.validation.subobject.SubObjectNameValidationRule;
import lv.proofit.service.validation.subobject.SubObjectValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ObjectNameValidationRuleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    ObjectNameValidationRule victim = new ObjectNameValidationRule();
    PolicyObject input;

    @Test
    public void shouldThrowSubObjectNameValidationRule(){
        input = object ("Hou$e");
        exception.expect(ObjectValidationException.class);
        exception.expectMessage("Policy object name is invalid - " +
                "only letters and numbers are allowed" + '\n' + "Minimal Length 2 and maximal 32 characters");
        victim.validateObject(input);
    }

    private PolicyObject object(String name){
        PolicyObject policyObject = new PolicyObject();
        policyObject.setName(name);
        return policyObject;
    }

}