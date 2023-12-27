/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

public class AlgorithmParameterGenerator {
    private static final String KEY_PREFIX;
    private String algorithmName;
    private Provider provider;
    private AlgorithmParameterGeneratorSpi algorithmParameterGeneratorSpi;

    protected AlgorithmParameterGenerator(AlgorithmParameterGeneratorSpi algorithmParameterGeneratorSpi, Provider provider, String string) {
        this.setProvider(provider);
        this.setAlgorithm(string);
        this.algorithmParameterGeneratorSpi = algorithmParameterGeneratorSpi;
    }

    private static AlgorithmParameterGenerator createAlgorithmParameterGenerator(Provider provider, Class clazz, String string) {
        try {
            AlgorithmParameterGeneratorSpi algorithmParameterGeneratorSpi = (AlgorithmParameterGeneratorSpi)clazz.newInstance();
            return new AlgorithmParameterGenerator(algorithmParameterGeneratorSpi, provider, string);
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        throw new NoSuchAlgorithmException(string);
    }

    public final AlgorithmParameters generateParameters() {
        return this.algorithmParameterGeneratorSpi.engineGenerateParameters();
    }

    public final String getAlgorithm() {
        return this.algorithmName;
    }

    public static AlgorithmParameterGenerator getInstance(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return AlgorithmParameterGenerator.toAlgorithmParameterGeneratorImplementation(string);
    }

    public static AlgorithmParameterGenerator getInstance(String string, String string2) {
        if (string2 == null || string == null) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(string2);
        if (provider == null) {
            throw new NoSuchProviderException(string2);
        }
        return AlgorithmParameterGenerator.toAlgorithmParameterGeneratorImplementation(string, provider);
    }

    public static AlgorithmParameterGenerator getInstance(String string, Provider provider) {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return AlgorithmParameterGenerator.toAlgorithmParameterGeneratorImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(int n) {
        this.algorithmParameterGeneratorSpi.engineInit(n, new SecureRandom());
    }

    public final void init(int n, SecureRandom secureRandom) {
        this.algorithmParameterGeneratorSpi.engineInit(n, secureRandom);
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec) {
        this.algorithmParameterGeneratorSpi.engineInit(algorithmParameterSpec, new SecureRandom());
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.algorithmParameterGeneratorSpi.engineInit(algorithmParameterSpec, secureRandom);
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    private static AlgorithmParameterGenerator toAlgorithmParameterGeneratorImplementation(String string) {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return AlgorithmParameterGenerator.toAlgorithmParameterGeneratorImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static AlgorithmParameterGenerator toAlgorithmParameterGeneratorImplementation(String string, Provider provider) {
        String string2;
        try {
            string2 = provider.lookupProperty("AlgorithmParameterGenerator.", string);
        }
        catch (ClassCastException classCastException) {
            throw new NoSuchAlgorithmException(string);
        }
        if (string2 == null) {
            throw new NoSuchAlgorithmException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, super.getClass().getClassLoader());
            return AlgorithmParameterGenerator.createAlgorithmParameterGenerator(provider, clazz, string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoSuchAlgorithmException(string);
        }
    }
}

