package lv.proofit.domain.policyObject;

import lv.proofit.domain.policySubObject.PolicySubObject;

import java.util.List;
import java.util.Objects;

public class PolicyObject {

    private String name;
    private List<PolicySubObject> subObjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PolicySubObject> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<PolicySubObject> subObjects) {
        this.subObjects = subObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolicyObject)) return false;
        PolicyObject that = (PolicyObject) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSubObjects(), that.getSubObjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubObjects());
    }

    @Override
    public String toString() {
        return "PolicyObject{" +
                "name='" + name + '\'' +
                ", subObjects=" + subObjects +
                '}';
    }
}

