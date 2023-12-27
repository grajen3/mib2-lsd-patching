/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.SHAOutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParameterGeneratorDSA
extends AlgorithmParameterGeneratorSpi {
    private int size = 1024;
    private SecureRandom random;
    private AlgorithmParameters generatedParameters;
    static final BigInteger p_512 = new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16);
    static final BigInteger q_512 = new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16);
    static final BigInteger g_512 = new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16);
    static final BigInteger p_768 = new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16);
    static final BigInteger q_768 = new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16);
    static final BigInteger g_768 = new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16);
    static final BigInteger p_1024 = new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16);
    static final BigInteger q_1024 = new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16);
    static final BigInteger g_1024 = new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16);
    private static final BigInteger TWO = BigInteger.valueOf(0);
    private static final int g;
    private static final BigInteger twoRaisedTog;
    private static final int PRIME_CERTAINTY_EXP;

    static {
        twoRaisedTog = TWO.pow(160);
    }

    @Override
    protected AlgorithmParameters engineGenerateParameters() {
        if (this.generatedParameters == null) {
            this.generateParameters();
        }
        return this.generatedParameters;
    }

    @Override
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.random = secureRandom;
        this.initFromSpec(algorithmParameterSpec);
    }

    private void initFromSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        AlgorithmParameters algorithmParameters;
        try {
            algorithmParameters = AlgorithmParameters.getInstance("DSA");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            this.generatedParameters = null;
            return;
        }
        try {
            algorithmParameters.init(algorithmParameterSpec);
        }
        catch (InvalidParameterSpecException invalidParameterSpecException) {
            throw new InvalidAlgorithmParameterException();
        }
        this.generatedParameters = algorithmParameters;
    }

    @Override
    protected void engineInit(int n, SecureRandom secureRandom) {
        if (n < 512 || n > 1024 || n % 64 != 0) {
            throw new InvalidParameterException(Msg.getString("K0191"));
        }
        this.size = n;
        this.random = secureRandom;
        this.generatedParameters = null;
    }

    private BigInteger generate_g(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5 = bigInteger.subtract(BigInteger.ONE).divide(bigInteger2);
        boolean bl = false;
        do {
            int n;
            boolean bl2 = false;
            while (!(bl2 = (bigInteger3 = new BigInteger(n = bigInteger.bitLength(), this.random)).compareTo(bigInteger) < 0 && bigInteger3.compareTo(BigInteger.ONE) > 0)) {
            }
        } while (!(bl = (bigInteger4 = bigInteger3.multiply(bigInteger5).mod(bigInteger)).compareTo(BigInteger.ONE) != 0));
        return bigInteger4;
    }

    void setParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        try {
            this.initFromSpec(new DSAParameterSpec(bigInteger, bigInteger2, bigInteger3));
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new RuntimeException(invalidAlgorithmParameterException.toString());
        }
    }

    private byte[] xor(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length];
        int n = 0;
        while (n < byArray3.length) {
            byArray3[n] = (byte)(byArray[n] ^ byArray2[n]);
            ++n;
        }
        return byArray3;
    }

    protected void generateParameters() {
        int n = this.size;
        int n2 = (n - 1) / 160;
        int n3 = n - 1 - 160 * n2;
        BigInteger bigInteger = TWO.pow(n - 1);
        BigInteger bigInteger2 = TWO.pow(n3);
        while (true) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            BigInteger bigInteger3;
            Object[] objectArray;
            Object object5;
            BigInteger bigInteger4;
            BigInteger bigInteger5;
            boolean bl = false;
            do {
                byte[] byArray = new byte[20];
                this.random.nextBytes(byArray);
                bigInteger4 = new BigInteger(1, byArray);
                object5 = new SHAOutputStream();
                ((SHAOutputStream)object5).write(byArray, 0, byArray.length);
                objectArray = ((SHAOutputStream)object5).getHashAsBytes();
                bigInteger3 = bigInteger4.add(BigInteger.ONE);
                object4 = bigInteger3.mod(twoRaisedTog);
                ((SHAOutputStream)object5).reset();
                object3 = ((BigInteger)object4).toByteArray();
                ((SHAOutputStream)object5).write((byte[])object3, 0, ((byte[])object3).length);
                object2 = ((SHAOutputStream)object5).getHashAsBytes();
                object = this.xor((byte[])objectArray, (byte[])object2);
                bigInteger5 = new BigInteger(1, (byte[])object);
                bigInteger5 = bigInteger5.setBit(0);
            } while (!(bl = (bigInteger5 = bigInteger5.setBit(159)).isProbablePrime(80)));
            int n4 = 0;
            object5 = TWO;
            do {
                objectArray = new BigInteger[n2 + 1];
                bigInteger3 = bigInteger4.add((BigInteger)object5);
                int n5 = 0;
                while (n5 <= n2) {
                    object3 = BigInteger.valueOf(n5);
                    object2 = bigInteger3.add((BigInteger)object3);
                    objectArray[n5] = (byte)((BigInteger)object2).mod(twoRaisedTog);
                    ++n5;
                }
                object4 = objectArray[0];
                int n6 = 1;
                while (n6 < n2) {
                    int n7 = 160 * n6;
                    object = objectArray[n6].shiftLeft(n7);
                    object4 = ((BigInteger)object4).add((BigInteger)object);
                    ++n6;
                }
                object3 = objectArray[n2].mod(bigInteger2).shiftLeft(160 * n2);
                object2 = ((BigInteger)(object4 = ((BigInteger)object4).add((BigInteger)object3))).add(bigInteger);
                BigInteger bigInteger6 = ((BigInteger)object2).subtract(((BigInteger)(object = (Object)((BigInteger)object2).mod(TWO.multiply(bigInteger5)))).subtract(BigInteger.ONE));
                int n8 = bigInteger6.compareTo(bigInteger);
                if (n8 >= 0 && bigInteger6.isProbablePrime(80)) {
                    this.setParameters(bigInteger6, bigInteger5, this.generate_g(bigInteger6, bigInteger5));
                    return;
                }
                object5 = ((BigInteger)object5).add((BigInteger)object5);
                object5 = ((BigInteger)object5).add(BigInteger.valueOf(n2));
                object5 = ((BigInteger)object5).add(BigInteger.ONE);
            } while (++n4 != 4096);
        }
    }
}

