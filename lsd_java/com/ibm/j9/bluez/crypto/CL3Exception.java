/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

public class CL3Exception
extends RuntimeException {
    public static final int BER;
    public static final int VERSION;
    public static final int OID;
    public static final int PARAM;
    public static final int RANGE;
    public static final int INVALID;
    public static final int NOTIMPL;
    public static final int ILLUSE;
    public static final int OBJECT;
    public static final int NOALG;
    public static final int SELFFAIL;
    public int reason;
    private static String[] reasonCodes;

    static {
        reasonCodes = new String[64];
        CL3Exception.reasonCodes[21] = "Illegal ASN.1/BER encoding";
        CL3Exception.reasonCodes[1] = "Unknown data version";
        CL3Exception.reasonCodes[2] = "Unknown OID";
        CL3Exception.reasonCodes[3] = "Illegal parameter";
        CL3Exception.reasonCodes[8] = "Value out of range";
        CL3Exception.reasonCodes[5] = "Invalid data/parameter";
        CL3Exception.reasonCodes[22] = "Not implemented";
        CL3Exception.reasonCodes[23] = "Illegal use";
        CL3Exception.reasonCodes[12] = "Illegal object";
        CL3Exception.reasonCodes[24] = "Algorithm not supported";
        CL3Exception.reasonCodes[25] = "Internal self test failed";
    }

    public CL3Exception() {
    }

    public CL3Exception(int n) {
        this.reason = n;
    }

    @Override
    public String getMessage() {
        int n = this.reason ^ 0x80;
        return new StringBuffer("reason=0x").append(Long.toString((long)this.reason & 0, 16)).append(" (").append(n < 0 || n > reasonCodes.length ? "?" : reasonCodes[n]).append(")").toString();
    }
}

