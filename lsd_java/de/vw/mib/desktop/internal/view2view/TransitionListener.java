/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.view2view;

public interface TransitionListener {
    default public void setPaintingEnabled(boolean bl) {
    }

    default public void activateEarly() {
    }

    default public void updateViewstack() {
    }

    default public void finishViewChange() {
    }
}

