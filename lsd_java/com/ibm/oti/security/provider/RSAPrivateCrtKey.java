/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Arrays;

public class RSAPrivateCrtKey
extends RSAPrivateKey
implements java.security.interfaces.RSAPrivateCrtKey {
    private static final long serialVersionUID;
    protected BigInteger publicExponent;
    protected BigInteger p;
    protected BigInteger q;
    protected BigInteger dP;
    protected BigInteger dQ;
    protected BigInteger qInv;

    public RSAPrivateCrtKey(java.security.interfaces.RSAPrivateCrtKey rSAPrivateCrtKey) {
        super(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPrivateExponent());
        this.publicExponent = rSAPrivateCrtKey.getPublicExponent();
        this.p = rSAPrivateCrtKey.getPrimeP();
        this.q = rSAPrivateCrtKey.getPrimeQ();
        this.dP = rSAPrivateCrtKey.getPrimeExponentP();
        this.dQ = rSAPrivateCrtKey.getPrimeExponentQ();
        this.qInv = rSAPrivateCrtKey.getCrtCoefficient();
    }

    public RSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        super(rSAPrivateCrtKeySpec.getModulus(), rSAPrivateCrtKeySpec.getPrivateExponent());
        this.publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
        this.p = rSAPrivateCrtKeySpec.getPrimeP();
        this.q = rSAPrivateCrtKeySpec.getPrimeQ();
        this.dP = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.dQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.qInv = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public RSAPrivateCrtKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(bigInteger, bigInteger3);
        this.publicExponent = bigInteger2;
        this.p = bigInteger4;
        this.q = bigInteger5;
        this.dP = bigInteger6;
        this.dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public RSAPrivateCrtKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec) {
        this.encoded = pKCS8EncodedKeySpec.getEncoded();
        try {
            this.decodeFromPKCS8();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidKeySpecException(illegalArgumentException.getMessage());
        }
    }

    @Override
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override
    public BigInteger getPrimeP() {
        return this.p;
    }

    @Override
    public BigInteger getPrimeQ() {
        return this.q;
    }

    @Override
    public BigInteger getPrimeExponentP() {
        return this.dP;
    }

    @Override
    public BigInteger getPrimeExponentQ() {
        return this.dQ;
    }

    @Override
    public BigInteger getCrtCoefficient() {
        return this.qInv;
    }

    @Override
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    @Override
    public BigInteger getModulus() {
        return this.p.multiply(this.q);
    }

    @Override
    public String getAlgorithm() {
        return "RSA";
    }

    @Override
    public String getFormat() {
        return "PKCS#8";
    }

    @Override
    public byte[] getEncoded() {
        if (this.encoded == null) {
            this.encodeToPKCS8();
        }
        return this.encoded;
    }

    @Override
    public RSAPrivateKeySpec toKeySpec() {
        return new RSAPrivateCrtKeySpec(this.modulus, this.publicExponent, this.privateExponent, this.p, this.q, this.dP, this.dQ, this.qInv);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getClass().getName());
        RSAPublicKey.writeParamString(this.modulus, "modulus (n)", stringBuffer);
        RSAPublicKey.writeParamString(this.publicExponent, "public exponent (e)", stringBuffer);
        RSAPublicKey.writeParamString(this.privateExponent, "private exponent (d)", stringBuffer);
        RSAPublicKey.writeParamString(this.p, "prime P (P)", stringBuffer);
        RSAPublicKey.writeParamString(this.q, "prime Q (Q)", stringBuffer);
        RSAPublicKey.writeParamString(this.dP, "prime exponent P (dP)", stringBuffer);
        RSAPublicKey.writeParamString(this.dQ, "prime exponent Q (dQ)", stringBuffer);
        RSAPublicKey.writeParamString(this.qInv, "CRT coefficient (qInv)", stringBuffer);
        return stringBuffer.toString();
    }

    private void encodeToPKCS8() {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray;
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.type = 16;
        aSN1Decoder$Node.data = aSN1Decoder$NodeArray = new ASN1Decoder$Node[9];
        int n = 0;
        while (n < aSN1Decoder$NodeArray.length) {
            aSN1Decoder$NodeArray[n] = new ASN1Decoder$Node();
            aSN1Decoder$NodeArray[n].type = 2;
            switch (n) {
                case 0: {
                    aSN1Decoder$NodeArray[n].data = BigInteger.ZERO;
                    break;
                }
                case 1: {
                    aSN1Decoder$NodeArray[n].data = this.modulus;
                    break;
                }
                case 2: {
                    aSN1Decoder$NodeArray[n].data = this.publicExponent;
                    break;
                }
                case 3: {
                    aSN1Decoder$NodeArray[n].data = this.privateExponent;
                    break;
                }
                case 4: {
                    aSN1Decoder$NodeArray[n].data = this.p;
                    break;
                }
                case 5: {
                    aSN1Decoder$NodeArray[n].data = this.q;
                    break;
                }
                case 6: {
                    aSN1Decoder$NodeArray[n].data = this.dP;
                    break;
                }
                case 7: {
                    aSN1Decoder$NodeArray[n].data = this.dQ;
                    break;
                }
                case 8: {
                    aSN1Decoder$NodeArray[n].data = this.qInv;
                }
            }
            ++n;
        }
        byte[] byArray = ASN1Encoder.encodeNode(aSN1Decoder$Node);
        ASN1Decoder$Node aSN1Decoder$Node2 = new ASN1Decoder$Node();
        aSN1Decoder$Node2.type = 16;
        aSN1Decoder$Node2.data = aSN1Decoder$NodeArray = new ASN1Decoder$Node[3];
        aSN1Decoder$NodeArray[0] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray[0].type = 2;
        aSN1Decoder$NodeArray[0].data = BigInteger.ZERO;
        aSN1Decoder$NodeArray[1] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray[1].type = 16;
        aSN1Decoder$NodeArray[1].data = new ASN1Decoder$Node[2];
        ((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[0] = new ASN1Decoder$Node();
        ((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[0].type = 6;
        ((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[0].data = PKCS1.OID_RSA;
        ((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[1] = new ASN1Decoder$Node();
        ((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[1].type = 5;
        ((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[1].data = null;
        aSN1Decoder$NodeArray[2] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray[2].type = 4;
        aSN1Decoder$NodeArray[2].data = byArray;
        this.encoded = ASN1Encoder.encodeNode(aSN1Decoder$Node2);
    }

    protected void decodeFromPKCS8() {
        try {
            ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(this.encoded));
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
            if (!((BigInteger)aSN1Decoder$NodeArray[0].data).equals(BigInteger.ZERO)) {
                throw new IllegalArgumentException();
            }
            int[] nArray = (int[])((ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data)[0].data;
            if (!Arrays.equals(nArray, PKCS1.OID_RSA)) {
                throw new IllegalArgumentException();
            }
            byte[] byArray = (byte[])aSN1Decoder$NodeArray[2].data;
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder.readContents();
            aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
            int n = 0;
            while (n < aSN1Decoder$NodeArray.length) {
                switch (n) {
                    case 0: {
                        if (((BigInteger)aSN1Decoder$NodeArray[n].data).equals(BigInteger.ZERO)) break;
                        throw new IllegalArgumentException();
                    }
                    case 1: {
                        this.modulus = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 2: {
                        this.publicExponent = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 3: {
                        this.privateExponent = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 4: {
                        this.p = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 5: {
                        this.q = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 6: {
                        this.dP = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 7: {
                        this.dQ = (BigInteger)aSN1Decoder$NodeArray[n].data;
                        break;
                    }
                    case 8: {
                        this.qInv = (BigInteger)aSN1Decoder$NodeArray[n].data;
                    }
                }
                ++n;
            }
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
        catch (ClassCastException classCastException) {
            throw new IllegalArgumentException();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new IllegalArgumentException();
        }
    }

    protected RSAPrivateCrtKey() {
    }
}

