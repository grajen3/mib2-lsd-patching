/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class TouchInterpolation {
    public static int[] getCoordinates(int n, int n2) {
        int n3 = ServiceManager.configManagerDiag.getDisplayDefault(0);
        int n4 = ServiceManager.configManagerDiag.getDisplayDefault(1);
        int n5 = (int)(0.041667 * (double)n4);
        int n6 = (int)(0.0520834 * (double)n4);
        int n7 = (int)(0.04375 * (double)n3);
        int n8 = (int)(0.04375 * (double)n3);
        double d2 = 0.02083;
        int n9 = 5;
        int n10 = 2;
        int n11 = n5 * 2;
        int n12 = n4 - n6 * 2;
        int n13 = (n7 + (int)((double)n2 * 0.02083)) * 2;
        int n14 = n3 - (n8 + (int)((double)n2 * 0.02083)) * 2;
        if (n < n13) {
            n = 2 * n - n13;
        } else if (n > n14) {
            n = 2 * n - n14;
        }
        if (n < 5) {
            n = 5;
        } else if (n > n3 - 5) {
            n = n3 - 5 - 1;
        }
        if (n2 < n11) {
            n2 = 2 * n2 - n11;
        } else if (n2 > n12) {
            n2 = 2 * n2 - n12;
        }
        if (n2 < 5) {
            n2 = 5;
        } else if (n2 > n4 - 5) {
            n2 = n4 - 5 - 1;
        }
        int[] nArray = new int[]{n, n2};
        return nArray;
    }
}

