/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.api;

import de.vw.mib.bap.mqbpq.common.api.FSGService;
import de.vw.mib.bap.mqbpq.navsd.api.NavSDServiceProxy;
import de.vw.mib.bap.mqbpq.navsd.api.NavSDServices;
import de.vw.mib.genericevents.EventGeneric;

public class NavSDServiceProxyMarshaller
implements NavSDServiceProxy {
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
    public boolean deMarshallEvent(EventGeneric eventGeneric, NavSDServices navSDServices) {
        NavSDServices navSDServices2 = navSDServices;
        return this.deMarshallEvent(eventGeneric, (FSGService)navSDServices2);
    }
}

