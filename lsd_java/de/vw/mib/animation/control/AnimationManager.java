/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.control;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationManagerListener;

public interface AnimationManager {
    default public void start() {
    }

    default public void stop() {
    }

    default public void startAnimation(Animation animation) {
    }

    default public void startAnimation(Animation animation, int n) {
    }

    default public void stopAnimation(Animation animation) {
    }

    default public void addAnimationManagerListener(AnimationManagerListener animationManagerListener) {
    }

    default public void removeAnimationManagerListener(AnimationManagerListener animationManagerListener) {
    }

    default public int getAnimationInterval() {
    }

    default public int getMinimalAnimationFrequency() {
    }

    default public int getMaximalAnimationFrequency() {
    }

    default public int getAnimationFrequency() {
    }

    default public void setAnimationFrequency(int n) {
    }

    default public float getMinimalAnimationDilatation() {
    }

    default public float getMaximalAnimationDilatation() {
    }

    default public float getAnimationDilatation() {
    }

    default public void setAnimationDilatation(float f2) {
    }

    default public int getRunningAnimationCount() {
    }
}

