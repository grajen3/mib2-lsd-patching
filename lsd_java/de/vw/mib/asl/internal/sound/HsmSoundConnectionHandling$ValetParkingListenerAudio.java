/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling$1;
import de.vw.mib.genericevents.EventGeneric;

class HsmSoundConnectionHandling$ValetParkingListenerAudio
extends ValetParkingListenerAdapter {
    private final /* synthetic */ HsmSoundConnectionHandling this$0;

    private HsmSoundConnectionHandling$ValetParkingListenerAudio(HsmSoundConnectionHandling hsmSoundConnectionHandling) {
        this.this$0 = hsmSoundConnectionHandling;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.target.trace().append("[HsmSoundConnectionHandling] received valetparking mode on: ").append(bl).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.this$0.target.getTargetId(), this.this$0.target.getTargetId(), -1551499008);
        super.getClass();
        eventGeneric.setBoolean(0, bl);
        this.this$0.sendSafe(eventGeneric);
        if (valetParkingCallback != null) {
            valetParkingCallback.notifyValetParkingTransitionFinished(true);
        }
    }

    /* synthetic */ HsmSoundConnectionHandling$ValetParkingListenerAudio(HsmSoundConnectionHandling hsmSoundConnectionHandling, HsmSoundConnectionHandling$1 hsmSoundConnectionHandling$1) {
        this(hsmSoundConnectionHandling);
    }
}

