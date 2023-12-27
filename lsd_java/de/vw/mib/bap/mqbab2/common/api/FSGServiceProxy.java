/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api;

import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.genericevents.EventGeneric;

public interface FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, FSGService fSGService) {
    }
}

