/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.audio;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.audio.ASIAudioListener;
import de.vw.mib.asi.audio.ASIAudioResponse;

public interface ASIAudio
extends ASIService {
    default public ASIAudioListener getASIAudioListener() {
    }

    default public void setASIAudioListener(ASIAudioListener aSIAudioListener) {
    }

    default public void setAudioContext(int n, ASIAudioResponse aSIAudioResponse) {
    }

    default public void forceFrontAudioContext(int n, ASIAudioResponse aSIAudioResponse) {
    }

    default public void requestEnableA2LS(String string, ASIAudioResponse aSIAudioResponse) {
    }

    default public void disableA2LS(ASIAudioResponse aSIAudioResponse) {
    }

    default public void setVolume(int n, ASIAudioResponse aSIAudioResponse) {
    }

    default public void increaseVolume(int n, ASIAudioResponse aSIAudioResponse) {
    }

    default public void decreaseVolume(int n, ASIAudioResponse aSIAudioResponse) {
    }
}

