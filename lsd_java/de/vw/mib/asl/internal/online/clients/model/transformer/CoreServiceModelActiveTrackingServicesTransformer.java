/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.transformer;

import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;

public class CoreServiceModelActiveTrackingServicesTransformer {
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    public String getString(int n, Object object) {
        return "";
    }

    public int getInt(int n, Object object) {
        OnlineTrackingService onlineTrackingService = (OnlineTrackingService)object;
        switch (n) {
            case 0: {
                return CoreServiceModelMap.getServiceIDInteger(onlineTrackingService.getServiceID());
            }
        }
        throw new IllegalArgumentException();
    }
}

