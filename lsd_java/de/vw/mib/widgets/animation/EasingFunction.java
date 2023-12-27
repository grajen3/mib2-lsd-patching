/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.animation;

import de.vw.mib.animation.easing.EasingFacade;
import de.vw.mib.graphics.math.function.Function1f;

public final class EasingFunction
implements Function1f {
    public static final short F_KIND_IN;
    public static final short F_KIND_OUT;
    public static final short F_KIND_INOUT;
    public static final short F_KIND_OUTIN;
    public static final short F_CLASS_NONE;
    public static final short F_CLASS_LINEAR;
    public static final short F_CLASS_BOUNCE;
    public static final short F_CLASS_EXPONENTIAL;
    public static final short F_CLASS_QUARTIC;
    public static final short F_CLASS_QUINTIC;
    public static final short F_CLASS_BACK;
    public static final short F_CLASS_CIRCULAR;
    public static final short F_CLASS_CUBIC;
    public static final short F_CLASS_ELASTIC;
    public static final short F_CLASS_QUADRATIC;
    public static final short F_CLASS_SINE;
    private final int easingClass;
    private final int easingKind;
    private final float startValue;
    private final float deltaValue;

    public EasingFunction(short s, short s2, float f2, float f3) {
        this.easingClass = s;
        this.easingKind = s2;
        this.startValue = f2;
        this.deltaValue = f3 - f2;
    }

    @Override
    public float evaluate(float f2) {
        return EasingFacade.calculate(f2, this.startValue, this.deltaValue, this.easingClass, this.easingKind, 1);
    }
}

