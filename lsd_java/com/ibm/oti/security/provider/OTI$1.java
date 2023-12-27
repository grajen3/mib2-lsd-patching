/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.OTI;
import java.security.PrivilegedAction;

final class OTI$1
implements PrivilegedAction {
    final /* synthetic */ OTI this$0;

    OTI$1(OTI oTI) {
        this.this$0 = oTI;
    }

    @Override
    public Object run() {
        this.this$0.put("MessageDigest.SHA-1", "com.ibm.oti.security.provider.MessageDigestSHA");
        this.this$0.put("Alg.Alias.MessageDigest.SHA", "SHA-1");
        this.this$0.put("Alg.Alias.MessageDigest.SHA1", "SHA-1");
        this.this$0.put("Alg.Alias.MessageDigest.OID.1.3.14.3.2.26", "SHA-1");
        this.this$0.put("Alg.Alias.MessageDigest.1.3.14.3.2.26", "SHA-1");
        this.this$0.put("MessageDigest.MD5", "com.ibm.oti.security.provider.MessageDigestMD5");
        this.this$0.put("Alg.Alias.MessageDigest.1.2.840.113549.2.5", "MD5");
        this.this$0.put("Alg.Alias.MessageDigest.OID.1.2.840.113549.2.5", "MD5");
        this.this$0.put("SecureRandom.SHA1PRNG", "com.ibm.oti.security.provider.SecureRandomSHA1PRNG");
        this.this$0.put("AlgorithmParameterGenerator.DSA", "com.ibm.oti.security.provider.AlgorithmParameterGeneratorDSA");
        this.this$0.put("AlgorithmParameters.DSA", "com.ibm.oti.security.provider.AlgorithmParametersDSA");
        this.this$0.put("Alg.Alias.AlgorithmParameters.1.2.840.10040.4.1", "DSA");
        this.this$0.put("Alg.Alias.AlgorithmParameters.1.3.14.3.2.12", "DSA");
        this.this$0.put("KeyPairGenerator.DSA", "com.ibm.oti.security.provider.KeyPairGeneratorDSA");
        this.this$0.put("Alg.Alias.KeyPairGenerator.OID.1.2.840.10040.4.1", "DSA");
        this.this$0.put("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1", "DSA");
        this.this$0.put("Alg.Alias.KeyPairGenerator.1.3.14.3.2.12", "DSA");
        this.this$0.put("KeyFactory.DSA", "com.ibm.oti.security.provider.KeyFactoryDSA");
        this.this$0.put("Alg.Alias.KeyFactory.1.2.840.10040.4.1", "DSA");
        this.this$0.put("Alg.Alias.KeyFactory.1.3.14.3.2.12", "DSA");
        this.this$0.put("Signature.SHA1withDSA", "com.ibm.oti.security.provider.SignatureDSA");
        this.this$0.put("Alg.Alias.Signature.DSA", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.DSS", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.SHA/DSA", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.SHA1/DSA", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.SHA-1/DSA", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.SHAwithDSA", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.DSAwithSHA1", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.DSAWithSHA1", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.SHA-1withDSA", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.2.840.10040.4.3", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.1.2.840.10040.4.3", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.13", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.27", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.13", "SHA1withDSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.27", "SHA1withDSA");
        this.this$0.put("KeyStore.JKS", "com.ibm.oti.security.provider.KeyStore");
        this.this$0.put("CertificateFactory.X509", "com.ibm.oti.security.provider.CertificateFactoryX509");
        this.this$0.put("Alg.Alias.CertificateFactory.X.509", "X509");
        this.this$0.put("KeyPairGenerator.RSA", "com.ibm.oti.security.provider.KeyPairGeneratorRSA");
        this.this$0.put("KeyFactory.RSA", "com.ibm.oti.security.provider.KeyFactoryRSA");
        this.this$0.put("Alg.Alias.KeyFactory.1.3.14.3.2.11", "RSA");
        this.this$0.put("Signature.MD2withRSA", "com.ibm.oti.security.provider.SignatureMD2withRSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.24", "MD2withRSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.24", "MD2withRSA");
        this.this$0.put("Signature.MD5withRSA", "com.ibm.oti.security.provider.SignatureMD5withRSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.3", "MD5withRSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.3", "MD5withRSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.25", "MD5withRSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.25", "MD5withRSA");
        this.this$0.put("Signature.SHA1withRSA", "com.ibm.oti.security.provider.SignatureSHA1withRSA");
        this.this$0.put("Alg.Alias.Signature.SHAwithRSA", "SHA1withRSA");
        this.this$0.put("Alg.Alias.Signature.SHA-1withRSA", "SHA1withRSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.15", "SHA1withRSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.15", "SHA1withRSA");
        this.this$0.put("Alg.Alias.Signature.1.3.14.3.2.29", "SHA1withRSA");
        this.this$0.put("Alg.Alias.Signature.OID.1.3.14.3.2.29", "SHA1withRSA");
        return null;
    }
}

