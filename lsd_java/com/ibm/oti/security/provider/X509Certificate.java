/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.X509CertImpl;
import com.ibm.oti.util.ASN1Decoder$Node;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public class X509Certificate
extends java.security.cert.X509Certificate {
    private final X509CertImpl impl;
    static final String extendedKeyUsageOID;
    static final String issuerAltNamesOID;
    static final String subjectAltNamesOID;
    public static final Hashtable OID_DATABASE;
    private static final String OID_BasicConstraints;
    private static final String OID_KeyUsage;
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS;

    static {
        OID_DATABASE = new Hashtable(5);
        OID_DATABASE.put("1.2.840.113549.1.1.2", "MD2withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.4", "MD5withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.5", "SHA1withRSA");
        OID_DATABASE.put("1.2.840.10040.4.3", "SHA1withDSA");
        OID_DATABASE.put("1.3.14.3.2.26", "SHA");
        OID_DATABASE.put("1.2.840.113549.2.5", "MD5");
        OID_DATABASE.put("1.2.840.113549.2.2", "MD2");
        OID_DATABASE.put("1.2.840.113549.1.1.1", "RSA");
        OID_DATABASE.put("1.2.840.10040.4.1", "DSA");
        OID_DATABASE.put("1.3.14.3.2.12", "DSA");
        OID_DATABASE.put("1.2.840.10046.2.1", "DiffieHellman");
        SUPPORTED_CRITICAL_EXTENSIONS = new String[]{"2.5.29.19", "2.5.29.15"};
    }

    public X509Certificate(X509CertImpl x509CertImpl) {
        this.impl = x509CertImpl;
    }

    @Override
    public void checkValidity() {
        this.impl.checkValidity(new Date());
    }

    @Override
    public void checkValidity(Date date) {
        this.impl.checkValidity(date);
    }

    @Override
    public int getBasicConstraints() {
        return this.impl.getBasicConstraints();
    }

    @Override
    public Principal getIssuerDN() {
        return this.impl.getIssuerDN();
    }

    @Override
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.impl.getIssuerDN().getName());
    }

    @Override
    public boolean[] getIssuerUniqueID() {
        return this.impl.getIssuerUniqueID();
    }

    @Override
    public boolean[] getKeyUsage() {
        return this.impl.getKeyUsage();
    }

    @Override
    public Date getNotAfter() {
        return this.impl.getNotAfter();
    }

    @Override
    public Date getNotBefore() {
        return this.impl.getNotBefore();
    }

    @Override
    public BigInteger getSerialNumber() {
        return this.impl.getSerialNumber();
    }

    @Override
    public String getSigAlgName() {
        return this.impl.getSigAlgName();
    }

    @Override
    public String getSigAlgOID() {
        return this.impl.getSigAlgOID();
    }

    @Override
    public byte[] getSigAlgParams() {
        return this.impl.getSigAlgParams();
    }

    @Override
    public byte[] getSignature() {
        return this.impl.getSignature();
    }

    @Override
    public Principal getSubjectDN() {
        return this.impl.getSubjectDN();
    }

    @Override
    public X500Principal getSubjectX500Principal() {
        return new X500Principal(this.impl.getSubjectDN().getName());
    }

    @Override
    public boolean[] getSubjectUniqueID() {
        return this.impl.getSubjectUniqueID();
    }

    @Override
    public byte[] getTBSCertificate() {
        return this.impl.getTBSCertificate();
    }

    @Override
    public int getVersion() {
        return this.impl.getVersion();
    }

    @Override
    public boolean hasUnsupportedCriticalExtension() {
        return this.impl.hasUnsupportedCriticalExtension();
    }

    @Override
    public Set getCriticalExtensionOIDs() {
        return this.impl.getCriticalExtensionOIDs();
    }

    @Override
    public Set getNonCriticalExtensionOIDs() {
        return this.impl.getNonCriticalExtensionOIDs();
    }

    @Override
    public byte[] getExtensionValue(String string) {
        return this.impl.getExtensionValue(string);
    }

    @Override
    public List getExtendedKeyUsage() {
        return this.impl.getExtendedKeyUsage();
    }

    @Override
    public byte[] getEncoded() {
        return this.impl.getEncoded();
    }

    @Override
    public PublicKey getPublicKey() {
        return this.impl.getPublicKey();
    }

    @Override
    public void verify(PublicKey publicKey) {
        this.impl.verify(publicKey);
    }

    @Override
    public void verify(PublicKey publicKey, String string) {
        this.impl.verify(publicKey, string);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 Certificate v");
        stringBuffer.append(this.getVersion());
        stringBuffer.append("\nSubjectDN: ");
        stringBuffer.append(this.getSubjectDN());
        stringBuffer.append("\n\tNot Before: ");
        stringBuffer.append(this.getNotBefore());
        stringBuffer.append("\n\tNot After: ");
        stringBuffer.append(this.getNotAfter());
        stringBuffer.append("\nIssuerDN: ");
        stringBuffer.append(this.getIssuerDN());
        stringBuffer.append("\nSerialNumber: ");
        stringBuffer.append(this.getSerialNumber().toString(16));
        stringBuffer.append("\nSigAlgName: ");
        stringBuffer.append(this.getSigAlgName());
        stringBuffer.append(", SigAlgOID: ");
        stringBuffer.append(this.getSigAlgOID());
        return stringBuffer.toString();
    }

    static String getAlias(String string, String string2, String[] stringArray) {
        return X509CertImpl.getAlias(string, string2, stringArray);
    }

    public static X509Certificate certificateFromASN1Object(byte[] byArray) {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(byArray);
        return new X509Certificate(x509CertImpl);
    }

    public static X509Certificate certificateFromASN1Object(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray) {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(aSN1Decoder$Node, byArray);
        return new X509Certificate(x509CertImpl);
    }

    public static X509Certificate certificateFromASN1Object(InputStream inputStream) {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(inputStream);
        return new X509Certificate(x509CertImpl);
    }

    public static Certificate certificateFromData(PublicKey publicKey, String string, Date date, Date date2) {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromData(publicKey, string, date, date2);
        return new X509Certificate(x509CertImpl);
    }

    public byte[] getSignedAndEncoded(String string, PrivateKey privateKey) {
        return this.impl.getSignedAndEncoded(string, privateKey);
    }

    @Override
    public Collection getSubjectAlternativeNames() {
        return this.impl.getSubjectAlternativeNames();
    }

    @Override
    public Collection getIssuerAlternativeNames() {
        return this.impl.getIssuerAlternativeNames();
    }

    public void setIssuerDN(Principal principal) {
        this.impl.setIssuerDN(principal);
    }

    public void setSubjectDN(Principal principal) {
        this.impl.setSubjectDN(principal);
    }
}

