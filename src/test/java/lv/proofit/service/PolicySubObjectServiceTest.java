package lv.proofit.service;

import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.domain.policySubObject.RiskType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PolicySubObjectServiceTest {


    @InjectMocks
    private PolicySubObjectService victim;

    @Test
    public void shouldAddRiskType(){
        PolicySubObject subObject = new PolicySubObject();
        victim.addRiskTypeToSubObject(subObject, RiskType.FIRE);
        assert(subObject.getRiskTypes().contains(RiskType.FIRE));
    }
}