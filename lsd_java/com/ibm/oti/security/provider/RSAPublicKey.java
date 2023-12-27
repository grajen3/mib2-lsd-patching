/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAPublicKey
implements java.security.interfaces.RSAPublicKey {
    protected BigInteger modulus = null;
    protected BigInteger publicExponent = null;
    protected byte[] encoded = null;

    public RSAPublicKey(java.security.interfaces.RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
    }

    public RSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this(rSAPublicKeySpec.getModulus(), rSAPublicKeySpec.getPublicExponent());
    }

    public RSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    public RSAPublicKey() {
    }

    public RSAPublicKey(X509EncodedKeySpec x509EncodedKeySpec) {
        this.encoded = x509EncodedKeySpec.getEncoded();
        try {
            this.decodeFromX509();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new InvalidKeySpecException();
        }
    }

    public RSAPublicKey(byte[] byArray) {
        this.encoded = byArray;
        try {
            this.decodeFromX509();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getAlgorithm() {
        return "RSA";
    }

    @Override
    public byte[] getEncoded() {
        if (this.encoded == null) {
            this.encoded = ASN1Encoder.encodeNode(this.toASN1Node());
        }
        return this.encoded;
    }

    @Override
    public String getFormat() {
        return "X.509";
    }

    @Override
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public RSAPublicKeySpec toKeySpec() {
        return new RSAPublicKeySpec(this.modulus, this.publicExponent);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getClass().getName());
        RSAPublicKey.writeParamString(this.modulus, "modulus (n)", stringBuffer);
        RSAPublicKey.writeParamString(this.publicExponent, "public exponent (e)", stringBuffer);
        return stringBuffer.toString();
    }

    public static void writeParamString(BigInteger bigInteger, String string, StringBuffer stringBuffer) {
        stringBuffer.append("\n\t");
        stringBuffer.append(string);
        stringBuffer.append(": ");
        String string2 = bigInteger.toString(16);
        int n = 0;
        while (n < string2.length()) {
            if (n % 64 == 0) {
                stringBuffer.append("\n\t\t");
            } else if (n % 8 == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(string2.charAt(n));
            ++n;
        }
    }

    protected void decodeFromX509() {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(this.encoded));
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder.readContents().data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[0].data;
            int[] nArray = (int[])aSN1Decoder$NodeArray2[0].data;
            int n = 0;
            while (n < PKCS1.OID_RSA.length) {
                if (n == nArray.length || nArray[n] != PKCS1.OID_RSA[n]) {
                    throw new ASN1Exception();
                }
                ++n;
            }
            ASN1Decoder$BitString aSN1Decoder$BitString = (ASN1Decoder$BitString)aSN1Decoder$NodeArray[1].data;
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(aSN1Decoder$BitString.data));
            ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder.readContents().data;
            if (aSN1Decoder$NodeArray3 == null || aSN1Decoder$NodeArray3.length < 2) {
                throw new ASN1Exception();
            }
            this.modulus = (BigInteger)aSN1Decoder$NodeArray3[0].data;
            this.publicExponent = (BigInteger)aSN1Decoder$NodeArray3[1].data;
        }
        catch (ClassCastException classCastException) {
            throw new ASN1Exception();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ASN1Exception();
        }
    }

    public ASN1Decoder$Node toASN1Node() {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray;
        ASN1Decoder$Node[] aSN1Decoder$NodeArray2;
        ASN1Decoder$Node[] aSN1Decoder$NodeArray3;
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.type = 16;
        aSN1Decoder$Node.data = aSN1Decoder$NodeArray3 = new ASN1Decoder$Node[2];
        aSN1Decoder$NodeArray3[0] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray3[0].type = 16;
        aSN1Decoder$NodeArray3[0].data = aSN1Decoder$NodeArray2 = new ASN1Decoder$Node[2];
        aSN1Decoder$NodeArray2[0] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray2[0].type = 6;
        aSN1Decoder$NodeArray2[0].data = PKCS1.OID_RSA;
        aSN1Decoder$NodeArray2[1] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray2[1].type = 5;
        ASN1Decoder$Node aSN1Decoder$Node2 = new ASN1Decoder$Node();
        aSN1Decoder$Node2.type = 16;
        aSN1Decoder$Node2.data = aSN1Decoder$NodeArray = new ASN1Decoder$Node[2];
        aSN1Decoder$NodeArray[0] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray[0].type = 2;
        aSN1Decoder$NodeArray[0].data = this.modulus;
        aSN1Decoder$NodeArray[1] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray[1].type = 2;
        aSN1Decoder$NodeArray[1].data = this.publicExponent;
        aSN1Decoder$NodeArray3[1] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray3[1].type = 3;
        aSN1Decoder$NodeArray3[1].data = new ASN1Decoder$BitString(0, ASN1Encoder.encodeNode(aSN1Decoder$Node2));
        return aSN1Decoder$Node;
    }
}

