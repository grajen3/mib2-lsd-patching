/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.has;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASList;
import generated.de.vw.mib.has.contexts.media.MediaProperties;

public class HasBrowserListState {
    private static HASList mHasList;

    public static void update(int n, int n2) {
        int n3 = 2;
        block0 : switch (n) {
            case -1: {
                n3 = 2;
                break;
            }
            case 0: {
                n3 = 1;
                break;
            }
            case 1: {
                n3 = 2;
                break;
            }
            case 2: {
                switch (n2) {
                    case -1: {
                        n3 = 2;
                        break block0;
                    }
                    case 0: {
                        n3 = 1;
                        break block0;
                    }
                    case 2: {
                        n3 = 0;
                        break block0;
                    }
                    case 1: {
                        n3 = 0;
                        break block0;
                    }
                }
                break;
            }
        }
        mHasList.setState(n3);
        if (ServiceManager.logger.isTraceEnabled(32)) {
            ServiceManager.logger.trace(32).append("HasBrowserListState.update() ").append(n3).log();
        }
    }

    static {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        mHasList = ((MediaProperties)hASContext.getPropertiesImpl()).getMediaBrowserList();
    }
}

