/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;

public interface ASIHMISyncSoundReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateSoundState(int n, boolean bl) {
    }

    default public void updateAmplifier(int n, boolean bl) {
    }

    default public void updateBassRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateBassValue(int n, boolean bl) {
    }

    default public void updateTrebleRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateTrebleValue(int n, boolean bl) {
    }

    default public void updateBalanceRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateBalanceValue(int n, boolean bl) {
    }

    default public void updateFaderRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateFaderValue(int n, boolean bl) {
    }

    default public void updateSubwooferRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateSubwooferValue(int n, boolean bl) {
    }

    default public void updateSurroundRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateSurroundValue(int n, boolean bl) {
    }

    default public void updateNoiseCompensationRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateNoiseCompensationValue(int n, boolean bl) {
    }

    default public void updateThreeDModeRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateThreeDModeValue(int n, boolean bl) {
    }

    default public void updatePresetPositionList(int n, boolean bl) {
    }

    default public void updatePresetPosition(int n, boolean bl) {
    }

    default public void updatePresetEQList(int n, boolean bl) {
    }

    default public void updatePresetEQ(int n, boolean bl) {
    }
}

