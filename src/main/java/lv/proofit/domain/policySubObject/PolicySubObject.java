package lv.proofit.domain.policySubObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@ToString
@Component

public class PolicySubObject {

    @Setter
    private String subObjectName;
    @Setter
    private BigDecimal sumInsured;
    private Set<RiskType> riskTypes = new HashSet();

    public RiskType addRiskType(RiskType riskType){
        riskTypes.add(riskType);
        return riskType;
    }

    public RiskType removeRiskType(RiskType riskType){
        riskTypes.remove(riskType);
        return riskType;
    }
}
