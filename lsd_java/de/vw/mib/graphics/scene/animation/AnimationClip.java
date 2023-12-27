/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation;

import de.vw.mib.graphics.scene.animation.Animatable;
import de.vw.mib.graphics.scene.animation.AnimationTrack;
import java.util.List;

public interface AnimationClip
extends Animatable {
    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public float getStartTime() {
    }

    default public float getEndTime() {
    }

    default public float getDuration() {
    }

    default public AnimationTrack createAnimationTrack() {
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

