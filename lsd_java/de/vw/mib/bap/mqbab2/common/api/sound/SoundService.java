/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.sound;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;

public interface SoundService {
    default public void addSoundServiceListener(SoundServiceListener soundServiceListener, int[] nArray) {
    }

    default public void removeSoundServiceListener(SoundServiceListener soundServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public int getVolumeNavi() {
    }

    default public int getVolumeNaviMin() {
    }

    default public int getVolumeNaviMax() {
    }

    default public int getVolumeNaviMinPopup() {
    }

    default public int getVolumeNaviMaxPopup() {
    }

    default public int getCurrentDdsVolumeFocus() {
    }

    default public int getVolumeEntertainment() {
    }

    default public int getVolumeEntertainmentMax() {
    }

    default public int getVolumeTA() {
    }

    default public int getVolumeTAMin() {
    }

    default public int getVolumeTAMax() {
    }

    default public int getVolumePhone() {
    }

    default public int getVolumePhoneMin() {
    }

    default public int getVolumePhoneMax() {
    }

    default public int getVolumeSDS() {
    }

    default public int getVolumeSDSMin() {
    }

    default public int getVolumeSDSMax() {
    }

    default public int getCurrentAudioComponent() {
    }

    default public int getMuteActive() {
    }

    default public int getCurrentAmplifierState() {
    }

    default public void setSoundVolume(int n, int n2) {
    }

    default public void setMuteState() {
    }

    default public void setCurrentAudioComponent(int n) {
    }

    default public void activateRadioSource() {
    }

    default public void activateMediaSource() {
    }

    default public void activateTvSource() {
    }
}

