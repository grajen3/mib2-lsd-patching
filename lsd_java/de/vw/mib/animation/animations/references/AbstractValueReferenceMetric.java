/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

import de.vw.mib.animation.animations.references.ValueReferenceMetric;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractValueReferenceMetric
implements ValueReferenceMetric {
    private final short referenceClass;
    private boolean relativeValue;
    private EasingParams easing;

    public AbstractValueReferenceMetric(short s, EasingParams easingParams, boolean bl) {
        this.referenceClass = s;
        this.easing = easingParams;
        this.relativeValue = bl;
    }

    @Override
    public Object clone() {
        try {
            AbstractValueReferenceMetric abstractValueReferenceMetric = (AbstractValueReferenceMetric)super.clone();
            abstractValueReferenceMetric.easing = (EasingParams)this.easing.clone();
            return abstractValueReferenceMetric;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.referenceClass);
        hashCodeBuilder.append(this.relativeValue);
        hashCodeBuilder.append(this.easing);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            AbstractValueReferenceMetric abstractValueReferenceMetric = (AbstractValueReferenceMetric)object;
            return this.referenceClass == abstractValueReferenceMetric.referenceClass && this.relativeValue == abstractValueReferenceMetric.relativeValue && this.easing.equals(abstractValueReferenceMetric.easing);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[referenceClass=").append(this.referenceClass);
        stringBuilder.append(",relativeValue=").append(this.relativeValue);
        stringBuilder.append(",easing=").append(this.easing);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final short getReferenceClass() {
        return this.referenceClass;
    }

    @Override
    public final EasingParams getEasing() {
        return this.easing;
    }

    @Override
    public final void setEasing(EasingParams easingParams) {
        this.easing = easingParams;
    }

    @Override
    public final boolean isRelativeValue() {
        return this.relativeValue;
    }

    @Override
    public final void setRelativeValue(boolean bl) {
        this.relativeValue = bl;
    }
}

