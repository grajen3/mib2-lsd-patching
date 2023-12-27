/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.audio;

import de.vw.mib.asi.audio.ASIAudio;
import de.vw.mib.asi.audio.ASIAudioListener;
import de.vw.mib.asi.audio.ASIAudioResponse;

public class ASIAudioAdapter
implements ASIAudio {
    protected ASIAudioListener listener;

    @Override
    public ASIAudioListener getASIAudioListener() {
        return this.listener;
    }

    @Override
    public void setASIAudioListener(ASIAudioListener aSIAudioListener) {
        this.listener = aSIAudioListener;
    }

    @Override
    public void setAudioContext(int n, ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void forceFrontAudioContext(int n, ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void requestEnableA2LS(String string, ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void disableA2LS(ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setVolume(int n, ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void increaseVolume(int n, ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void decreaseVolume(int n, ASIAudioResponse aSIAudioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

