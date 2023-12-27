/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api.asl;

public interface AudioManagementServiceListener {
    public static final int REQUEST_CONNECTION_ACKNOWLEDGE;
    public static final int[] AUDIO_MANAGEMENT_SERVICE_CONSTANTS;
    public static final int AUDIO_MANAGEMENT_STATUS_UNAVAILABLE;
    public static final int AUDIO_MANAGEMENT_STATUS_AVAILABLE;
    public static final int AUDIO_MANAGEMENT_STATUS_AVAILABLE_RESTORE_CONNECTIONS;

    default public void audioConnectionReleased(int n) {
    }

    default public void audioConnectionStarted(int n) {
    }

    default public void audioManagementStatus(int n) {
    }

    default public void audioUserMuteIsActive(boolean bl, boolean bl2) {
    }

    default public void requestConnectionAcknowledge(int n) {
    }

    static {
        AUDIO_MANAGEMENT_SERVICE_CONSTANTS = new int[]{252263680, 403258624, 352926976, 118045952, -1400504064};
    }
}

