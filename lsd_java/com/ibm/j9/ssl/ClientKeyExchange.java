/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.Util;
import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.security.provider.RSAPublicKey;
import java.io.IOException;
import java.security.SecureRandom;

public class ClientKeyExchange {
    private RSAPublicKey serverPublicKey = null;
    private byte[] preMasterSecret = null;
    private byte[] encodedData = null;
    private static boolean debugHandshakeMessages = true;
    private static String lineTerminator = Util.getLineTerminator();

    public ClientKeyExchange(RSAPublicKey rSAPublicKey, byte[] byArray) {
        this.serverPublicKey = rSAPublicKey;
        this.preMasterSecret = byArray;
        PKCS1 pKCS1 = new PKCS1("SHA1");
        try {
            this.encodedData = pKCS1.encryptPKCS_15(this.serverPublicKey, this.preMasterSecret, new SecureRandom());
        }
        catch (IOException iOException) {
            this.encodedData = null;
        }
    }

    public byte[] toByteArray() {
        return this.encodedData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer("====Client Key Exchange====").append(lineTerminator).toString());
        stringBuffer.append(new StringBuffer("PreMasterSecret (").append(this.preMasterSecret.length).append("): ").append(Util.getStringForByteArray(this.preMasterSecret)).append(lineTerminator).toString());
        stringBuffer.append(new StringBuffer("Encrypted PreMasterSecret (").append(this.encodedData.length).append("): ").append(Util.getStringForByteArray(this.encodedData)).append(lineTerminator).toString());
        stringBuffer.append(new StringBuffer("===========================").append(lineTerminator).toString());
        return stringBuffer.toString();
    }
}

