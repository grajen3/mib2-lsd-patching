/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api;

import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.genericevents.EventGeneric;

public interface OcuServiceProxy {
    default public void setMarshallingEnabled(boolean bl) {
    }

    default public boolean deMarshallEvent(EventGeneric eventGeneric, OCUService oCUService) {
    }

    default public void registerServiceListener(Class clazz, int[] nArray) {
    }

    default public void unregisterServiceListener(Class clazz, int[] nArray) {
    }

    default public Object getService(Class clazz) {
    }
}

