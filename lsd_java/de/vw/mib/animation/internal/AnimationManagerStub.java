/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.internal;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationManager;
import de.vw.mib.animation.control.AnimationManagerListener;

public class AnimationManagerStub
implements AnimationManager {
    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    public void addAnimation(Animation animation) {
    }

    @Override
    public void startAnimation(Animation animation) {
    }

    @Override
    public void startAnimation(Animation animation, int n) {
    }

    public void removeAnimation(Animation animation) {
    }

    @Override
    public void stopAnimation(Animation animation) {
    }

    public void runAnimationSynchronously(Animation animation) {
    }

    @Override
    public void addAnimationManagerListener(AnimationManagerListener animationManagerListener) {
    }

    @Override
    public void removeAnimationManagerListener(AnimationManagerListener animationManagerListener) {
    }

    @Override
    public int getAnimationInterval() {
        return 0;
    }

    @Override
    public int getMinimalAnimationFrequency() {
        return 0;
    }

    @Override
    public int getMaximalAnimationFrequency() {
        return 0;
    }

    @Override
    public int getAnimationFrequency() {
        return 0;
    }

    @Override
    public void setAnimationFrequency(int n) {
    }

    @Override
    public float getMinimalAnimationDilatation() {
        return 0.0f;
    }

    @Override
    public float getMaximalAnimationDilatation() {
        return 0.0f;
    }

    @Override
    public float getAnimationDilatation() {
        return 0.0f;
    }

    @Override
    public void setAnimationDilatation(float f2) {
    }

    @Override
    public int getRunningAnimationCount() {
        return 0;
    }
}

