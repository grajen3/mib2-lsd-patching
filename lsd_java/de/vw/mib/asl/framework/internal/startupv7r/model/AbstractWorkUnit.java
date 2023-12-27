/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

public abstract class AbstractWorkUnit {
    public static final int INVALID_FEATURE_FLAG;
    private String name;
    private AbstractWorkUnit[] preconditions;
    private boolean dynamic;
    private int featureFlag = -1;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public AbstractWorkUnit[] getPreconditions() {
        return this.preconditions;
    }

    public void setPreconditions(AbstractWorkUnit[] abstractWorkUnitArray) {
        if (this.checkPreconditionArrayContainsNull(abstractWorkUnitArray)) {
            throw new IllegalArgumentException("Element within precondition array must not contain null.");
        }
        this.preconditions = abstractWorkUnitArray;
    }

    public int getFeatureFlag() {
        return this.featureFlag;
    }

    public void setFeatureFlag(int n) {
        this.featureFlag = n;
    }

    public boolean hasValidFeatureFlag() {
        return this.featureFlag != -1;
    }

    public boolean isDynamic() {
        return this.dynamic;
    }

    public void setDynamic(boolean bl) {
        this.dynamic = bl;
    }

    private boolean checkPreconditionArrayContainsNull(AbstractWorkUnit[] abstractWorkUnitArray) {
        if (abstractWorkUnitArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < abstractWorkUnitArray.length; ++i2) {
            if (abstractWorkUnitArray[i2] != null) continue;
            return true;
        }
        return false;
    }
}

