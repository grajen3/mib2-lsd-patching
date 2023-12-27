/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class EasingParams
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public static final short EASING_KIND_IN;
    public static final short EASING_KIND_OUT;
    public static final short EASING_KIND_INOUT;
    public static final short EASING_KIND_OUTIN;
    public static final short EASING_KIND_MAX;
    public static final short EASING_CLASS_NONE;
    public static final short EASING_CLASS_LINEAR;
    public static final short EASING_CLASS_BOUNCE;
    public static final short EASING_CLASS_EXPONENTIAL;
    public static final short EASING_CLASS_QUARTIC;
    public static final short EASING_CLASS_QUINTIC;
    public static final short EASING_CLASS_BACK;
    public static final short EASING_CLASS_CIRCULAR;
    public static final short EASING_CLASS_CUBIC;
    public static final short EASING_CLASS_ELASTIC;
    public static final short EASING_CLASS_QUADRATIC;
    public static final short EASING_CLASS_SINE;
    public static final short EASING_CLASS_MAX;
    private short easingKind;
    private short easingClass;
    private int duration;
    private int startDelay;
    private transient int hashCode;
    private transient boolean hashCodeValid;

    public EasingParams() {
        this(0, 1, 0, 0);
    }

    public EasingParams(short s, short s2, int n, int n2) {
        this.easingKind = s;
        this.easingClass = s2;
        this.duration = n;
        this.startDelay = n2;
        this.hashCodeValid = false;
    }

    public EasingParams(short s, short s2, int n) {
        this(s, s2, n, 0);
    }

    public EasingParams(EasingParams easingParams) {
        this(easingParams.easingKind, easingParams.easingClass, easingParams.duration, easingParams.startDelay);
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        if (!this.hashCodeValid) {
            this.hashCode = new HashCodeBuilder().append(this.easingKind).append(this.easingClass).append(this.duration).append(this.startDelay).hashCode();
            this.hashCodeValid = true;
        }
        return this.hashCode;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            EasingParams easingParams = (EasingParams)object;
            return this.easingKind == easingParams.easingKind && this.easingClass == easingParams.easingClass && this.duration == easingParams.duration && this.startDelay == easingParams.startDelay;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[easingKind=").append(this.easingKind);
        stringBuilder.append(",easingClass=").append(this.easingClass);
        stringBuilder.append(",duration=").append(this.duration);
        stringBuilder.append(",startDelay=").append(this.startDelay);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int n) {
        this.duration = n;
        this.hashCodeValid = false;
    }

    public int getStartDelay() {
        return this.startDelay;
    }

    public void setStartDelay(int n) {
        this.startDelay = n;
        this.hashCodeValid = false;
    }

    public short getEasingKind() {
        return this.easingKind;
    }

    public void setEasingKind(short s) {
        this.easingKind = s;
        this.hashCodeValid = false;
    }

    public short getEasingClass() {
        return this.easingClass;
    }

    public void setEasingClass(short s) {
        this.easingClass = s;
        this.hashCodeValid = false;
    }
}

