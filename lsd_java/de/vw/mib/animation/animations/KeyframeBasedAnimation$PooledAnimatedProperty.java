/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.references.ValueReference;
import de.vw.mib.animation.animations.references.ValueReferenceMetric;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

final class KeyframeBasedAnimation$PooledAnimatedProperty
implements PooledObject {
    private long relativeStartTime;
    private ValueReference valueReference;
    private ValueReferenceMetric valueReferenceMetric;
    private float startValue;
    private float endValue;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[relativeStartTime=").append(this.relativeStartTime);
        stringBuilder.append(",valueReference=").append(this.valueReference);
        stringBuilder.append(",valueReferenceMetric=").append(this.valueReferenceMetric);
        stringBuilder.append(",startValue=").append(this.startValue);
        stringBuilder.append(",endValue=").append(this.endValue);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.valueReference = null;
        this.valueReferenceMetric = null;
    }

    public long getRelativeStartTime() {
        return this.relativeStartTime;
    }

    public void setRelativeStartTime(long l) {
        this.relativeStartTime = l;
    }

    public ValueReference getValueReference() {
        return this.valueReference;
    }

    public void setValueReference(ValueReference valueReference) {
        this.valueReference = valueReference;
    }

    public ValueReferenceMetric getValueReferenceMetric() {
        return this.valueReferenceMetric;
    }

    public void setValueReferenceMetric(ValueReferenceMetric valueReferenceMetric) {
        this.valueReferenceMetric = valueReferenceMetric;
    }

    public float getStartValue() {
        return this.startValue;
    }

    public void setStartValue(float f2) {
        this.startValue = f2;
    }

    public float getEndValue() {
        return this.endValue;
    }

    public void setEndValue(float f2) {
        this.endValue = f2;
    }
}

