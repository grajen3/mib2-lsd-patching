/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input;

public interface InputManagerListener {
    public static final int INTERACTION_TYPE_TOUCH;
    public static final int INTERACTION_TYPE_PROXIMITY;
    public static final int LOCATION_NONE;
    public static final int LOCATION_LEFT;
    public static final int LOCATION_RIGHT;

    default public void userInteractionStarted(int n, int n2) {
    }

    default public void userInteractionStopped(int n, int n2) {
    }
}

