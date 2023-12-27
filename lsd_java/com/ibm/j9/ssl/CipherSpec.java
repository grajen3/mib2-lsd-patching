/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherAlgorithm;
import com.ibm.j9.ssl.HashingAlgorithm;
import com.ibm.j9.ssl.HashingAlgorithmMD5;
import com.ibm.j9.ssl.HashingAlgorithmNull;
import com.ibm.j9.ssl.HashingAlgorithmSHA1;
import com.ibm.j9.ssl.SSLProtocol;
import com.ibm.j9.ssl.TLSProtocol;
import com.ibm.j9.ssl.Util;
import com.ibm.oti.crypto.Provider;
import java.io.IOException;
import java.io.InputStream;

public class CipherSpec {
    private byte[] id;
    private String idString;
    int cipherAlg;
    int cipherKeyBitLength;
    int keyMaterialLength;
    boolean isExportable;
    private String hashingAlgorithm;
    public static final byte[] NULL_PROTOCOL_VERSION = new byte[2];
    public static final String NULL_PROTOCOL_NAME;
    public static final CipherSpec NULL_SPEC;
    public static final CipherSpec[] SUPPORTED_SPECS;
    public static final String[] SUPPORTED_SPEC_IDS;

    static {
        NULL_SPEC = new CipherSpec(new byte[2], "SSL_NULL_WITH_NULL_NULL", -1, 0, 0, false, null);
        CipherSpec[] cipherSpecArray = new CipherSpec[6];
        byte[] byArray = new byte[2];
        byArray[1] = 10;
        cipherSpecArray[0] = new CipherSpec(byArray, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 2, 168, 24, false, "SHA1");
        byte[] byArray2 = new byte[2];
        byArray2[1] = 9;
        cipherSpecArray[1] = new CipherSpec(byArray2, "SSL_RSA_WITH_DES_CBC_SHA", 1, 56, 8, false, "SHA1");
        byte[] byArray3 = new byte[2];
        byArray3[1] = 8;
        cipherSpecArray[2] = new CipherSpec(byArray3, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 1, 56, 5, true, "SHA1");
        byte[] byArray4 = new byte[2];
        byArray4[1] = 2;
        cipherSpecArray[3] = new CipherSpec(byArray4, "SSL_RSA_WITH_NULL_SHA", 6, 0, 0, false, "SHA1");
        byte[] byArray5 = new byte[2];
        byArray5[1] = 1;
        cipherSpecArray[4] = new CipherSpec(byArray5, "SSL_RSA_WITH_NULL_MD5", 6, 0, 0, false, "MD5");
        byte[] byArray6 = new byte[2];
        byArray6[1] = 47;
        cipherSpecArray[5] = new CipherSpec(byArray6, "TLS_RSA_WITH_AES_128_CBC_SHA", 5, 128, 16, false, "SHA1");
        SUPPORTED_SPECS = cipherSpecArray;
        SUPPORTED_SPEC_IDS = CipherSpec.getSupportedCipherSuiteIDs();
    }

    public static final String[] getSupportedCipherSuiteIDs() {
        CipherSpec[] cipherSpecArray = SUPPORTED_SPECS;
        String[] stringArray = new String[cipherSpecArray.length];
        int n = 0;
        while (n < cipherSpecArray.length) {
            stringArray[n] = cipherSpecArray[n].getIdString();
            ++n;
        }
        return stringArray;
    }

    public static CipherSpec[] getCipherSpecs(String[] stringArray) {
        CipherSpec[] cipherSpecArray = new CipherSpec[stringArray.length];
        int n = 0;
        while (n < stringArray.length) {
            cipherSpecArray[n] = CipherSpec.getCipherSpec(stringArray[n]);
            ++n;
        }
        return cipherSpecArray;
    }

    public static CipherSpec getCipherSpec(String string) {
        int n = 0;
        while (n < SUPPORTED_SPECS.length) {
            if (SUPPORTED_SPECS[n].getIdString().equals(string)) {
                return SUPPORTED_SPECS[n];
            }
            ++n;
        }
        return NULL_SPEC;
    }

    public static CipherSpec getCipherSpec(InputStream inputStream) {
        byte[] byArray = new byte[2];
        inputStream.read(byArray);
        return CipherSpec.getCipherSpec(byArray);
    }

    public static CipherSpec getCipherSpec(byte[] byArray) {
        int n = 0;
        while (n < SUPPORTED_SPECS.length) {
            if (byArray[0] == SUPPORTED_SPECS[n].getId()[0] && byArray[1] == SUPPORTED_SPECS[n].getId()[1]) {
                return SUPPORTED_SPECS[n];
            }
            ++n;
        }
        return null;
    }

    public static byte[] getProtocolVersion(String string) {
        if (string.equals("SSLv3")) {
            return SSLProtocol.SSL_PROTOCOL_VERSION;
        }
        if (string.equals("TLSv1")) {
            return TLSProtocol.TLS_PROTOCOL_VERSION;
        }
        return NULL_PROTOCOL_VERSION;
    }

    private CipherSpec(byte[] byArray, String string, int n, int n2, int n3, boolean bl, String string2) {
        this.id = byArray;
        this.idString = string;
        this.cipherAlg = n;
        this.cipherKeyBitLength = n2;
        this.keyMaterialLength = n3;
        this.isExportable = bl;
        this.hashingAlgorithm = string2;
    }

    public byte[] getId() {
        return this.id;
    }

    public String getIdString() {
        return this.idString;
    }

    public String toString() {
        return this.idString != null ? this.idString : new StringBuffer("0x").append(Integer.toHexString(this.id[0])).append(",0x").append(Integer.toHexString(this.id[1])).toString();
    }

    public CipherAlgorithm newCipherAlgorithm() {
        if (this.cipherAlg == -1) {
            return null;
        }
        try {
            return new CipherAlgorithm(Provider.getProvider(this.cipherAlg, this.cipherKeyBitLength));
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public HashingAlgorithm getHashingAlgorithm() {
        if (this.hashingAlgorithm == null) {
            return new HashingAlgorithmNull();
        }
        if (this.hashingAlgorithm.equals("SHA1")) {
            return new HashingAlgorithmSHA1();
        }
        if (this.hashingAlgorithm.equals("MD5")) {
            return new HashingAlgorithmMD5();
        }
        return null;
    }

    public static String getProtocolName(byte[] byArray) {
        if (Util.equals(byArray, SSLProtocol.SSL_PROTOCOL_VERSION)) {
            return "SSLv3";
        }
        if (Util.equals(byArray, TLSProtocol.TLS_PROTOCOL_VERSION)) {
            return "TLSv1";
        }
        return "";
    }
}

