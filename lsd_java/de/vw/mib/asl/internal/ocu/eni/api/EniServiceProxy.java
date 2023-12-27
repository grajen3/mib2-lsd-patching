/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.common.api.OcuServiceProxy;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.eni.api.EniInternalServices;
import de.vw.mib.genericevents.EventGeneric;

public interface EniServiceProxy
extends OcuServiceProxy {
    default public boolean deMarshallEvent(EventGeneric eventGeneric, EniInternalServices eniInternalServices) {
    }

    default public boolean deMarshallServiceListener(EventGeneric eventGeneric, ServiceListenerNotifier serviceListenerNotifier) {
    }
}

