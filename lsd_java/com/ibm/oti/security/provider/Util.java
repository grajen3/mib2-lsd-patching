/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

public final class Util {
    public static boolean equals(byte[] byArray, byte[] byArray2) {
        if (byArray == null || byArray2 == null || byArray.length != byArray2.length) {
            return false;
        }
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }
}

