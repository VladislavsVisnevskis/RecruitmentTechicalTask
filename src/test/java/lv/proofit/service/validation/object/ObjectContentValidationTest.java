package lv.proofit.service.validation.object;

import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.service.PolicyObjectService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ObjectContentValidationTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    ObjectContentValidation victim = new ObjectContentValidation();
    PolicyObject input;


    @Test
    public void shouldThrowSubObjectContentValidationRule(){
        input = object (null);
        exception.expect(ObjectValidationException.class);
        exception.expectMessage("No sub-objects are assigned to object test");
        victim.validateObject(input);
    }

    private PolicyObject object(PolicySubObject policySubObject){
        PolicyObject policyObject = new PolicyObject();
        policyObject.setName("test");
        return policyObject;
    }
}