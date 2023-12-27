/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.base.DSIListener;

public interface DSISoundListener
extends DSIListener {
    default public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
    }

    default public void menuVolEntRange(int n, int n2, int n3) {
    }

    default public void menuVolumeRange(int n, int n2, int n3, int n4) {
    }

    default public void volumeRange(int n, int n2, int n3, int n4, int n5) {
    }

    default public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
    }

    default public void updateBalance(int n, int n2, short s, int n3) {
    }

    default public void updateBalanceRange(int n, int n2, int n3) {
    }

    default public void updateBass(int n, int n2, short s, int n3) {
    }

    default public void updateBassRange(int n, int n2, int n3) {
    }

    default public void createExportFileResult(int n, boolean bl) {
    }

    default public void updateFader(int n, int n2, short s, int n3) {
    }

    default public void updateFaderRange(int n, int n2, int n3) {
    }

    default public void importFileResponse(int n, boolean bl) {
    }

    default public void updateInputGainOffset(int n, int n2, short s, int n3) {
    }

    default public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
    }

    default public void updateMutePinState(boolean bl, int n) {
    }

    default public void updateSubwoofer(int n, int n2, short s, int n3) {
    }

    default public void updateSubwooferRange(int n, int n2, int n3) {
    }

    default public void updateSurrLevelRange(int n, int n2, int n3) {
    }

    default public void updateSurroundLevel(int n, int n2, short s, int n3) {
    }

    default public void updateTreble(int n, int n2, short s, int n3) {
    }

    default public void updateTrebleRange(int n, int n2, int n3) {
    }

    default public void updateVolume(int n, int n2, short s, int n3) {
    }

    default public void updateVolumeRange(int n, int n2, int n3) {
    }

    default public void updateMiddle(int n, int n2, short s, int n3) {
    }

    default public void updateMiddleRange(int n, int n2, int n3) {
    }

    default public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
    }

    default public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
    }

    default public void updateOnVolumeLimit(int n, int n2) {
    }

    default public void updateOnVolumeLimitRange(int n, int n2, int n3) {
    }

    default public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
    }

    default public void updateMuteTheftProtection(boolean bl, int n) {
    }

    default public void updateMicGainLevel(int n, int n2) {
    }

    default public void updateVolumeFocus(int n, int n2, int n3) {
    }

    default public void updateNoiseCompensation(int n, int n2, short s, int n3) {
    }

    default public void updateNoiseCompensationRange(int n, int n2, int n3) {
    }

    default public void updateThreeDMode(int n, int n2, int n3, int n4) {
    }

    default public void updateThreeDModeRange(int n, int n2, int n3) {
    }

    default public void updatePresetPosition(int n, int n2, int n3, int n4) {
    }

    default public void updatePresetPositionList(int n, int n2) {
    }

    default public void updatePresetEQList(int n, int n2) {
    }

    default public void updatePresetEQ(int n, int n2, int n3, int n4) {
    }

    default public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
    }

    default public void responseWidebandSpeech(int n, boolean bl) {
    }

    default public void updateSoundShapeActive(boolean bl, int n) {
    }

    default public void updateSoundShape(short s, short s2, short s3, int n) {
    }

    default public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    default public void updateICCAvailable(boolean bl, int n, int n2) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }
}

