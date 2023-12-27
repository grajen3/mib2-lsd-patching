/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.CertificateVerifierSecurity$1;
import com.ibm.oti.security.provider.Util;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.util.PriviAction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

public class CertificateVerifierSecurity {
    public static void verifyCertificateChain(X509Certificate[] x509CertificateArray, Date date) {
        KeyStore keyStore = CertificateVerifierSecurity.getSystemKeyStore();
        CertificateVerifierSecurity.verifyCertificateChain(keyStore, x509CertificateArray, date);
    }

    private static KeyStore getSystemKeyStore() {
        KeyStore keyStore = null;
        String string = CertificateVerifierSecurity.getCACertsPath();
        InputStream inputStream = null;
        try {
            try {
                inputStream = CertificateVerifierSecurity.getInputStreamForFile(string);
                keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(inputStream, null);
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new IOException(new StringBuffer("File not found: ").append(string).toString());
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                throw new IOException(new StringBuffer("Necessary cryptographic algorithm not available: ").append(noSuchAlgorithmException.getMessage()).toString());
            }
            catch (CertificateException certificateException) {
                throw new IOException(new StringBuffer("Certificate problem: ").append(certificateException.getMessage()).toString());
            }
            catch (KeyStoreException keyStoreException) {
                throw new CertificateException("Cannot get KeyStore implementation");
            }
        }
        catch (Throwable throwable) {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (IOException iOException) {}
        return keyStore;
    }

    private static InputStream getInputStreamForFile(String string) {
        if (string == null) {
            return null;
        }
        InputStream inputStream = (InputStream)AccessController.doPrivileged(new CertificateVerifierSecurity$1(string));
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        return inputStream;
    }

    public static void verifyCertificateChain(KeyStore keyStore, X509Certificate[] x509CertificateArray, Date date) {
        Object object;
        Certificate certificate;
        int n;
        PublicKey publicKey = null;
        X500Principal x500Principal = CertificateVerifierSecurity.getSubject(x509CertificateArray[x509CertificateArray.length - 1]);
        if (x500Principal.equals(CertificateVerifierSecurity.getIssuer(x509CertificateArray[x509CertificateArray.length - 1]))) {
            n = x509CertificateArray.length - 1;
            certificate = CertificateVerifierSecurity.getCertFromKeyStore(keyStore, x509CertificateArray[x509CertificateArray.length - 1]);
            if (certificate == null) {
                throw new CertificateException("certificate chain root is not a trusted Certificate Authority");
            }
            publicKey = certificate.getPublicKey();
            byte[] byArray = publicKey.getEncoded();
            if (!Util.equals(byArray, (byte[])(object = x509CertificateArray[x509CertificateArray.length - 1].getPublicKey().getEncoded()))) {
                throw new CertificateException(new StringBuffer("root certificate public key does not match certificate public key on device for \"").append(x500Principal).append("\"").toString());
            }
        } else {
            n = x509CertificateArray.length;
            x500Principal = CertificateVerifierSecurity.getIssuer(x509CertificateArray[x509CertificateArray.length - 1]);
            certificate = CertificateVerifierSecurity.getCertFromKeyStore(keyStore, x500Principal);
            if (certificate == null) {
                throw new CertificateException("Internal error");
            }
            publicKey = certificate.getPublicKey();
        }
        if (!(certificate instanceof X509Certificate)) {
            throw new CertificateException("Root certificate not an X509 Certificate");
        }
        ((X509Certificate)certificate).checkValidity(date);
        int n2 = 0;
        while (n2 < n) {
            PublicKey publicKey2;
            if (n2 < n - 1) {
                publicKey2 = x509CertificateArray[n2 + 1].getPublicKey();
                object = CertificateVerifierSecurity.getSubject(x509CertificateArray[n2 + 1]);
            } else {
                publicKey2 = publicKey;
                object = x500Principal;
            }
            if (!((X500Principal)object).equals(CertificateVerifierSecurity.getIssuer(x509CertificateArray[n2]))) {
                throw new CertificateException(new StringBuffer("issuer of certificate not in chain: ").append(((X500Principal)object).toString()).toString());
            }
            CertificateVerifierSecurity.verifyCertificateSignature(publicKey2, x509CertificateArray[n2]);
            x509CertificateArray[n2].checkValidity(date);
            ++n2;
        }
    }

    private static Certificate getCertFromKeyStore(KeyStore keyStore, Certificate certificate) {
        try {
            if (keyStore == null || certificate == null) {
                return null;
            }
            String string = keyStore.getCertificateAlias(certificate);
            if (string == null) {
                return null;
            }
            return keyStore.getCertificate(string);
        }
        catch (KeyStoreException keyStoreException) {
            throw new CertificateException("Cannot find certificate in keystore");
        }
    }

    private static Certificate getCertFromKeyStore(KeyStore keyStore, X500Principal x500Principal) {
        if (keyStore == null || x500Principal == null) {
            return null;
        }
        try {
            Enumeration enumeration = keyStore.aliases();
            while (enumeration.hasMoreElements()) {
                String string = (String)enumeration.nextElement();
                X509Certificate x509Certificate = (X509Certificate)keyStore.getCertificate(string);
                X500Principal x500Principal2 = new X500Principal(x509Certificate.getSubjectDN().getName());
                if (!x500Principal2.equals(x500Principal)) continue;
                return x509Certificate;
            }
        }
        catch (KeyStoreException keyStoreException) {
            keyStoreException.printStackTrace();
            return null;
        }
        return null;
    }

    private static String getCACertsPath() {
        String string = null;
        String string2 = (String)AccessController.doPrivileged(new PriviAction("file.separator"));
        StringBuffer stringBuffer = new StringBuffer((String)AccessController.doPrivileged(new PriviAction("java.home")));
        stringBuffer.append(string2);
        stringBuffer.append("lib");
        stringBuffer.append(string2);
        stringBuffer.append("security");
        stringBuffer.append(string2);
        stringBuffer.append("cacerts");
        string = stringBuffer.toString();
        return string;
    }

    private static X500Principal getSubject(X509Certificate x509Certificate) {
        X500Principal x500Principal = new X500Principal(x509Certificate.getSubjectDN().getName());
        return x500Principal;
    }

    private static X500Principal getIssuer(X509Certificate x509Certificate) {
        X500Principal x500Principal = new X500Principal(x509Certificate.getIssuerDN().getName());
        return x500Principal;
    }

    private static void verifyCertificateSignature(PublicKey publicKey, X509Certificate x509Certificate) {
        try {
            x509Certificate.verify(publicKey);
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new CertificateException(new StringBuffer("error in signature for certificate \"").append(x509Certificate.getSubjectDN().getName()).append("\": ").append(invalidKeyException.getMessage()).toString());
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new CertificateException(new StringBuffer("algorithm not supported for certificate \"").append(x509Certificate.getSubjectDN().getName()).append("\": ").append(noSuchAlgorithmException.getMessage()).toString());
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new CertificateException(new StringBuffer("algorithm not supported for certificate \"").append(x509Certificate.getSubjectDN().getName()).append("\": ").append(noSuchProviderException.getMessage()).toString());
        }
        catch (SignatureException signatureException) {
            throw new CertificateException(new StringBuffer("error in signature for certificate \"").append(x509Certificate.getSubjectDN().getName()).append("\": ").append(signatureException.getMessage()).toString());
        }
    }
}

