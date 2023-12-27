/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.kombi;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class KombiBrowserState {
    private static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;
    private static int mBrowserState = -1;

    public static void update(int n, int n2) {
        int n3 = -1;
        block0 : switch (n) {
            case -1: {
                n3 = -1;
                break;
            }
            case 0: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 1;
                break;
            }
            case 2: {
                switch (n2) {
                    case -1: {
                        n3 = -1;
                        break block0;
                    }
                    case 0: {
                        n3 = 2;
                        break block0;
                    }
                    case 2: {
                        n3 = 4;
                        break block0;
                    }
                    case 1: {
                        n3 = 3;
                        break block0;
                    }
                }
                break;
            }
        }
        if (mBrowserState != n3) {
            mBrowserState = n3;
            ServiceManager.logger.trace(1024, new StringBuffer().append("kombiBrowserState: ").append(KombiBrowserState.getBrowserStateStr(n3)).toString());
            DATA_POOL.valueChangedInteger(542903296, n3);
        }
    }

    private static String getBrowserStateStr(int n) {
        switch (n) {
            case -1: {
                return "UNKNOWN";
            }
            case 0: {
                return "INIT_SOURCE";
            }
            case 1: {
                return "BROWSING_NOT_AVAILABLE";
            }
            case 2: {
                return "LIST_LOADING";
            }
            case 3: {
                return "LIST_EMPTY";
            }
            case 4: {
                return "LIST_READY";
            }
        }
        return "unknown constant";
    }
}

