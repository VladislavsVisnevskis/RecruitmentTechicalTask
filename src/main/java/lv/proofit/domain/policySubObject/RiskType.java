package lv.proofit.domain.policySubObject;

public enum RiskType {
    FIRE ("Fire"),
    THEFT ("Theft");
    
    /* Other risk type can be add here, e.g.:
    VANDALISM("Vandalism"),
    WEATHER_DAMAGE("Weather damage");
    */

    private String riskType;

    RiskType(String riskType){
        this.riskType = riskType;
    }

    @Override
    public String toString() {
        return riskType;
    }
}
