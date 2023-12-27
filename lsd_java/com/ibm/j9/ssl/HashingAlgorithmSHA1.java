/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.bluez.crypto.CL3State;
import com.ibm.j9.bluez.crypto.HMAC;
import com.ibm.j9.ssl.HashingAlgorithm;
import com.ibm.j9.ssl.Util;
import com.ibm.oti.crypto.SHAOutputStream;
import java.io.IOException;

public class HashingAlgorithmSHA1
extends HashingAlgorithm {
    public static final byte[] PAD_1 = Util.repeat((byte)54, 40);
    public static final byte[] PAD_2 = Util.repeat((byte)92, 40);
    private static final SHAOutputStream hash = new SHAOutputStream();

    public static synchronized byte[] hashSHA1(byte[] byArray) {
        try {
            hash.write(byArray);
        }
        catch (IOException iOException) {}
        return hash.getHashAsBytes();
    }

    @Override
    public int getHashSize() {
        return 20;
    }

    @Override
    public byte[] hashSSL(byte[] byArray) {
        return HashingAlgorithmSHA1.hashSHA1(byArray);
    }

    @Override
    public byte[] getPad1() {
        return PAD_1;
    }

    @Override
    public byte[] getPad2() {
        return PAD_2;
    }

    @Override
    public byte[] hashTLS(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[20];
        CL3State cL3State = HMAC.hmacInit(null, 3, byArray, 0, byArray.length);
        HMAC.hmac(cL3State, byArray2, 0, byArray2.length, byArray3, 0);
        return byArray3;
    }
}

