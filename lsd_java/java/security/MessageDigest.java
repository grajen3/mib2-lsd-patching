/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import java.security.MessageDigest$Wrapper;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

public abstract class MessageDigest
extends MessageDigestSpi {
    private static final String KEY_PREFIX;
    private String algorithmName;
    private Provider provider;

    protected MessageDigest(String string) {
        this.setAlgorithm(string);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public byte[] digest() {
        byte[] byArray = this.engineDigest();
        this.reset();
        return byArray;
    }

    public byte[] digest(byte[] byArray) {
        this.update(byArray);
        return this.digest();
    }

    public int digest(byte[] byArray, int n, int n2) {
        return this.engineDigest(byArray, n, n2);
    }

    public final String getAlgorithm() {
        return this.algorithmName;
    }

    public final int getDigestLength() {
        return this.engineGetDigestLength();
    }

    public static MessageDigest getInstance(String string) {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return MessageDigest.toMessageDigestImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    public static MessageDigest getInstance(String string, String string2) {
        if (string2 == null || string2 == "") {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(string2);
        if (provider == null) {
            throw new NoSuchProviderException(string2);
        }
        return MessageDigest.toMessageDigestImplementation(string, provider);
    }

    public static MessageDigest getInstance(String string, Provider provider) {
        return MessageDigest.toMessageDigestImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public static boolean isEqual(byte[] byArray, byte[] byArray2) {
        return Arrays.equals(byArray, byArray2);
    }

    public void reset() {
        this.engineReset();
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    private static MessageDigest toMessageDigestImplementation(String string, Provider provider) {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (string == null) {
            throw new IllegalArgumentException();
        }
        try {
            String string2 = provider.lookupProperty("MessageDigest.", string);
            if (string2 == null) {
                throw new NoSuchAlgorithmException(string);
            }
            Class clazz = Class.forName(string2, true, super.getClass().getClassLoader());
            MessageDigestSpi messageDigestSpi = (MessageDigestSpi)clazz.newInstance();
            MessageDigest messageDigest = messageDigestSpi instanceof MessageDigest ? (MessageDigest)messageDigestSpi : new MessageDigest$Wrapper(messageDigestSpi, string);
            messageDigest.setProvider(provider);
            return messageDigest;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (ClassCastException classCastException) {}
        throw new NoSuchAlgorithmException(string);
    }

    public String toString() {
        return Msg.getString("K03a3", new String[]{this.getAlgorithm(), this.getProvider().getName()});
    }

    public void update(byte[] byArray) {
        this.engineUpdate(byArray, 0, byArray.length);
    }

    public void update(byte[] byArray, int n, int n2) {
        this.engineUpdate(byArray, n, n2);
    }

    public void update(byte by) {
        this.engineUpdate(by);
    }
}

