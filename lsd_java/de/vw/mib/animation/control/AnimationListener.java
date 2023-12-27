/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.control;

import de.vw.mib.animation.animations.Animation;
import java.util.EventListener;

public interface AnimationListener
extends EventListener {
    default public void animationStarted(Animation animation) {
    }

    default public void animationStopped(Animation animation) {
    }

    default public void animationRunning(Animation animation) {
    }

    default public void animationProgress(Animation animation, int n) {
    }
}

