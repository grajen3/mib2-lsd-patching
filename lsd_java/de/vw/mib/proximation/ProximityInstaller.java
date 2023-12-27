/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.proximation;

public interface ProximityInstaller {
    public static final int PAUSE_REASON_APP;
    public static final int PAUSE_REASON_SPEECH_ACTIVE;
    public static final int PAUSE_REASON_OVERLAY;
    public static final int INTERACTION_TYPE_OTHER;
    public static final int INTERACTION_TYPE_VIEW_CHANGE;

    default public void pauseProximity(int n, boolean bl) {
    }

    default public void resumeProximity(int n) {
    }

    default public void resetProximityPause(int n) {
    }

    default public void processUserInteraction() {
    }

    default public void processUserInteraction(int n) {
    }
}

