/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config.util;

public final class ArrayHelper {
    private ArrayHelper() {
    }

    public static boolean contains(int[] nArray, int n) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != n) continue;
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] nArray, int n) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != n) continue;
                return i2;
            }
        }
        return -1;
    }
}

