/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

import de.vw.mib.animation.animations.references.AbstractValueReferenceMetric;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;

public final class IntegerValueReferenceMetric
extends AbstractValueReferenceMetric {
    private int sourceValue;
    private int targetValue;

    public IntegerValueReferenceMetric(int n, int n2, EasingParams easingParams, boolean bl) {
        super((short)0, easingParams, bl);
        this.sourceValue = n;
        this.targetValue = n2;
    }

    @Override
    public Object clone() {
        IntegerValueReferenceMetric integerValueReferenceMetric = (IntegerValueReferenceMetric)super.clone();
        return integerValueReferenceMetric;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(super.hashCode());
        hashCodeBuilder.append(this.sourceValue);
        hashCodeBuilder.append(this.targetValue);
        return hashCodeBuilder.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            IntegerValueReferenceMetric integerValueReferenceMetric = (IntegerValueReferenceMetric)object;
            return super.equals(integerValueReferenceMetric) && this.sourceValue == integerValueReferenceMetric.sourceValue && this.targetValue == integerValueReferenceMetric.targetValue;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",sourceValue=").append(this.sourceValue);
        stringBuilder.append(",targetValue=").append(this.targetValue);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getSourceValue() {
        return this.sourceValue;
    }

    public void setSourceValue(int n) {
        this.sourceValue = n;
    }

    public int getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(int n) {
        this.targetValue = n;
    }
}

