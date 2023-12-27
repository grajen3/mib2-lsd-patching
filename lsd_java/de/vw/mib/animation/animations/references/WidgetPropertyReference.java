/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

import de.vw.mib.animation.animations.references.ValueReference;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;

public final class WidgetPropertyReference
implements ValueReference {
    private int propertyId;
    private short referenceClass;

    public WidgetPropertyReference(int n, short s) {
        this.propertyId = n;
        this.referenceClass = s;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.propertyId);
        hashCodeBuilder.append(this.referenceClass);
        return hashCodeBuilder.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            WidgetPropertyReference widgetPropertyReference = (WidgetPropertyReference)object;
            return this.propertyId == widgetPropertyReference.propertyId && this.referenceClass == widgetPropertyReference.referenceClass;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[propertyId=").append(this.propertyId);
        stringBuilder.append(",referenceClass=").append(this.referenceClass);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int getPropertyID() {
        return this.propertyId;
    }

    @Override
    public void setPropertyID(int n) {
        this.propertyId = n;
    }

    @Override
    public short getReferenceClass() {
        return this.referenceClass;
    }

    @Override
    public void setReferenceClass(short s) {
        this.referenceClass = s;
    }
}

