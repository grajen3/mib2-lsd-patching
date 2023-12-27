/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing;

import de.vw.mib.animation.easing.Easing;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.animation.easing.algorithms.Back;
import de.vw.mib.animation.easing.algorithms.Bounce;
import de.vw.mib.animation.easing.algorithms.Circular;
import de.vw.mib.animation.easing.algorithms.Cubic;
import de.vw.mib.animation.easing.algorithms.Elastic;
import de.vw.mib.animation.easing.algorithms.Exponential;
import de.vw.mib.animation.easing.algorithms.Linear;
import de.vw.mib.animation.easing.algorithms.None;
import de.vw.mib.animation.easing.algorithms.Quadratic;
import de.vw.mib.animation.easing.algorithms.Quartic;
import de.vw.mib.animation.easing.algorithms.Quintic;
import de.vw.mib.animation.easing.algorithms.Sine;

public final class EasingFacade {
    private static final Easing[] EASING_ALGORITHMS = new Easing[]{new None(), new Linear(), new Bounce(), new Exponential(), new Quartic(), new Quintic(), new Back(), new Circular(), new Cubic(), new Elastic(), new Quadratic(), new Sine()};

    private EasingFacade() {
    }

    public static float calculate(float f2, float f3, float f4, EasingParams easingParams) {
        return EasingFacade.calculate(f2, f3, f4, easingParams.getEasingClass(), easingParams.getEasingKind(), easingParams.getDuration());
    }

    public static float calculate(float f2, float f3, float f4, int n, int n2, int n3) {
        if (n <= 11) {
            Easing easing = EASING_ALGORITHMS[n];
            switch (n2) {
                case 0: {
                    return easing.easeIn(f2, f3, f4, n3);
                }
                case 1: {
                    return easing.easeOut(f2, f3, f4, n3);
                }
                case 2: {
                    return easing.easeInOut(f2, f3, f4, n3);
                }
                case 3: {
                    return easing.easeOutIn(f2, f3, f4, n3);
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("Unsupported easingKind: ").append(n2).toString());
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unsupported easingClass: ").append(n).toString());
    }
}

