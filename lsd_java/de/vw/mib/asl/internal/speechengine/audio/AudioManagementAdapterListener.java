/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

public interface AudioManagementAdapterListener {
    public static final int AUDIOMNGMNT_STATE_UNAVAILABLE;
    public static final int AUDIOMNGMNT_STATE_AVAILABLE;
    public static final int AUDIOMNGMNT_STATE_AVAILABLE_RESTORE_CONNECTIONS;
    public static final String AUDIO_INTERNAL_HOLD_AUDIO_CONNECTION_TIMEOUT;
    public static final int AUDIO_CONNECTION_TIMEOUT;
    public static final int NO_MODE;

    default public void resultRequestConnection(int n, int n2) {
    }

    default public void resultReleaseConnection(int n, int n2) {
    }

    default public void updateLossOfConnection(int n) {
    }

    default public void updateAudioManagementState(int n) {
    }

    default public void updateAudioPendingRequest(boolean bl, int n) {
    }

    default public void releaseSDSConnection() {
    }
}

