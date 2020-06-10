package lv.proofit.service;

import lv.proofit.domain.policy.Policy;
import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.service.validation.object.ObjectValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceTest {

    @Mock
    private ObjectValidationService objectValidationService;;

    @InjectMocks
    private PolicyService victim;

    @Test
    public void shouldAssignObject() {
        Policy policy = new Policy();
        PolicyObject object = new PolicyObject();
        victim.assignObjectToPolicy(policy, object);
        verify(objectValidationService).validate(any());
        assertTrue(policy.getPolicyObjectList().contains(object));
    }

}