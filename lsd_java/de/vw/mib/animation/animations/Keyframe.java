/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.references.ValueReference;
import de.vw.mib.animation.animations.references.ValueReferenceMetric;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Keyframe
implements Cloneable {
    private int startTime;
    private Map properties;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$animation$animations$Keyframe;

    public Keyframe(int n) {
        this.startTime = n;
        this.properties = new ObjectObjectOptHashMap();
    }

    public Keyframe(int n, ValueReference[] valueReferenceArray, ValueReferenceMetric[] valueReferenceMetricArray) {
        this(n);
        if (!$assertionsDisabled && valueReferenceArray.length != valueReferenceMetricArray.length) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < valueReferenceArray.length && i2 < valueReferenceMetricArray.length; ++i2) {
            this.properties.put(valueReferenceArray[i2], valueReferenceMetricArray[i2]);
        }
    }

    public Object clone() {
        try {
            Keyframe keyframe = (Keyframe)super.clone();
            keyframe.properties = new ObjectObjectOptHashMap(this.properties.size());
            Iterator iterator = this.properties.keySet().iterator();
            while (iterator.hasNext()) {
                ValueReference valueReference = (ValueReference)iterator.next();
                ValueReferenceMetric valueReferenceMetric = (ValueReferenceMetric)this.properties.get(valueReference);
                keyframe.properties.put(valueReference.clone(), valueReferenceMetric.clone());
            }
            return keyframe;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.startTime);
        hashCodeBuilder.append(this.properties);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Keyframe keyframe = (Keyframe)object;
            return this.startTime == keyframe.startTime && ((Object)this.properties).equals(keyframe.properties);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[startTime=").append(this.startTime);
        stringBuilder.append(",properties=").append(this.properties);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int n) {
        this.startTime = n;
    }

    public Set getValueReferences() {
        return this.properties.keySet();
    }

    public ValueReferenceMetric getMetric(ValueReference valueReference) {
        return (ValueReferenceMetric)this.properties.get(valueReference);
    }

    public int getPropertyCount() {
        return this.properties.size();
    }

    public void setProperty(ValueReference valueReference, ValueReferenceMetric valueReferenceMetric) {
        this.properties.put(valueReference, valueReferenceMetric);
    }

    public void removeProperty(ValueReference valueReference) {
        this.properties.remove(valueReference);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$animation$animations$Keyframe == null ? (class$de$vw$mib$animation$animations$Keyframe = Keyframe.class$("de.vw.mib.animation.animations.Keyframe")) : class$de$vw$mib$animation$animations$Keyframe).desiredAssertionStatus();
    }
}

