/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.keyframe;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.scene.animation.keyframe.Keyframe;
import de.vw.mib.graphics.scene.animation.keyframe.KeyframeAnimation;
import de.vw.mib.util.StringBuilder;

public final class UnpooledKeyframe
implements Keyframe {
    private float time;
    private int interpolationType;
    private Vector2f inTangent;
    private Vector2f outTangent;
    private float[] animationValue;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[time=").append(this.time);
        stringBuilder.append(",interpolationType=").append(this.interpolationType);
        stringBuilder.append(",inTangent=").append(this.inTangent);
        stringBuilder.append(",outTangent=").append(this.outTangent);
        stringBuilder.append(",animationValue=").append(this.animationValue);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public KeyframeAnimation getParent() {
        throw new NotYetImplementedException();
    }

    @Override
    public float getTime() {
        return this.time;
    }

    @Override
    public void setTime(float f2) {
        this.time = f2;
    }

    @Override
    public int getInterpolationType() {
        return this.interpolationType;
    }

    @Override
    public void setInterpolationType(int n) {
        this.interpolationType = n;
    }

    @Override
    public Vector2f getInTangent() {
        return this.inTangent;
    }

    @Override
    public void setInTangent(Vector2f vector2f) {
        this.inTangent = vector2f;
    }

    @Override
    public Vector2f getOutTangent() {
        return this.outTangent;
    }

    @Override
    public void setOutTangent(Vector2f vector2f) {
        this.outTangent = vector2f;
    }

    @Override
    public float[] getAnimationValue() {
        return this.animationValue;
    }

    @Override
    public void setAnimationValue(float[] fArray) {
        this.animationValue = fArray;
    }
}

