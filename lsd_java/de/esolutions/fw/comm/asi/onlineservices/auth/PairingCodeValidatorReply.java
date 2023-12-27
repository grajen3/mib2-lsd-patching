/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth;

public interface PairingCodeValidatorReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void validatePairingCodeResult(boolean bl, String string, String string2, int n, int n2) {
    }

    default public void resetPairingCode(String string, String string2) {
    }
}

