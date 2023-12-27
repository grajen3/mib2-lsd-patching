/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal;

public interface InputManagerNotifier {
    public static final int INTERACTION_TYPE_TOUCH;
    public static final int INTERACTION_TYPE_PROXIMITY;
    public static final int LOCATION_NONE;
    public static final int LOCATION_LEFT;
    public static final int LOCATION_RIGHT;

    default public void notifyUserInteractionStarted(int n, int n2) {
    }

    default public void notifyUserInteractionStopped(int n, int n2) {
    }
}

