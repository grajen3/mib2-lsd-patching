/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.AlgorithmParameterGeneratorDSA;
import com.ibm.oti.security.provider.DSAPrivateKey;
import com.ibm.oti.security.provider.DSAPublicKey;
import com.ibm.oti.util.SHAOutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.DSAKeyPairGenerator;
import java.security.interfaces.DSAParams;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class KeyPairGeneratorDSA
extends KeyPairGenerator
implements DSAKeyPairGenerator {
    protected int keySize = 512;
    protected SecureRandom random;
    protected DSAParams params;
    private static final BigInteger TWO = BigInteger.valueOf(0);
    private static final int PRIME_CERTAINTY;
    static /* synthetic */ Class class$0;

    public KeyPairGeneratorDSA() {
        super("DSA");
    }

    @Override
    public void initialize(DSAParams dSAParams, SecureRandom secureRandom) {
        if (!this.isDSAParamsValid(dSAParams)) {
            throw new InvalidParameterException("K039c");
        }
        this.params = dSAParams;
        this.random = secureRandom;
    }

    @Override
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        DSAParameterSpec dSAParameterSpec = null;
        try {
            if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
                throw new InvalidAlgorithmParameterException();
            }
            dSAParameterSpec = (DSAParameterSpec)algorithmParameterSpec;
            this.initialize(dSAParameterSpec, secureRandom);
        }
        catch (InvalidParameterException invalidParameterException) {
            throw new InvalidAlgorithmParameterException(invalidParameterException.getMessage());
        }
    }

    @Override
    public void initialize(int n, boolean bl, SecureRandom secureRandom) {
        if (n < 512 || n > 1024 || n % 64 != 0) {
            this.throwCorrectInvalidParameterException("K0191");
        }
        this.keySize = n;
        this.random = secureRandom;
        this.params = null;
        if (bl) {
            this.doGenerateParameters();
        } else {
            switch (this.keySize) {
                case 512: {
                    this.params = new DSAParameterSpec(AlgorithmParameterGeneratorDSA.p_512, AlgorithmParameterGeneratorDSA.q_512, AlgorithmParameterGeneratorDSA.g_512);
                    return;
                }
                case 768: {
                    this.params = new DSAParameterSpec(AlgorithmParameterGeneratorDSA.p_768, AlgorithmParameterGeneratorDSA.q_768, AlgorithmParameterGeneratorDSA.g_768);
                    return;
                }
                case 1024: {
                    this.params = new DSAParameterSpec(AlgorithmParameterGeneratorDSA.p_1024, AlgorithmParameterGeneratorDSA.q_1024, AlgorithmParameterGeneratorDSA.g_1024);
                    return;
                }
            }
            this.throwCorrectInvalidParameterException("K039b");
        }
    }

    @Override
    public void initialize(int n, SecureRandom secureRandom) {
        this.initialize(n, false, secureRandom);
    }

    protected BigInteger generatePrivateKey() {
        int n = this.keySize;
        int n2 = (n - 1) / 160;
        int n3 = n - 1 - 160 * n2;
        int n4 = 20;
        byte[] byArray = new byte[n4];
        this.random.nextBytes(byArray);
        byte[] byArray2 = new byte[n4];
        this.random.nextBytes(byArray2);
        BigInteger bigInteger = new BigInteger(1, byArray).add(new BigInteger(1, byArray2));
        BigInteger bigInteger2 = bigInteger.mod(TWO.pow(n3));
        byte[] byArray3 = bigInteger2.toByteArray();
        SHAOutputStream sHAOutputStream = new SHAOutputStream();
        sHAOutputStream.write(byArray3, 0, byArray3.length);
        byte[] byArray4 = sHAOutputStream.getHashAsBytes();
        return new BigInteger(1, byArray4).mod(this.params.getQ());
    }

    protected BigInteger generatePublicKey(BigInteger bigInteger) {
        BigInteger bigInteger2 = this.params.getG();
        return bigInteger2.modPow(bigInteger, this.params.getP());
    }

    @Override
    public KeyPair generateKeyPair() {
        if (this.params == null) {
            this.generateParameters();
        }
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        BigInteger bigInteger = this.generatePrivateKey();
        DSAPrivateKey dSAPrivateKey = new DSAPrivateKey(this.params, bigInteger);
        BigInteger bigInteger2 = this.generatePublicKey(bigInteger);
        DSAPublicKey dSAPublicKey = new DSAPublicKey(this.params, bigInteger2);
        return new KeyPair(dSAPublicKey, dSAPrivateKey);
    }

    protected void generateParameters() {
        switch (this.keySize) {
            case 512: {
                this.params = new DSAParameterSpec(AlgorithmParameterGeneratorDSA.p_512, AlgorithmParameterGeneratorDSA.q_512, AlgorithmParameterGeneratorDSA.g_512);
                return;
            }
            case 768: {
                this.params = new DSAParameterSpec(AlgorithmParameterGeneratorDSA.p_768, AlgorithmParameterGeneratorDSA.q_768, AlgorithmParameterGeneratorDSA.g_768);
                return;
            }
            case 1024: {
                this.params = new DSAParameterSpec(AlgorithmParameterGeneratorDSA.p_1024, AlgorithmParameterGeneratorDSA.q_1024, AlgorithmParameterGeneratorDSA.g_1024);
                return;
            }
        }
        this.doGenerateParameters();
    }

    protected void doGenerateParameters() {
        AlgorithmParameterGenerator algorithmParameterGenerator;
        try {
            algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("DSA");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new Error();
        }
        algorithmParameterGenerator.init(this.keySize, this.random);
        AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
        try {
            Class clazz = class$0;
            if (clazz == null) {
                try {
                    clazz = class$0 = Class.forName("java.security.spec.DSAParameterSpec");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            this.params = (DSAParameterSpec)algorithmParameters.getParameterSpec(clazz);
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new Error();
        }
    }

    private boolean isDSAParamsValid(DSAParams dSAParams) {
        if (dSAParams == null) {
            return false;
        }
        boolean bl = false;
        BigInteger bigInteger = dSAParams.getP();
        int n = 512;
        while (n <= 1024) {
            if (bigInteger.compareTo(TWO.pow(n - 1)) > 0 || bigInteger.compareTo(TWO.pow(n)) < 0) {
                bl = true;
                break;
            }
            n += 64;
        }
        if (!bl) {
            return false;
        }
        if (!bigInteger.isProbablePrime(8)) {
            return false;
        }
        BigInteger bigInteger2 = dSAParams.getQ();
        if (bigInteger.subtract(BigInteger.ONE).mod(bigInteger2).compareTo(BigInteger.ZERO) != 0) {
            return false;
        }
        if (bigInteger2.compareTo(TWO.pow(159)) <= 0 || bigInteger2.compareTo(TWO.pow(160)) >= 0) {
            return false;
        }
        return bigInteger2.isProbablePrime(8);
    }

    private void throwCorrectInvalidParameterException(String string) {
        throw new InvalidParameterException(string);
    }
}

