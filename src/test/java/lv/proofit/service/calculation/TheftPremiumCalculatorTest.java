package lv.proofit.service.calculation;

import lv.proofit.domain.policy.Policy;
import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.domain.policySubObject.RiskType;
import lv.proofit.service.PolicyObjectService;
import lv.proofit.service.PolicyService;
import lv.proofit.service.PolicySubObjectService;
import lv.proofit.service.validation.object.ObjectValidationService;
import lv.proofit.service.validation.subobject.SubObjectValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TheftPremiumCalculatorTest {
    @Mock
    private SubObjectValidationService subObjectValidationService;

    @Mock
    private ObjectValidationService objectValidationService;

    @InjectMocks
    private TheftPremiumCalculator victim;

    @Test
    public void shouldCalculateTotalPremium() {
        PolicySubObjectService policySubObjectService = new PolicySubObjectService();
        PolicyObjectService policyObjectService = new PolicyObjectService(subObjectValidationService);
        PolicyService policyService = new PolicyService(objectValidationService);

        PolicySubObject subObjectOne = new PolicySubObject();
        subObjectOne.setSubObjectName("TV");
        subObjectOne.setSumInsured(BigDecimal.valueOf(100));

        policySubObjectService.addRiskTypeToSubObject(subObjectOne, RiskType.FIRE);
        PolicySubObject subObjectTwo = new PolicySubObject();
        subObjectTwo.setSubObjectName("Laptop");
        subObjectTwo.setSumInsured(BigDecimal.valueOf(8));
        policySubObjectService.addRiskTypeToSubObject(subObjectTwo, RiskType.THEFT);

        PolicyObject object = new PolicyObject();
        object.setName("House");
        policyObjectService.assignSubObject(object, subObjectOne);
        policyObjectService.assignSubObject(object, subObjectTwo);

        Policy policy = new Policy();
        policyService.assignObjectToPolicy(policy, object);

        assertTrue(victim.calculatePremium(policy).compareTo(BigDecimal.valueOf(0.88)) == 0);
        verify(subObjectValidationService, atLeast(2)).validate(any());
        verify(objectValidationService).validate(any());
    }
}