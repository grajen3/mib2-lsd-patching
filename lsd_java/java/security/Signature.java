/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature$Wrapper;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Set;

public abstract class Signature
extends SignatureSpi {
    protected static final int UNINITIALIZED;
    protected static final int SIGN;
    protected static final int VERIFY;
    protected int state;
    private static final String[] STATE_DESCRIPTION;
    private static final String KEY_PREFIX;
    private String algorithmName;
    private Provider provider;

    static {
        STATE_DESCRIPTION = new String[]{"UNINITIALIZED", "SIGN", "VERIFY"};
    }

    protected Signature(String string) {
        this.setAlgorithm(string);
        this.state = 0;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public final String getAlgorithm() {
        return this.algorithmName;
    }

    public static Signature getInstance(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return Signature.toSignatureImplementation(string);
    }

    public static Signature getInstance(String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException();
        }
        if (string == null) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(string2);
        if (provider == null) {
            throw new NoSuchProviderException(string2);
        }
        return Signature.toSignatureImplementation(string, provider);
    }

    public static Signature getInstance(String string, Provider provider) {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return Signature.toSignatureImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void initSign(PrivateKey privateKey) {
        this.state = 2;
        this.engineInitSign(privateKey);
    }

    public final void initSign(PrivateKey privateKey, SecureRandom secureRandom) {
        this.state = 2;
        this.engineInitSign(privateKey, secureRandom);
    }

    public final void initVerify(PublicKey publicKey) {
        this.state = 3;
        this.engineInitVerify(publicKey);
    }

    public final void initVerify(Certificate certificate) {
        boolean[] blArray;
        X509Certificate x509Certificate;
        Set set;
        this.state = 3;
        if (certificate instanceof X509Certificate && (set = (x509Certificate = (X509Certificate)certificate).getCriticalExtensionOIDs()) != null && !set.isEmpty() && set.contains("2.5.29.15") && !(blArray = x509Certificate.getKeyUsage())[0]) {
            throw new InvalidKeyException(Msg.getString("K00e4"));
        }
        this.engineInitVerify(certificate.getPublicKey());
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    public final void setParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        this.engineSetParameter(algorithmParameterSpec);
    }

    public final AlgorithmParameters getParameters() {
        return this.engineGetParameters();
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    public final byte[] sign() {
        if (this.state != 2) {
            throw new SignatureException();
        }
        return this.engineSign();
    }

    public final int sign(byte[] byArray, int n, int n2) {
        if (this.state != 2) {
            throw new SignatureException();
        }
        return this.engineSign(byArray, n, n2);
    }

    private static Signature toSignatureImplementation(String string) {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return Signature.toSignatureImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static Signature toSignatureImplementation(String string, Provider provider) {
        String string2;
        try {
            string2 = provider.lookupProperty("Signature.", string);
        }
        catch (ClassCastException classCastException) {
            throw new NoSuchAlgorithmException(string);
        }
        if (string2 == null) {
            throw new NoSuchAlgorithmException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, super.getClass().getClassLoader());
            SignatureSpi signatureSpi = (SignatureSpi)clazz.newInstance();
            Signature signature = signatureSpi instanceof Signature ? (Signature)signatureSpi : new Signature$Wrapper(signatureSpi, string);
            signature.setProvider(provider);
            return signature;
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
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.getAlgorithm());
        stringBuffer.append(" Signature (");
        stringBuffer.append(STATE_DESCRIPTION[this.state]);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public final void update(byte[] byArray) {
        if (this.state == 0) {
            throw new SignatureException();
        }
        this.engineUpdate(byArray, 0, byArray.length);
    }

    public final void update(byte[] byArray, int n, int n2) {
        if (this.state == 0) {
            throw new SignatureException();
        }
        this.engineUpdate(byArray, n, n2);
    }

    public final void update(byte by) {
        if (this.state == 0) {
            throw new SignatureException();
        }
        this.engineUpdate(by);
    }

    public final boolean verify(byte[] byArray) {
        if (this.state != 3) {
            throw new SignatureException();
        }
        return this.engineVerify(byArray);
    }

    public final boolean verify(byte[] byArray, int n, int n2) {
        if (this.state != 3) {
            throw new SignatureException();
        }
        return this.engineVerify(byArray, n, n2);
    }
}

