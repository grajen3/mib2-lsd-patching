/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.api;

import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.navsd.api.NavSDServices;
import de.vw.mib.genericevents.EventGeneric;

public interface NavSDServiceProxy
extends FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, NavSDServices navSDServices) {
    }
}

