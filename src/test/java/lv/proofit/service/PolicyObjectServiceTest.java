package lv.proofit.service;

import lv.proofit.domain.policyObject.PolicyObject;
import lv.proofit.domain.policySubObject.PolicySubObject;
import lv.proofit.service.validation.subobject.SubObjectValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PolicyObjectServiceTest {

    @Mock
    private SubObjectValidationService subObjectValidationService;

    @InjectMocks
    private PolicyObjectService victim;

    @Test
    public void shouldAssignSubObject(){
        PolicySubObject subObject = new PolicySubObject();
        PolicyObject object = new PolicyObject();
        victim.assignSubObject(object, subObject);
        verify(subObjectValidationService).validate(any());
        assertTrue(object.getSubObjects().contains(subObject));
    }



}