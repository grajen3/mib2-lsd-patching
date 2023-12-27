/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.api;

import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.sdssd.api.SDSSDServices;
import de.vw.mib.genericevents.EventGeneric;

public interface SDSSDServiceProxy
extends FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, SDSSDServices sDSSDServices) {
    }
}

