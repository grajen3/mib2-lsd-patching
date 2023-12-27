/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.api;

import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.sdssd.api.SDSSDServiceProxy;
import de.vw.mib.bap.mqbab2.sdssd.api.SDSSDServices;
import de.vw.mib.genericevents.EventGeneric;

public class SDSSDServiceProxyMarshaller
implements SDSSDServiceProxy {
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
    public boolean deMarshallEvent(EventGeneric eventGeneric, SDSSDServices sDSSDServices) {
        SDSSDServices sDSSDServices2 = sDSSDServices;
        return this.deMarshallEvent(eventGeneric, (FSGService)sDSSDServices2);
    }
}

