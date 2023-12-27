/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity.util;

public final class ConnectivityUtil {
    public static int convertDSICryptoModel2ASLEncryptionType(int n) {
        switch (n) {
            case 1: {
                return 2;
            }
            case 4: 
            case 5: 
            case 8: {
                return 3;
            }
            case 6: 
            case 7: 
            case 9: {
                return 0;
            }
            case 2: 
            case 3: {
                return 4;
            }
            case 10: {
                return 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unhandled DSI WLAN encryption type: ").append(n).toString());
    }
}

