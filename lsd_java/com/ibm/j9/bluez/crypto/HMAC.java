/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.bluez.crypto.CL3Exception;
import com.ibm.j9.bluez.crypto.CL3State;

public class HMAC {
    private static final byte[] HASH_BS;
    protected static final byte[] HASH_DS;

    static {
        byte[] byArray = new byte[8];
        byArray[1] = 16;
        byArray[2] = 64;
        byArray[3] = 64;
        byArray[4] = 64;
        byArray[5] = -128;
        byArray[6] = -128;
        byArray[7] = 64;
        HASH_BS = byArray;
        byte[] byArray2 = new byte[8];
        byArray2[1] = 16;
        byArray2[2] = 16;
        byArray2[3] = 20;
        byArray2[4] = 32;
        byArray2[5] = 48;
        byArray2[6] = 64;
        byArray2[7] = 36;
        HASH_DS = byArray2;
    }

    public static CL3State hmacInit(CL3State cL3State, int n, byte[] byArray, int n2, int n3) {
        byte[] byArray2;
        Object[] objectArray;
        if (cL3State == null) {
            objectArray = new Object[3];
            cL3State = new CL3State(objectArray, n + 23);
        } else {
            objectArray = (Object[])cL3State.obj;
            if (n != (((byte[])objectArray[2])[0] & 0xFF)) {
                throw new CL3Exception(0x3000080);
            }
        }
        CL3 cL3 = null;
        CL3 cL32 = null;
        CL3 cL33 = null;
        int n4 = 0;
        while (n4 < 2) {
            cL33 = cL32;
            cL32 = (CL3)objectArray[n4];
            switch (n) {
                case 2: {
                    cL32 = CL3.md5Init(cL32);
                    break;
                }
                case 3: {
                    cL32 = CL3.shaInit(cL32);
                    break;
                }
                default: {
                    throw new CL3Exception(0x18000080);
                }
            }
            objectArray[n4] = cL32;
            ++n4;
        }
        int n5 = HASH_BS[n] & 0xFF;
        int n6 = 54;
        if (objectArray[2] == null) {
            byte[] byArray3 = new byte[n5 + 1];
            objectArray[2] = byArray3;
            byArray2 = byArray3;
        } else {
            byArray2 = (byte[])objectArray[2];
        }
        byte[] byArray4 = byArray2;
        byArray4[0] = (byte)n;
        if (n3 <= n5) {
            System.arraycopy((Object)byArray, n2, (Object)byArray4, 1, n3);
            n4 = 1;
        } else {
            n4 = 0;
        }
        do {
            if (n4 == 1) {
                while (++n3 <= n5) {
                    byArray4[n3] = 0;
                }
                byArray = byArray4;
                n2 = 1;
                n3 = n5;
                byArray4 = null;
                cL3 = cL33;
            }
            if (n4 != 0) {
                int n7 = n5;
                do {
                    int n8 = n7--;
                    byArray[n8] = (byte)(byArray[n8] ^ n6);
                } while (n7 > 0);
                n6 = 106;
            }
            switch (n) {
                case 2: {
                    CL3.md5(cL3, byArray, n2, n3, byArray4, 1);
                    break;
                }
                case 3: {
                    CL3.sha(cL3, byArray, n2, n3, byArray4, 1);
                }
            }
            if (n4 == 0) {
                n3 = HASH_DS[n];
            }
            cL3 = cL32;
        } while (++n4 <= 2);
        return cL3State;
    }

    public static int hmac(CL3State cL3State, byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        Object[] objectArray = (Object[])cL3State.obj;
        byte[] byArray3 = (byte[])objectArray[2];
        byte[] byArray4 = byArray2 == null ? null : byArray3;
        CL3 cL3 = (CL3)objectArray[0];
        CL3 cL32 = (CL3)objectArray[1];
        int n4 = byArray3[0] & 0xFF;
        switch (n4) {
            case 2: {
                CL3.md5(cL3, byArray, n, n2, byArray4, 1);
                if (byArray2 == null) break;
                CL3.md5(cL32, byArray4, 1, 16, byArray2, n3);
                return 16;
            }
            case 3: {
                CL3.sha(cL3, byArray, n, n2, byArray4, 1);
                if (byArray2 == null) break;
                CL3.sha(cL32, byArray4, 1, 20, byArray2, n3);
                return 20;
            }
            default: {
                throw new CL3Exception(0x18000080);
            }
        }
        return HASH_BS[n4] & 0xFF;
    }
}

