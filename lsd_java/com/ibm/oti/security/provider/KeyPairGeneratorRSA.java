/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.bluez.crypto.RSACipher;
import com.ibm.oti.security.provider.RSAPrivateCrtKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.util.Msg;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;

public class KeyPairGeneratorRSA
extends KeyPairGenerator {
    private int keySize = 512;
    private SecureRandom random = new SecureRandom();
    private BigInteger publicExponent = RSAKeyGenParameterSpec.F4;

    public KeyPairGeneratorRSA() {
        super("RSA");
    }

    @Override
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec == null) {
            throw new InvalidParameterException();
        }
        this.keySize = ((RSAKeyGenParameterSpec)algorithmParameterSpec).getKeysize();
        this.publicExponent = ((RSAKeyGenParameterSpec)algorithmParameterSpec).getPublicExponent();
        if (this.publicExponent == null) {
            this.publicExponent = RSAKeyGenParameterSpec.F4;
        }
        this.random = secureRandom;
        this.validate();
    }

    @Override
    public void initialize(int n, SecureRandom secureRandom) {
        this.random = secureRandom;
        this.keySize = n;
        this.publicExponent = RSAKeyGenParameterSpec.F4;
        this.validate();
    }

    private void validate() {
        if (this.keySize % 8 != 0) {
            throw new InvalidParameterException(Msg.getString("K01ec"));
        }
        if (this.keySize < 512) {
            throw new InvalidParameterException(Msg.getString("K01ed"));
        }
    }

    @Override
    public KeyPair generateKeyPair() {
        BigInteger bigInteger;
        CL3 cL3 = RSACipher.rsaKeyGen(this.keySize, this.publicExponent.toByteArray(), this.random);
        byte[][] byArray = RSACipher.exportRSAKeyMaterial(cL3);
        BigInteger bigInteger2 = new BigInteger(byArray[0]);
        BigInteger bigInteger3 = new BigInteger(byArray[1]);
        BigInteger bigInteger4 = bigInteger2.multiply(bigInteger3);
        if (bigInteger2.compareTo(bigInteger3) < 0) {
            bigInteger = bigInteger2;
            bigInteger2 = bigInteger3;
            bigInteger3 = bigInteger;
        }
        bigInteger = bigInteger2.subtract(BigInteger.ONE);
        BigInteger bigInteger5 = bigInteger3.subtract(BigInteger.ONE);
        BigInteger bigInteger6 = bigInteger.multiply(bigInteger5);
        BigInteger bigInteger7 = this.publicExponent;
        BigInteger bigInteger8 = bigInteger7.modInverse(bigInteger6);
        BigInteger bigInteger9 = bigInteger8.remainder(bigInteger);
        BigInteger bigInteger10 = bigInteger8.remainder(bigInteger5);
        BigInteger bigInteger11 = bigInteger3.modInverse(bigInteger2);
        RSAPrivateCrtKey rSAPrivateCrtKey = new RSAPrivateCrtKey(bigInteger4, bigInteger7, bigInteger8, bigInteger2, bigInteger3, bigInteger9, bigInteger10, bigInteger11);
        RSAPublicKey rSAPublicKey = new RSAPublicKey(bigInteger4, bigInteger7);
        return new KeyPair(rSAPublicKey, rSAPrivateCrtKey);
    }
}

