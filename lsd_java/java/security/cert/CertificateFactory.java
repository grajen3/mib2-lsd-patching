/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import com.ibm.oti.util.Msg;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class CertificateFactory {
    private static final String KEY_PREFIX;
    private String type;
    private Provider provider;
    private CertificateFactorySpi certificateFactorySpi;

    protected CertificateFactory(CertificateFactorySpi certificateFactorySpi, Provider provider, String string) {
        this.setProvider(provider);
        this.setType(string);
        this.certificateFactorySpi = certificateFactorySpi;
    }

    private static CertificateFactory createCertificateFactory(Provider provider, Class clazz, String string) {
        try {
            CertificateFactorySpi certificateFactorySpi = (CertificateFactorySpi)clazz.newInstance();
            return new CertificateFactory(certificateFactorySpi, provider, string);
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        throw new CertificateException(string);
    }

    public final Certificate generateCertificate(InputStream inputStream) {
        if (inputStream == null) {
            throw new CertificateException(Msg.getString("K00a5", "null"));
        }
        return this.certificateFactorySpi.engineGenerateCertificate(inputStream);
    }

    public final Collection generateCertificates(InputStream inputStream) {
        if (inputStream == null) {
            throw new CertificateException(Msg.getString("K00a5", "null"));
        }
        return this.certificateFactorySpi.engineGenerateCertificates(inputStream);
    }

    public final CRL generateCRL(InputStream inputStream) {
        if (inputStream == null) {
            throw new CRLException(Msg.getString("K00a5", "null"));
        }
        return this.certificateFactorySpi.engineGenerateCRL(inputStream);
    }

    public final CertPath generateCertPath(InputStream inputStream) {
        if (inputStream == null) {
            throw new CertificateException(Msg.getString("K00a5", "null"));
        }
        return this.certificateFactorySpi.engineGenerateCertPath(inputStream);
    }

    public final CertPath generateCertPath(InputStream inputStream, String string) {
        if (inputStream == null) {
            throw new CertificateException(Msg.getString("K00a5", "null"));
        }
        if (string == null) {
            throw new CertificateException(Msg.getString("K00a5", string));
        }
        inputStream = new BufferedInputStream(inputStream);
        return this.certificateFactorySpi.engineGenerateCertPath(inputStream, string);
    }

    public final CertPath generateCertPath(List list) {
        if (list == null) {
            throw new CertificateException(Msg.getString("K00a5", "null"));
        }
        return this.certificateFactorySpi.engineGenerateCertPath(list);
    }

    public final Iterator getCertPathEncodings() {
        return this.certificateFactorySpi.engineGetCertPathEncodings();
    }

    public final Collection generateCRLs(InputStream inputStream) {
        if (inputStream == null) {
            throw new CRLException(Msg.getString("K00a5", "null"));
        }
        return this.certificateFactorySpi.engineGenerateCRLs(inputStream);
    }

    public static final CertificateFactory getInstance(String string) {
        if (string == null) {
            throw new CertificateException(Msg.getString("K0337"));
        }
        return CertificateFactory.toCertificateFactoryImplementation(string);
    }

    public static final CertificateFactory getInstance(String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException();
        }
        if (string == null) {
            throw new CertificateException(Msg.getString("K0337"));
        }
        Provider provider = Security.getProvider(string2);
        if (provider == null) {
            throw new NoSuchProviderException(string2);
        }
        return CertificateFactory.toCertificateFactoryImplementation(string, provider);
    }

    public static final CertificateFactory getInstance(String string, Provider provider) {
        if (string == null) {
            throw new CertificateException(Msg.getString("K0337"));
        }
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        return CertificateFactory.toCertificateFactoryImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    void setType(String string) {
        this.type = string;
    }

    private static CertificateFactory toCertificateFactoryImplementation(String string) {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return CertificateFactory.toCertificateFactoryImplementation(string, provider);
            }
            catch (CertificateException certificateException) {
                ++n;
            }
        }
        throw new CertificateException(string);
    }

    private static CertificateFactory toCertificateFactoryImplementation(String string, Provider provider) {
        String string2;
        try {
            string2 = CertificateFactory.lookupProperty(provider, "CertificateFactory.", string);
        }
        catch (ClassCastException classCastException) {
            throw new CertificateException(string);
        }
        if (string2 == null) {
            throw new CertificateException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, super.getClass().getClassLoader());
            return CertificateFactory.createCertificateFactory(provider, clazz, string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new CertificateException(string);
        }
    }

    private static String lookupProperty(Provider provider, String string) {
        String string2 = provider.getProperty(string);
        if (string2 != null) {
            return string2;
        }
        String string3 = string.toUpperCase();
        Enumeration enumeration = provider.keys();
        while (enumeration.hasMoreElements()) {
            String string4 = (String)enumeration.nextElement();
            if (!string4.toUpperCase().equals(string3)) continue;
            return provider.getProperty(string4);
        }
        return null;
    }

    private static String lookupProperty(Provider provider, String string, String string2) {
        String string3 = new StringBuffer(String.valueOf(string)).append(string2).toString();
        String string4 = CertificateFactory.lookupProperty(provider, string3);
        if (string4 != null) {
            return string4;
        }
        string4 = CertificateFactory.lookupProperty(provider, new StringBuffer("Alg.Alias.").append(string3).toString());
        if (string4 != null) {
            return provider.getProperty(new StringBuffer(String.valueOf(string)).append(string4).toString());
        }
        return null;
    }
}

