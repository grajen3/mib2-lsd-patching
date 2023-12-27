/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.DSAPrivateKey;
import com.ibm.oti.security.provider.DSAPublicKey;
import com.ibm.oti.util.ASN1Exception;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyFactoryDSA
extends KeyFactorySpi {
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    static /* synthetic */ Class class$3;

    @Override
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof DSAPrivateKeySpec) {
            DSAPrivateKeySpec dSAPrivateKeySpec = (DSAPrivateKeySpec)keySpec;
            BigInteger bigInteger = dSAPrivateKeySpec.getP();
            BigInteger bigInteger2 = dSAPrivateKeySpec.getQ();
            BigInteger bigInteger3 = dSAPrivateKeySpec.getG();
            BigInteger bigInteger4 = dSAPrivateKeySpec.getX();
            return new DSAPrivateKey(new DSAParameterSpec(bigInteger, bigInteger2, bigInteger3), bigInteger4);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = (PKCS8EncodedKeySpec)keySpec;
            byte[] byArray = pKCS8EncodedKeySpec.getEncoded();
            try {
                BigInteger[] bigIntegerArray = DSAPrivateKey.decodePKCS8(byArray);
                return new DSAPrivateKey(new DSAParameterSpec(bigIntegerArray[0], bigIntegerArray[1], bigIntegerArray[2]), bigIntegerArray[3]);
            }
            catch (ASN1Exception aSN1Exception) {
                throw new InvalidKeySpecException();
            }
        }
        throw new InvalidKeySpecException();
    }

    @Override
    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof DSAPublicKeySpec) {
            DSAPublicKeySpec dSAPublicKeySpec = (DSAPublicKeySpec)keySpec;
            BigInteger bigInteger = dSAPublicKeySpec.getP();
            BigInteger bigInteger2 = dSAPublicKeySpec.getQ();
            BigInteger bigInteger3 = dSAPublicKeySpec.getG();
            BigInteger bigInteger4 = dSAPublicKeySpec.getY();
            return new DSAPublicKey(new DSAParameterSpec(bigInteger, bigInteger2, bigInteger3), bigInteger4);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            X509EncodedKeySpec x509EncodedKeySpec = (X509EncodedKeySpec)keySpec;
            byte[] byArray = x509EncodedKeySpec.getEncoded();
            try {
                Object[] objectArray = DSAPublicKey.decodeX509(byArray);
                return new DSAPublicKey((DSAParameterSpec)objectArray[0], (BigInteger)objectArray[1]);
            }
            catch (ASN1Exception aSN1Exception) {
                throw new InvalidKeySpecException();
            }
        }
        throw new InvalidKeySpecException();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected KeySpec engineGetKeySpec(Key var1_1, Class var2_2) {
        var3_3 = false;
        v0 = KeyFactoryDSA.class$0;
        if (v0 == null) {
            try {
                v0 = KeyFactoryDSA.class$0 = Class.forName("java.security.spec.DSAPrivateKeySpec");
            }
            catch (ClassNotFoundException v1) {
                throw new NoClassDefFoundError(v1.getMessage());
            }
        }
        if (var2_2 == v0) ** GOTO lbl-1000
        v2 = KeyFactoryDSA.class$1;
        if (v2 == null) {
            try {
                v2 = KeyFactoryDSA.class$1 = Class.forName("java.security.spec.PKCS8EncodedKeySpec");
            }
            catch (ClassNotFoundException v3) {
                throw new NoClassDefFoundError(v3.getMessage());
            }
        }
        if (var2_2 == v2) lbl-1000:
        // 2 sources

        {
            var3_3 = true;
        } else {
            v4 = KeyFactoryDSA.class$2;
            if (v4 == null) {
                try {
                    v4 = KeyFactoryDSA.class$2 = Class.forName("java.security.spec.DSAPublicKeySpec");
                }
                catch (ClassNotFoundException v5) {
                    throw new NoClassDefFoundError(v5.getMessage());
                }
            }
            if (var2_2 != v4) {
                v6 = KeyFactoryDSA.class$3;
                if (v6 == null) {
                    try {
                        v6 = KeyFactoryDSA.class$3 = Class.forName("java.security.spec.X509EncodedKeySpec");
                    }
                    catch (ClassNotFoundException v7) {
                        throw new NoClassDefFoundError(v7.getMessage());
                    }
                }
                if (var2_2 != v6) {
                    throw new InvalidKeySpecException();
                }
            }
        }
        var5_4 = var1_1.getFormat();
        if ("PKCS#8".equals(var5_4)) {
            var4_5 = true;
        } else if ("X.509".equals(var5_4)) {
            var4_5 = false;
        } else {
            throw new InvalidKeySpecException();
        }
        if (var3_3 != var4_5) {
            throw new InvalidKeySpecException();
        }
        var6_6 = var1_1.getEncoded();
        try {
            if (var3_3) {
                v8 = KeyFactoryDSA.class$1;
                if (v8 == null) {
                    try {
                        v8 = KeyFactoryDSA.class$1 = Class.forName("java.security.spec.PKCS8EncodedKeySpec");
                    }
                    catch (ClassNotFoundException v9) {
                        throw new NoClassDefFoundError(v9.getMessage());
                    }
                }
                if (var2_2 == v8) {
                    return new PKCS8EncodedKeySpec(var6_6);
                }
                var7_7 = DSAPrivateKey.decodePKCS8(var6_6);
                return new DSAPrivateKeySpec(var7_7[3], var7_7[0], var7_7[1], var7_7[2]);
            }
            v10 = KeyFactoryDSA.class$3;
            if (v10 == null) {
                try {
                    v10 = KeyFactoryDSA.class$3 = Class.forName("java.security.spec.X509EncodedKeySpec");
                }
                catch (ClassNotFoundException v11) {
                    throw new NoClassDefFoundError(v11.getMessage());
                }
            }
            if (var2_2 == v10) {
                return new X509EncodedKeySpec(var6_6);
            }
            var7_8 = DSAPublicKey.decodeX509(var6_6);
            var8_9 = (DSAParameterSpec)var7_8[0];
            return new DSAPublicKeySpec((BigInteger)var7_8[1], var8_9.getP(), var8_9.getQ(), var8_9.getG());
        }
        catch (ASN1Exception v12) {
            throw new InvalidKeySpecException();
        }
    }

    @Override
    protected Key engineTranslateKey(Key key) {
        boolean bl;
        String string = key.getFormat();
        if ("PKCS#8".equals(string)) {
            bl = true;
        } else if ("X.509".equals(string)) {
            bl = false;
        } else {
            throw new InvalidKeyException();
        }
        byte[] byArray = key.getEncoded();
        try {
            if (bl) {
                BigInteger[] bigIntegerArray = DSAPrivateKey.decodePKCS8(byArray);
                return new DSAPrivateKey(new DSAParameterSpec(bigIntegerArray[0], bigIntegerArray[1], bigIntegerArray[2]), bigIntegerArray[3]);
            }
            Object[] objectArray = DSAPublicKey.decodeX509(byArray);
            return new DSAPublicKey((DSAParameterSpec)objectArray[0], (BigInteger)objectArray[1]);
        }
        catch (ASN1Exception aSN1Exception) {
            throw new InvalidKeyException();
        }
    }
}

