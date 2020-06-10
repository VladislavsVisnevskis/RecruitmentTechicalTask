package lv.proofit.service.calculation;

import lv.proofit.domain.policy.Policy;

import java.math.BigDecimal;

public interface PremiumCalculable {

    BigDecimal calculatePremium (Policy policy);
}
