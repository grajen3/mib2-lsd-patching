/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.api;

import de.vw.mib.bap.mqbpq.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbpq.navsd.api.NavSDServices;
import de.vw.mib.genericevents.EventGeneric;

public interface NavSDServiceProxy
extends FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, NavSDServices navSDServices) {
    }
}

