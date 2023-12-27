/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

import de.vw.mib.animation.animations.references.AbstractValueReferenceMetric;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;

public final class BooleanValueReferenceMetric
extends AbstractValueReferenceMetric {
    private boolean sourceValue;
    private boolean targetValue;

    public BooleanValueReferenceMetric(boolean bl, boolean bl2, EasingParams easingParams, boolean bl3) {
        super((short)0, easingParams, bl3);
        this.sourceValue = bl;
        this.targetValue = bl2;
    }

    @Override
    public Object clone() {
        BooleanValueReferenceMetric booleanValueReferenceMetric = (BooleanValueReferenceMetric)super.clone();
        return booleanValueReferenceMetric;
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
            BooleanValueReferenceMetric booleanValueReferenceMetric = (BooleanValueReferenceMetric)object;
            return super.equals(booleanValueReferenceMetric) && this.sourceValue == booleanValueReferenceMetric.sourceValue && this.targetValue == booleanValueReferenceMetric.targetValue;
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

    public boolean getSourceValue() {
        return this.sourceValue;
    }

    public void setSourceValue(boolean bl) {
        this.sourceValue = bl;
    }

    public boolean getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(boolean bl) {
        this.targetValue = bl;
    }
}

