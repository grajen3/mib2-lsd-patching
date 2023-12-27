/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api;

import de.vw.mib.asl.internal.ocu.common.api.OcuServiceProxy;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallInternalServices;
import de.vw.mib.genericevents.EventGeneric;

public interface ECallServiceProxy
extends OcuServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, ECallInternalServices eCallInternalServices) {
    }

    default public boolean deMarshallServiceListener(EventGeneric eventGeneric, ServiceListenerNotifier serviceListenerNotifier) {
    }
}

