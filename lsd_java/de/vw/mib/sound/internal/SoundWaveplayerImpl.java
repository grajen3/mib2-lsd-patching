/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sound.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.sound.SoundWaveplayer;
import de.vw.mib.sound.asl.ASLSoundWaveplayer;
import de.vw.mib.sound.internal.ServiceManager;

final class SoundWaveplayerImpl
implements SoundWaveplayer {
    private boolean enabled = false;
    private final Logger logger = ServiceManager.loggerFactory.getLogger(16384);
    private final ASLSoundWaveplayer aslSoundWaveplayer;

    SoundWaveplayerImpl(ASLSoundWaveplayer aSLSoundWaveplayer) {
        this.aslSoundWaveplayer = aSLSoundWaveplayer;
    }

    @Override
    public void playButtonPressedTone() {
        if (!this.enabled) {
            return;
        }
        this.logger.trace(1, "play button pressed tone");
        this.aslSoundWaveplayer.playButtonPressedTone();
    }

    @Override
    public void playButtonReleasedTone() {
        if (!this.enabled) {
            return;
        }
        this.logger.trace(1, "play button released tone");
        this.aslSoundWaveplayer.playButtonReleasedTone();
    }

    @Override
    public void setPlayerEnabled(boolean bl) {
        this.enabled = bl;
    }
}

