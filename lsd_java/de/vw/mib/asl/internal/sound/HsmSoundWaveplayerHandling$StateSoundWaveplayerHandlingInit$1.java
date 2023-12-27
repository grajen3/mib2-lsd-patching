/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit;

class HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit this$1;

    HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit$1(HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit hsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit) {
        this.this$1 = hsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$1.initFromPersistence();
        this.notifyProfileChanged(true);
    }
}

