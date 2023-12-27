/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation.keyframe;

import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.scene.animation.keyframe.KeyframeAnimation;

public interface Keyframe {
    public static final int INTERPOLATION_TYPE_STEP;
    public static final int INTERPOLATION_TYPE_LINEAR;
    public static final int INTERPOLATION_TYPE_BEZIER;
    public static final int INTERPOLATION_TYPE_HERMITE;
    public static final int INTERPOLATION_TYPE_CARDINAL;
    public static final int INTERPOLATION_TYPE_BSPLINE;

    default public KeyframeAnimation getParent() {
    }

    default public float getTime() {
    }

    default public void setTime(float f2) {
    }

    default public int getInterpolationType() {
    }

    default public void setInterpolationType(int n) {
    }

    default public Vector2f getInTangent() {
    }

    default public void setInTangent(Vector2f vector2f) {
    }

    default public Vector2f getOutTangent() {
    }

    default public void setOutTangent(Vector2f vector2f) {
    }

    default public float[] getAnimationValue() {
    }

    default public void setAnimationValue(float[] fArray) {
    }
}

