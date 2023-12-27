/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.control.AnimationListener;

public interface Animation
extends Cloneable {
    default public boolean isLooped() {
    }

    default public void setLooped(boolean bl) {
    }

    default public int getDuration() {
    }

    default public int getAnimationInterval() {
    }

    default public void setAnimationInterval(int n) {
    }

    default public long getStartTime() {
    }

    default public long getNextRunTime() {
    }

    default public boolean isStarted() {
    }

    default public boolean isStopped() {
    }

    default public boolean isRunning() {
    }

    default public boolean isActive() {
    }

    default public void start(long l) {
    }

    default public void stop() {
    }

    default public void run(long l) {
    }

    default public void addAnimationListener(AnimationListener animationListener) {
    }

    default public void removeAnimationListener(AnimationListener animationListener) {
    }
}

