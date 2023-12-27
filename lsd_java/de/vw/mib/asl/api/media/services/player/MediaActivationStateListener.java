/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.player;

public interface MediaActivationStateListener {
    public static final int ACTIVATION_STATE_DEACTIVATING;
    public static final int ACTIVATION_STATE_DEACTIVATED;
    public static final int ACTIVATION_STATE_ACTIVATING;
    public static final int ACTIVATION_STATE_ACTIVATED;

    default public void updateActivationState(int n) {
    }
}

