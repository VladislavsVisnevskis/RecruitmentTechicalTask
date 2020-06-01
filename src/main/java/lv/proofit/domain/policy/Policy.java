package lv.proofit.domain.policy;

import lv.proofit.domain.policyObject.PolicyObject;

import java.util.List;
import java.util.Objects;

public class Policy {

    private String policyNumber;
    private PolicyStatus status;
    private List<PolicyObject> policyObjects;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(getPolicyNumber(), policy.getPolicyNumber()) &&
                getStatus() == policy.getStatus() &&
                Objects.equals(getPolicyObjects(), policy.getPolicyObjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPolicyNumber(), getStatus(), getPolicyObjects());
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", status=" + status +
                ", policyObjects=" + policyObjects +
                '}';
    }
}
