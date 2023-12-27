/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.transformer;

import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;

public class CoreServiceModelServiceTransformer {
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    public String getString(int n, Object object) {
        return "";
    }

    public int getInt(int n, Object object) {
        OnlineService onlineService = (OnlineService)object;
        switch (n) {
            case 0: {
                return CoreServiceModelMap.getServiceIDInteger(onlineService.getServiceID());
            }
            case 1: {
                if (!onlineService.isEnabledState()) {
                    return 2;
                }
                int n2 = 0;
                switch (onlineService.getServiceState()) {
                    case 0: {
                        n2 = 1;
                        break;
                    }
                    case 1: {
                        n2 = 4;
                        break;
                    }
                    case 6: {
                        n2 = 2;
                        break;
                    }
                    case 2: {
                        n2 = 0;
                        break;
                    }
                    case 3: {
                        n2 = 5;
                        break;
                    }
                    case 4: {
                        n2 = 3;
                        break;
                    }
                    case 7: {
                        n2 = 8;
                        break;
                    }
                    case 5: {
                        n2 = 7;
                        break;
                    }
                    case 8: {
                        n2 = 6;
                        break;
                    }
                }
                return n2;
            }
        }
        throw new IllegalArgumentException();
    }
}

