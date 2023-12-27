/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.sound.HsmSoundDPHandling;

class HsmSoundDPHandling$1
implements ASLNavigationServicesListener {
    private final /* synthetic */ HsmSoundDPHandling this$0;

    HsmSoundDPHandling$1(HsmSoundDPHandling hsmSoundDPHandling) {
        this.this$0 = hsmSoundDPHandling;
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Sound set Navigation items available: ").append(bl).log();
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(2040404736, bl);
    }

    @Override
    public void importContactResult(int n) {
    }

    @Override
    public void updateContactCapacity(int n) {
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
    }
}

