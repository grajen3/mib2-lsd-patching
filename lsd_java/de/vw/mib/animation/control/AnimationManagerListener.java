/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.control;

public interface AnimationManagerListener {
    public static final int REPAINT_REQUEST;
    public static final int ANIMATION_MODE_OFF;
    public static final int ANIMATION_MODE_ON;

    default public void animationManagerChanged(int n) {
    }
}

