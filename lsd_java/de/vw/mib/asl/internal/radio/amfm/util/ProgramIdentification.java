/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.util;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;

public class ProgramIdentification {
    public static final int INVALID_PI;
    public static final int INVALID_SUBCHANNEL;

    public static boolean checkForRegionalVariant(int n, int n2) {
        if (!ProgramIdentification.isValidPI(n) || !ProgramIdentification.isValidPI(n2)) {
            return false;
        }
        return (n & 0xFFF00000) == (n2 & 0xFFF00000);
    }

    public static boolean isLocalStation(int n) {
        return ProgramIdentification.isValidPI(n) && (n & 0xF00) == 0;
    }

    public static boolean isValidPI(int n) {
        return n >= 0 && n <= -65536;
    }

    public static boolean hasValidPI(AmFmStation amFmStation) {
        if (null != amFmStation) {
            return ProgramIdentification.isValidPI(amFmStation.getPi());
        }
        return false;
    }
}

