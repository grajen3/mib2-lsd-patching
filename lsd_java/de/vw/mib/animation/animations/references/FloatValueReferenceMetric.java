/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

import de.vw.mib.animation.animations.references.AbstractValueReferenceMetric;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.util.StringBuilder;

public final class FloatValueReferenceMetric
extends AbstractValueReferenceMetric {
    private float sourceValue;
    private float targetValue;

    public FloatValueReferenceMetric(float f2, float f3, EasingParams easingParams, boolean bl) {
        super((short)1, easingParams, bl);
        this.sourceValue = f2;
        this.targetValue = f3;
    }

    @Override
    public Object clone() {
        FloatValueReferenceMetric floatValueReferenceMetric = (FloatValueReferenceMetric)super.clone();
        return floatValueReferenceMetric;
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
            FloatValueReferenceMetric floatValueReferenceMetric = (FloatValueReferenceMetric)object;
            if (Util.IDENTITY_EQUALS) {
                return super.equals(floatValueReferenceMetric) && this.sourceValue == floatValueReferenceMetric.sourceValue && this.targetValue == floatValueReferenceMetric.targetValue;
            }
            if (Util.EXACT_EQUALS) {
                return super.equals(floatValueReferenceMetric) && Float.compare(this.sourceValue, floatValueReferenceMetric.sourceValue) == 0 && Float.compare(this.targetValue, floatValueReferenceMetric.targetValue) == 0;
            }
            return super.equals(floatValueReferenceMetric) && Util.equalsEpsilon(this.sourceValue, floatValueReferenceMetric.sourceValue) && Util.equalsEpsilon(this.targetValue, floatValueReferenceMetric.targetValue);
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

    public float getSourceValue() {
        return this.sourceValue;
    }

    public void setSourceValue(float f2) {
        this.sourceValue = f2;
    }

    public float getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(float f2) {
        this.targetValue = f2;
    }
}

