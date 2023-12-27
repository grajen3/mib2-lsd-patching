/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.api;

import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.telephone2.api.Telephone2Services;
import de.vw.mib.genericevents.EventGeneric;

public interface Telephone2ServiceProxy
extends FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, Telephone2Services telephone2Services) {
    }
}

