/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.api;

import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.telephone.api.TelephoneServiceProxy;
import de.vw.mib.bap.mqbab2.telephone.api.TelephoneServices;
import de.vw.mib.genericevents.EventGeneric;

public class TelephoneServiceProxyMarshaller
implements TelephoneServiceProxy {
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
    public boolean deMarshallEvent(EventGeneric eventGeneric, TelephoneServices telephoneServices) {
        TelephoneServices telephoneServices2 = telephoneServices;
        return this.deMarshallEvent(eventGeneric, (FSGService)telephoneServices2);
    }
}

