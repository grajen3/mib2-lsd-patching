/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation.keyframe;

import de.vw.mib.graphics.scene.animation.Animation;
import de.vw.mib.graphics.scene.animation.keyframe.Keyframe;

public interface KeyframeAnimation
extends Animation {
    default public Keyframe createKeyframe() {
    }

    default public int getKeyframeCount() {
    }

    default public Keyframe getKeyframe(int n) {
    }

    default public Keyframe getKeyframeAt(float f2) {
    }

    default public void setKeyframe(int n, Keyframe keyframe) {
    }

    default public void addKeyframe(Keyframe keyframe) {
    }

    default public void removeKeyframe(int n) {
    }
}

