/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.transformer;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineApplication;
import de.vw.mib.util.Util;

public class CoreServiceModelApplicationTransformer {
    public boolean getBoolean(int n, Object object) {
        OnlineApplication onlineApplication = (OnlineApplication)object;
        switch (n) {
            case 3: {
                return !Util.isNullOrEmpty(onlineApplication.getServices());
            }
            case 4: {
                return onlineApplication.isDeactivationPossible();
            }
        }
        throw new IllegalArgumentException();
    }

    public String getString(int n, Object object) {
        return "";
    }

    public int getInt(int n, Object object) {
        OnlineApplication onlineApplication = (OnlineApplication)object;
        switch (n) {
            case 1: {
                if (onlineApplication.isApplicationDeactive()) {
                    return 2;
                }
                int n2 = 0;
                switch (onlineApplication.getApplicationState()) {
                    case 0: {
                        n2 = 1;
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
                        n2 = 0;
                        break;
                    }
                    case 4: {
                        n2 = 3;
                        break;
                    }
                }
                return n2;
            }
            case 0: {
                return 0;
            }
            case 2: {
                return 1;
            }
        }
        throw new IllegalArgumentException();
    }
}

