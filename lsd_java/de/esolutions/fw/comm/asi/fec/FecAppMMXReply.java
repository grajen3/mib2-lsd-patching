/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.SFecState;

public interface FecAppMMXReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void reportError(int n) {
    }

    default public void updateFECs(SFecState[] sFecStateArray) {
    }

    default public void checkPkgSignature(String string, boolean bl) {
    }
}

