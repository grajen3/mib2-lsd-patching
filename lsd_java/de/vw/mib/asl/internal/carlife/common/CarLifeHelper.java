/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;

public final class CarLifeHelper {
    public static int getOwner(AppState[] appStateArray, int n) {
        int n2 = 0;
        if (null != appStateArray) {
            for (int i2 = 0; i2 < appStateArray.length; ++i2) {
                if (appStateArray[i2].appStateID != n) continue;
                n2 = appStateArray[i2].owner;
                return n2;
            }
        }
        return n2;
    }

    public static int getOwner(Resource[] resourceArray, int n) {
        int n2 = 0;
        if (null != resourceArray) {
            for (int i2 = 0; i2 < resourceArray.length; ++i2) {
                if (resourceArray[i2].resourceID != n) continue;
                n2 = resourceArray[i2].owner;
                return n2;
            }
        }
        return n2;
    }

    public static boolean isSwitchResOwnerToDevice(int n, int n2) {
        return n != 2 && n2 == 2;
    }

    public static boolean isSwitchResOwnerFromDevice(int n, int n2) {
        return n == 2 && n2 != 2;
    }

    public static boolean isSwitchAppOwnerToDevice(int n, int n2) {
        return n != 2 && n2 == 2;
    }

    public static boolean isSwitchAppOwnerFromDevice(int n, int n2) {
        return n == 2 && n2 != 2;
    }

    public static boolean isSwitchAppOwnerToMainUnit(int n, int n2) {
        return n != 1 && n2 == 1;
    }
}

