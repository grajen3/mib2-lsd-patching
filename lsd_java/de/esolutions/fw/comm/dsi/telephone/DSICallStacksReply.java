/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.MissedCallIndicator;

public interface DSICallStacksReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateIsReverted(boolean bl, int n) {
    }

    default public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateMEDataValidity(int n, int n2) {
    }

    default public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

