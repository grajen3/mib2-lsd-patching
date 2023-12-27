/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;

public class HeadUnitBrowsingTypeSwitching {
    private static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;
    private static int mBrowserType = 0;

    public static void update(MediaBrowserState mediaBrowserState) {
        int n;
        boolean bl = false;
        int n2 = 1;
        if (mediaBrowserState != null) {
            n = mediaBrowserState.getInitState();
            bl = n == 2;
            n2 = mediaBrowserState.getModeSwitchingState();
        }
        n = 0;
        int n3 = 3;
        if (bl) {
            switch (n2) {
                case 1: {
                    n = 0;
                    n3 = 3;
                    break;
                }
                case 4: {
                    n = 1;
                    n3 = 0;
                    break;
                }
                case 2: {
                    if (mBrowserType == 0) {
                        n = 1;
                        n3 = 1;
                        break;
                    }
                    n = 1;
                    n3 = 0;
                    break;
                }
                case 3: {
                    n = 1;
                    n3 = 0;
                    break;
                }
            }
        }
        DATA_POOL.valueChangedBoolean(93, n != 0);
        DATA_POOL.valueChangedInteger(83, n3);
    }

    public static void forwardUsedBrowserType(int n) {
        switch (n) {
            case 0: {
                mBrowserType = 0;
                break;
            }
            case 1: {
                mBrowserType = 1;
                break;
            }
            default: {
                mBrowserType = 0;
            }
        }
        DATA_POOL.valueChangedInteger(70, mBrowserType);
    }
}

