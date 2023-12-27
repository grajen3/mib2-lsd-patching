/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.Keyframe;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.Serializable;

public class KeyframeAnimationParams
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private int duration;
    private Keyframe[] keyframes;
    private boolean looping;

    public KeyframeAnimationParams(Keyframe[] keyframeArray, int n, boolean bl) {
        this.keyframes = keyframeArray;
        this.duration = n;
        this.looping = bl;
    }

    public final Object clone() {
        try {
            KeyframeAnimationParams keyframeAnimationParams = (KeyframeAnimationParams)super.clone();
            keyframeAnimationParams.keyframes = new Keyframe[this.keyframes.length];
            for (int i2 = 0; i2 < this.keyframes.length; ++i2) {
                keyframeAnimationParams.keyframes[i2] = (Keyframe)this.keyframes[i2].clone();
            }
            return keyframeAnimationParams;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public final int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.duration);
        hashCodeBuilder.append(this.keyframes);
        hashCodeBuilder.append(this.looping);
        return hashCodeBuilder.hashCode();
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            KeyframeAnimationParams keyframeAnimationParams = (KeyframeAnimationParams)object;
            return this.duration == keyframeAnimationParams.duration && Arrays.equals(this.keyframes, keyframeAnimationParams.keyframes) && this.looping == keyframeAnimationParams.looping;
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[duration=").append(this.duration);
        stringBuilder.append(",keyframes=").append(this.keyframes);
        stringBuilder.append(",looping=").append(this.looping);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final Keyframe[] getKeyframes() {
        return this.keyframes;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean isLooping() {
        return this.looping;
    }

    public final boolean isEmpty() {
        return this.keyframes.length == 0;
    }
}

