/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.sound;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.vw.mib.asi.ASIListener;

public interface ASISoundListener
extends ASIListener {
    default public void updateAmplifier(int n, boolean bl) {
    }

    default public void updateBalanceRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateBalanceValue(int n, boolean bl) {
    }

    default public void updateBassRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateBassValue(int n, boolean bl) {
    }

    default public void updateFaderRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateFaderValue(int n, boolean bl) {
    }

    default public void updateNoiseCompensationRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateNoiseCompensationValue(int n, boolean bl) {
    }

    default public void updatePresetPosition(int n, boolean bl) {
    }

    default public void updatePresetPositionList(int n, boolean bl) {
    }

    default public void updateSoundState(int n, boolean bl) {
    }

    default public void updateSubwooferRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateSubwooferValue(int n, boolean bl) {
    }

    default public void updateSurroundRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateSurroundValue(int n, boolean bl) {
    }

    default public void updateTrebleRange(SoundRange soundRange, boolean bl) {
    }

    default public void updateTrebleValue(int n, boolean bl) {
    }
}

