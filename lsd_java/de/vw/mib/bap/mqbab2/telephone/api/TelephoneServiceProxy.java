/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.api;

import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.telephone.api.TelephoneServices;
import de.vw.mib.genericevents.EventGeneric;

public interface TelephoneServiceProxy
extends FSGServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, TelephoneServices telephoneServices) {
    }
}

