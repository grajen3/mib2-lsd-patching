/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.RSAPrivateCrtKey;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyFactoryRSA
extends KeyFactorySpi {
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    static /* synthetic */ Class class$3;
    static /* synthetic */ Class class$4;

    @Override
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof RSAPrivateCrtKeySpec) {
            return new RSAPrivateCrtKey((RSAPrivateCrtKeySpec)keySpec);
        }
        if (keySpec instanceof RSAPrivateKeySpec) {
            return new RSAPrivateKey((RSAPrivateKeySpec)keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            return new RSAPrivateCrtKey((PKCS8EncodedKeySpec)keySpec);
        }
        throw new InvalidKeySpecException();
    }

    @Override
    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof RSAPublicKeySpec) {
            return new RSAPublicKey((RSAPublicKeySpec)keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            return new RSAPublicKey((X509EncodedKeySpec)keySpec);
        }
        throw new InvalidKeySpecException();
    }

    @Override
    protected KeySpec engineGetKeySpec(Key key, Class clazz) {
        block44: {
            block41: {
                block43: {
                    block42: {
                        if (!(key instanceof RSAPrivateCrtKey)) break block41;
                        Class clazz2 = class$0;
                        if (clazz2 == null) {
                            try {
                                clazz2 = class$0 = Class.forName("java.security.spec.RSAPrivateKeySpec");
                            }
                            catch (ClassNotFoundException classNotFoundException) {
                                throw new NoClassDefFoundError(classNotFoundException.getMessage());
                            }
                        }
                        if (clazz.equals(clazz2)) break block42;
                        Class clazz3 = class$1;
                        if (clazz3 == null) {
                            try {
                                clazz3 = class$1 = Class.forName("java.security.spec.RSAPrivateCrtKeySpec");
                            }
                            catch (ClassNotFoundException classNotFoundException) {
                                throw new NoClassDefFoundError(classNotFoundException.getMessage());
                            }
                        }
                        if (!clazz.equals(clazz3)) break block43;
                    }
                    return ((RSAPrivateCrtKey)key).toKeySpec();
                }
                Class clazz4 = class$2;
                if (clazz4 == null) {
                    try {
                        clazz4 = class$2 = Class.forName("java.security.spec.PKCS8EncodedKeySpec");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                if (clazz.equals(clazz4)) {
                    return new PKCS8EncodedKeySpec(((RSAPrivateCrtKey)key).getEncoded());
                }
                break block44;
            }
            if (key instanceof RSAPrivateKey) {
                Class clazz5 = class$0;
                if (clazz5 == null) {
                    try {
                        clazz5 = class$0 = Class.forName("java.security.spec.RSAPrivateKeySpec");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                if (clazz.equals(clazz5)) {
                    return ((RSAPrivateKey)key).toKeySpec();
                }
                Class clazz6 = class$2;
                if (clazz6 == null) {
                    try {
                        clazz6 = class$2 = Class.forName("java.security.spec.PKCS8EncodedKeySpec");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                if (clazz.equals(clazz6)) {
                    return new PKCS8EncodedKeySpec(((RSAPrivateKey)key).getEncoded());
                }
            } else if (key instanceof RSAPublicKey) {
                Class clazz7 = class$3;
                if (clazz7 == null) {
                    try {
                        clazz7 = class$3 = Class.forName("java.security.spec.RSAPublicKeySpec");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                if (clazz.equals(clazz7)) {
                    return ((RSAPublicKey)key).toKeySpec();
                }
                Class clazz8 = class$4;
                if (clazz8 == null) {
                    try {
                        clazz8 = class$4 = Class.forName("java.security.spec.X509EncodedKeySpec");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                if (clazz.equals(clazz8)) {
                    return new X509EncodedKeySpec(((RSAPublicKey)key).getEncoded());
                }
            }
        }
        throw new InvalidKeySpecException();
    }

    @Override
    protected Key engineTranslateKey(Key key) {
        if (key instanceof java.security.interfaces.RSAPrivateKey) {
            return new RSAPrivateKey((java.security.interfaces.RSAPrivateKey)key);
        }
        if (key instanceof java.security.interfaces.RSAPrivateCrtKey) {
            return new RSAPrivateCrtKey((java.security.interfaces.RSAPrivateCrtKey)key);
        }
        if (key instanceof java.security.interfaces.RSAPublicKey) {
            return new RSAPublicKey((java.security.interfaces.RSAPublicKey)key);
        }
        throw new InvalidKeyException();
    }
}

