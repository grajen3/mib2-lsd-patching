/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.api;

import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.telephone2.api.Telephone2ServiceProxy;
import de.vw.mib.bap.mqbab2.telephone2.api.Telephone2Services;
import de.vw.mib.genericevents.EventGeneric;

public class Telephone2ServiceProxyMarshaller
implements Telephone2ServiceProxy {
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
    public boolean deMarshallEvent(EventGeneric eventGeneric, Telephone2Services telephone2Services) {
        Telephone2Services telephone2Services2 = telephone2Services;
        return this.deMarshallEvent(eventGeneric, (FSGService)telephone2Services2);
    }
}

