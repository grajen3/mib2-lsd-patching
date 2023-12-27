/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.MD5OutputStream;
import com.ibm.oti.security.provider.RSAPrivateCrtKey;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.SHAOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Random;

public class PKCS1 {
    public static final int[] OID_RSA = new int[]{1, 2, 840, -1917124352, 1, 1, 1};
    public static final int[] OID_SHA1 = new int[]{1, 3, 14, 3, 2, 26};
    public static final int[] OID_MD5 = new int[]{1, 2, 840, -1917124352, 2, 5};
    private SHAOutputStream sha = null;
    private MD5OutputStream md5 = null;
    private static final int NULL_HASH;
    private static final int SHA1_HASH;
    private static final int MD5_HASH;
    private static final int MD2_HASH;
    private int hashAlg = -1;

    public PKCS1(String string) {
        this.SECU_initialiser(string);
    }

    private void SECU_initialiser(String string) {
        if (string.equals("SHA1")) {
            this.sha = new SHAOutputStream();
            this.hashAlg = 1;
        } else if (string.equals("MD5")) {
            this.md5 = new MD5OutputStream();
            this.hashAlg = 2;
        } else if (string.equals("MD2")) {
            this.hashAlg = 3;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public byte[] encryptPKCS_15(RSAPublicKey rSAPublicKey, byte[] byArray, Random random) {
        return this.SECU_encryptPKCS_15(rSAPublicKey, byArray, random);
    }

    private byte[] SECU_encryptPKCS_15(RSAPublicKey rSAPublicKey, byte[] byArray, Random random) {
        int n = this.countOctets(rSAPublicKey);
        if (byArray.length > n - 11) {
            throw new IOException("Message too long");
        }
        byte[] byArray2 = new byte[n - byArray.length - 3];
        int n2 = 0;
        while (n2 < byArray2.length) {
            byArray2[n2] = (byte)random.nextInt();
            if (byArray2[n2] == 0) continue;
            ++n2;
        }
        byte[] byArray3 = new byte[2];
        byArray3[1] = 2;
        byte[] byArray4 = this.concatenate(byArray3, byArray2, new byte[1], byArray);
        BigInteger bigInteger = this.OS2IP(byArray4);
        BigInteger bigInteger2 = this.RSAEP(rSAPublicKey, bigInteger);
        byte[] byArray5 = this.I2OSP(bigInteger2, n);
        return byArray5;
    }

    public boolean verifySSA_PKCS1_v15(RSAPublicKey rSAPublicKey, InputStream inputStream, byte[] byArray) {
        return this.verifySSA_PKCS1_v15Impl(rSAPublicKey, this.digest(inputStream), byArray);
    }

    public boolean verifySSA_PKCS1_v15(RSAPublicKey rSAPublicKey, byte[] byArray, byte[] byArray2) {
        return this.verifySSA_PKCS1_v15Impl(rSAPublicKey, this.digest(byArray), byArray2);
    }

    public boolean verifySSA_PKCS1_v15Impl(RSAPublicKey rSAPublicKey, byte[] byArray, byte[] byArray2) {
        int n = this.countOctets(rSAPublicKey);
        if (byArray2.length != n) {
            return false;
        }
        BigInteger bigInteger = this.OS2IP(byArray2);
        try {
            BigInteger bigInteger2 = this.RSAEP(rSAPublicKey, bigInteger);
            byte[] byArray3 = this.I2OSP(bigInteger2, n);
            byte[] byArray4 = this.EMSA_PKCS1_v15_ENCODE(byArray, n);
            return Arrays.equals(byArray4, byArray3);
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public byte[] signSSA_PKCS1_v15(RSAPrivateKey rSAPrivateKey, InputStream inputStream) {
        return this.signSSA_PKCS1_v15Impl(rSAPrivateKey, this.digest(inputStream));
    }

    public byte[] signSSA_PKCS1_v15(RSAPrivateKey rSAPrivateKey, byte[] byArray) {
        return this.signSSA_PKCS1_v15Impl(rSAPrivateKey, this.digest(byArray));
    }

    public byte[] signSSA_PKCS1_v15Impl(RSAPrivateKey rSAPrivateKey, byte[] byArray) {
        int n = this.countOctets(rSAPrivateKey);
        byte[] byArray2 = this.EMSA_PKCS1_v15_ENCODE(byArray, n);
        byte[] byArray3 = this.completeSignSSA_PKCS1_v15Impl(rSAPrivateKey, n, byArray2);
        return byArray3;
    }

    private byte[] completeSignSSA_PKCS1_v15Impl(RSAPrivateKey rSAPrivateKey, int n, byte[] byArray) {
        BigInteger bigInteger = this.OS2IP(byArray);
        BigInteger bigInteger2 = this.RSADP(rSAPrivateKey, bigInteger);
        byte[] byArray2 = this.I2OSP(bigInteger2, n);
        return byArray2;
    }

    public byte[] signSSA_PKCS1_v15Impl_NO_DER(RSAPrivateKey rSAPrivateKey, byte[] byArray) {
        int n = this.countOctets(rSAPrivateKey);
        byte[] byArray2 = this.form_EM(byArray, n);
        byte[] byArray3 = this.completeSignSSA_PKCS1_v15Impl(rSAPrivateKey, n, byArray2);
        return byArray3;
    }

    public BigInteger RSAEP(RSAPublicKey rSAPublicKey, BigInteger bigInteger) {
        if (bigInteger.min(BigInteger.ZERO) == bigInteger) {
            throw new IOException("Message representative out of range");
        }
        if (rSAPublicKey.getModulus().subtract(bigInteger).min(BigInteger.ONE) != BigInteger.ONE) {
            throw new IOException("Message representative out of range");
        }
        return bigInteger.modPow(rSAPublicKey.getPublicExponent(), rSAPublicKey.getModulus());
    }

    public BigInteger RSADP(RSAPrivateKey rSAPrivateKey, BigInteger bigInteger) {
        if (bigInteger.min(BigInteger.ZERO) == bigInteger) {
            throw new IOException("Ciphertext representative out of range");
        }
        if (rSAPrivateKey.getModulus().subtract(bigInteger).min(BigInteger.ONE) != BigInteger.ONE) {
            throw new IOException("Ciphertext representative out of range");
        }
        return bigInteger.modPow(rSAPrivateKey.getPrivateExponent(), rSAPrivateKey.getModulus());
    }

    public BigInteger RSADP(RSAPrivateCrtKey rSAPrivateCrtKey, BigInteger bigInteger) {
        if (bigInteger.min(BigInteger.ZERO) == bigInteger) {
            throw new IOException("Ciphertext representative out of range");
        }
        if (rSAPrivateCrtKey.getModulus().subtract(bigInteger).min(BigInteger.ONE) != BigInteger.ONE) {
            throw new IOException("Ciphertext representative out of range");
        }
        BigInteger bigInteger2 = bigInteger.modPow(rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeP());
        BigInteger bigInteger3 = bigInteger.modPow(rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getPrimeQ());
        BigInteger bigInteger4 = bigInteger2.subtract(bigInteger3).multiply(rSAPrivateCrtKey.getCrtCoefficient()).mod(rSAPrivateCrtKey.getPrimeP());
        BigInteger bigInteger5 = bigInteger3.add(rSAPrivateCrtKey.getPrimeQ().multiply(bigInteger4));
        return bigInteger5;
    }

    private byte[] EMSA_PKCS1_v15_ENCODE(byte[] byArray, int n) {
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.type = 6;
        aSN1Decoder$Node.data = this.getDigestAlgorithmOID();
        ASN1Decoder$Node aSN1Decoder$Node2 = new ASN1Decoder$Node();
        aSN1Decoder$Node2.type = 5;
        aSN1Decoder$Node2.data = null;
        ASN1Decoder$Node aSN1Decoder$Node3 = new ASN1Decoder$Node();
        aSN1Decoder$Node3.type = 16;
        aSN1Decoder$Node3.data = new ASN1Decoder$Node[]{aSN1Decoder$Node, aSN1Decoder$Node2};
        ASN1Decoder$Node aSN1Decoder$Node4 = new ASN1Decoder$Node();
        aSN1Decoder$Node4.type = 4;
        aSN1Decoder$Node4.data = byArray;
        ASN1Decoder$Node aSN1Decoder$Node5 = new ASN1Decoder$Node();
        aSN1Decoder$Node5.type = 16;
        aSN1Decoder$Node5.data = new ASN1Decoder$Node[]{aSN1Decoder$Node3, aSN1Decoder$Node4};
        byte[] byArray2 = ASN1Encoder.encodeNode(aSN1Decoder$Node5);
        return this.form_EM(byArray2, n);
    }

    private byte[] form_EM(byte[] byArray, int n) {
        if (n < byArray.length + 11) {
            throw new IOException("Intended encoded message too short");
        }
        byte[] byArray2 = this.repeat((byte)-1, n - byArray.length - 3);
        byte[] byArray3 = new byte[2];
        byArray3[1] = 1;
        byte[] byArray4 = this.concatenate(byArray3, byArray2, new byte[1], byArray);
        return byArray4;
    }

    private byte[] I2OSP(long l, int n) {
        return this.I2OSP(BigInteger.valueOf(l), n);
    }

    public byte[] I2OSP(BigInteger bigInteger, int n) {
        byte[] byArray = bigInteger.toByteArray();
        if (byArray.length == n) {
            return byArray;
        }
        byte[] byArray2 = new byte[n];
        if (byArray.length < n) {
            System.arraycopy((Object)byArray, 0, (Object)byArray2, n - byArray.length, byArray.length);
        } else {
            System.arraycopy((Object)byArray, byArray.length - n, (Object)byArray2, 0, n);
        }
        return byArray2;
    }

    public BigInteger OS2IP(byte[] byArray) {
        return new BigInteger(1, byArray);
    }

    private byte[] MGF1(byte[] byArray, int n) {
        if (n > 0x800000) {
            throw new IOException("Mask too long");
        }
        byte[] byArray2 = new byte[]{};
        long l = (long)Math.ceil((double)n / (double)this.getDigestLength()) - 1L;
        long l2 = 0L;
        while (l2 <= l) {
            byte[] byArray3 = this.I2OSP(l2, 4);
            byArray2 = this.concatenate(byArray2, this.digest(this.concatenate(byArray, byArray3)));
            ++l2;
        }
        byte[] byArray4 = new byte[n];
        System.arraycopy((Object)byArray2, 0, (Object)byArray4, 0, n);
        return byArray4;
    }

    private byte[] exclusiveOr(byte[] byArray, byte[] byArray2) {
        if (byArray.length != byArray2.length) {
            throw new IOException("Different argument lengths");
        }
        byte[] byArray3 = new byte[byArray.length];
        int n = 0;
        while (n < byArray.length) {
            byArray3[n] = (byte)(byArray[n] ^ byArray2[n]);
            ++n;
        }
        return byArray3;
    }

    private byte[] concatenate(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    private byte[] concatenate(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        byte[] byArray4 = new byte[byArray.length + byArray2.length + byArray3.length];
        int n = 0;
        System.arraycopy((Object)byArray, 0, (Object)byArray4, n, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray4, n += byArray.length, byArray2.length);
        System.arraycopy((Object)byArray3, 0, (Object)byArray4, n += byArray2.length, byArray3.length);
        return byArray4;
    }

    private byte[] concatenate(byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4) {
        byte[] byArray5 = new byte[byArray.length + byArray2.length + byArray3.length + byArray4.length];
        int n = 0;
        System.arraycopy((Object)byArray, 0, (Object)byArray5, n, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray5, n += byArray.length, byArray2.length);
        System.arraycopy((Object)byArray3, 0, (Object)byArray5, n += byArray2.length, byArray3.length);
        System.arraycopy((Object)byArray4, 0, (Object)byArray5, n += byArray3.length, byArray4.length);
        return byArray5;
    }

    private byte[] repeat(byte by, int n) {
        byte[] byArray = new byte[n];
        while (--n >= 0) {
            byArray[n] = by;
        }
        return byArray;
    }

    private int[] getDigestAlgorithmOID() {
        String string;
        switch (this.hashAlg) {
            case 1: {
                string = "SHA";
                break;
            }
            case 3: {
                string = "MD2";
                break;
            }
            case 2: {
                string = "MD5";
                break;
            }
            default: {
                string = "NULL";
            }
        }
        Enumeration enumeration = X509Certificate.OID_DATABASE.keys();
        while (enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            if (!X509Certificate.OID_DATABASE.get(string2).equals(string)) continue;
            return ASN1OID.stringToIntOID(string2);
        }
        return null;
    }

    private byte[] digest(byte[] byArray) {
        try {
            if (this.sha != null) {
                this.sha.reset();
                this.sha.write(byArray);
                return this.sha.getHashAsBytes();
            }
            this.md5.reset();
            this.md5.write(byArray);
            return this.md5.getHashAsBytes();
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private byte[] digest(InputStream inputStream) {
        int n;
        if (this.sha != null) {
            this.sha.reset();
        } else {
            this.md5.reset();
        }
        byte[] byArray = new byte[800];
        while ((n = inputStream.read(byArray)) > 0) {
            if (this.sha != null) {
                this.sha.write(byArray, 0, n);
                continue;
            }
            this.md5.write(byArray, 0, n);
        }
        return this.sha != null ? this.sha.getHashAsBytes() : this.md5.getHashAsBytes();
    }

    private int getDigestLength() {
        if (this.sha != null) {
            return 20;
        }
        return 16;
    }

    private int countOctets(RSAPublicKey rSAPublicKey) {
        return this.countOctets(rSAPublicKey.getModulus());
    }

    private int countOctets(RSAPrivateKey rSAPrivateKey) {
        return this.countOctets(rSAPrivateKey.getModulus());
    }

    private int countOctets(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) / 8;
    }
}

