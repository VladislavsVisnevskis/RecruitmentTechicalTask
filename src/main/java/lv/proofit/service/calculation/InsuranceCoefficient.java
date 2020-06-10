package lv.proofit.service.calculation;

import java.math.BigDecimal;

public interface InsuranceCoefficient {

    public static final BigDecimal COEFFICIENT_FIRE = BigDecimal.valueOf(0.014);
    public static final BigDecimal COEFFICIENT_FIRE_INCREASED = BigDecimal.valueOf(0.024);
    public static final BigDecimal COEFFICIENT_THEFT = BigDecimal.valueOf(0.11);
    public static final BigDecimal COEFFICIENT_THEFT_DECREASED = BigDecimal.valueOf(0.05);

}
