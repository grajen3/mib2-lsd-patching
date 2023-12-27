/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api;

import de.vw.mib.bap.mqbpq.audiosd.api.AudioSDServiceProxy;
import de.vw.mib.bap.mqbpq.audiosd.api.AudioSDServices;
import de.vw.mib.bap.mqbpq.common.api.FSGService;
import de.vw.mib.genericevents.EventGeneric;

public class AudioSDServiceProxyMarshaller
implements AudioSDServiceProxy {
    @Override
    public boolean deMarshallEvent(EventGeneric eventGeneric, FSGService fSGService) {
        boolean bl = true;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                fSGService.stateEntry();
                break;
            }
            case 3: {
                fSGService.stateStart();
                break;
            }
            case 4: {
                fSGService.stateExit();
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public boolean deMarshallEvent(EventGeneric eventGeneric, AudioSDServices audioSDServices) {
        AudioSDServices audioSDServices2 = audioSDServices;
        return this.deMarshallEvent(eventGeneric, (FSGService)audioSDServices2);
    }
}

