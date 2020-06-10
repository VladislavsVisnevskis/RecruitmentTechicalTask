package lv.proofit.service.validation.subobject;

import lv.proofit.domain.policySubObject.PolicySubObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SubObjectPriceValidationRuleTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    SubObjectPriceValidationRule victim = new SubObjectPriceValidationRule();
    PolicySubObject input;

    @Test
    public void shouldThrowSubObjectPriceValidationRule(){
        input = subObject(BigDecimal.valueOf(-5.2));
        exception.expect(SubObjectValidationException.class);
        exception.expectMessage("Insurance sum must be higher than 0");
        victim.validateSubObject(input);
    }

    private PolicySubObject subObject(BigDecimal price){
        PolicySubObject policySubObject = new PolicySubObject();
        policySubObject.setSumInsured(price);
        return policySubObject;
    }
}