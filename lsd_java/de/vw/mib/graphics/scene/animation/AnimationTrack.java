/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation;

import de.vw.mib.graphics.scene.animation.Animatable;
import de.vw.mib.graphics.scene.animation.Animation;
import de.vw.mib.graphics.scene.animation.AnimationClip;
import de.vw.mib.graphics.scene.animation.keyframe.KeyframeAnimation;
import java.util.List;

public interface AnimationTrack
extends Animatable {
    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public AnimationClip getParent() {
    }

    default public float getStartTime() {
    }

    default public float getEndTime() {
    }

    default public KeyframeAnimation createKeyframeAnimation() {
    }

    default public int getAnimationCount() {
    }

    default public Animation getAnimation(int n) {
    }

    default public void setAnimation(int n, Animation animation) {
    }

    default public void addAnimation(Animation animation) {
    }

    default public void removeAnimation(int n) {
    }

    default public List getAnimations() {
    }

    default public int getAnimationTrackCount() {
    }

    default public AnimationTrack getAnimationTrack(int n) {
    }

    default public void setAnimationTrack(int n, AnimationTrack animationTrack) {
    }

    default public void addAnimationTrack(AnimationTrack animationTrack) {
    }

    default public void removeAnimationTrack(int n) {
    }

    default public List getAnimationTracks() {
    }
}

