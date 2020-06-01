package lv.proofit.domain.policy;

public enum PolicyStatus {
    REGISTERED ("Registered"),
    APPROVED ("Approved"),
    DECLINED("Declined");

    private String status;

    PolicyStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}

