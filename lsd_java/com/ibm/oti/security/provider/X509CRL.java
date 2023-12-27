/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509CRL$1;
import com.ibm.oti.security.provider.X509CRLEntry;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.security.provider.X509Extension;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class X509CRL
extends java.security.cert.X509CRL {
    private byte[] encoded;
    private int originalOffsetIntoRawBytes;
    private ASN1Decoder$Node tbsNode;
    private int version;
    private String sigAlgOID;
    private byte[] sigAlgParams;
    private byte[] rawSignature;
    private String signatureName;
    private String signatureProviderName;
    private X500Principal issuer;
    private Date thisUpdate;
    private Date nextUpdate;
    private Hashtable revokedCertificates;
    private Hashtable extensions;
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS = new String[0];

    protected X509CRL() {
    }

    @Override
    public byte[] getEncoded() {
        return this.encoded;
    }

    @Override
    public Principal getIssuerDN() {
        return this.issuer;
    }

    @Override
    public Date getNextUpdate() {
        return this.nextUpdate;
    }

    @Override
    public java.security.cert.X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        if (this.revokedCertificates == null) {
            return null;
        }
        return (java.security.cert.X509CRLEntry)this.revokedCertificates.get(bigInteger);
    }

    @Override
    public Set getRevokedCertificates() {
        if (this.revokedCertificates == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumeration = this.revokedCertificates.elements();
        while (enumeration.hasMoreElements()) {
            hashSet.add(enumeration.nextElement());
        }
        return hashSet;
    }

    @Override
    public String getSigAlgName() {
        return this.signatureName;
    }

    @Override
    public String getSigAlgOID() {
        return this.sigAlgOID;
    }

    @Override
    public byte[] getSigAlgParams() {
        return this.sigAlgParams;
    }

    @Override
    public byte[] getSignature() {
        return this.rawSignature;
    }

    @Override
    public byte[] getTBSCertList() {
        byte[] byArray = new byte[this.tbsNode.endPosition - this.tbsNode.startPosition + 1];
        System.arraycopy((Object)this.encoded, this.tbsNode.startPosition - this.originalOffsetIntoRawBytes, (Object)byArray, 0, byArray.length);
        return byArray;
    }

    @Override
    public Date getThisUpdate() {
        return this.thisUpdate;
    }

    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public void verify(PublicKey publicKey) {
        if (this.signatureProviderName != null) {
            this.verify(publicKey, this.signatureProviderName);
        } else {
            if (this.signatureName == null) {
                throw new NoSuchAlgorithmException(this.sigAlgOID);
            }
            Signature signature = Signature.getInstance(this.signatureName);
            this.verify(publicKey, signature);
        }
    }

    @Override
    public void verify(PublicKey publicKey, String string) {
        if (this.signatureName == null) {
            throw new NoSuchAlgorithmException(this.sigAlgOID);
        }
        Signature signature = Signature.getInstance(this.signatureName, string);
        this.verify(publicKey, signature);
    }

    private void verify(PublicKey publicKey, Signature signature) {
        signature.initVerify(publicKey);
        signature.update(this.getTBSCertList());
        boolean bl = signature.verify(this.getSignature());
        if (!bl) {
            throw new SignatureException();
        }
    }

    @Override
    public boolean isRevoked(Certificate certificate) {
        try {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate)certificate;
            java.security.cert.X509CRLEntry x509CRLEntry = this.getRevokedCertificate(x509Certificate.getSerialNumber());
            return x509CRLEntry != null;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    @Override
    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        if (set == null) {
            return false;
        }
        if (set.size() > SUPPORTED_CRITICAL_EXTENSIONS.length) {
            return true;
        }
        int n = 0;
        while (n < SUPPORTED_CRITICAL_EXTENSIONS.length) {
            set.remove(SUPPORTED_CRITICAL_EXTENSIONS[n]);
            ++n;
        }
        return set.size() != 0;
    }

    private Set getExtensionOIDs(boolean bl) {
        if (this.extensions == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumeration = this.extensions.elements();
        while (enumeration.hasMoreElements()) {
            X509Extension x509Extension = (X509Extension)enumeration.nextElement();
            if (x509Extension.isCritical() != bl) continue;
            hashSet.add(x509Extension.name());
        }
        return hashSet;
    }

    @Override
    public Set getCriticalExtensionOIDs() {
        return this.getExtensionOIDs(true);
    }

    @Override
    public Set getNonCriticalExtensionOIDs() {
        return this.getExtensionOIDs(false);
    }

    @Override
    public byte[] getExtensionValue(String string) {
        if (this.extensions == null) {
            return null;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get(string);
        if (x509Extension == null) {
            return null;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            byArray = new byte[]{};
        }
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.type = 4;
        aSN1Decoder$Node.data = x509Extension.value();
        return ASN1Encoder.encodeNode(aSN1Decoder$Node);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 CRL v");
        stringBuffer.append(this.getVersion());
        stringBuffer.append("\n\tThis update: ");
        stringBuffer.append(this.getThisUpdate());
        stringBuffer.append("\n\tNext update: ");
        stringBuffer.append(this.getNextUpdate());
        stringBuffer.append("\n\tExtensions: ");
        stringBuffer.append(this.extensions == null ? 0 : this.extensions.size());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static ASN1Decoder CRLDecoder(InputStream inputStream) {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        X509CRL$1 x509CRL$1 = new X509CRL$1();
        aSN1Decoder.configureTypeRedirection(2, x509CRL$1);
        return aSN1Decoder;
    }

    private void configureRevokedCertificates(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray) {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
        this.revokedCertificates = new Hashtable();
        int n = 0;
        while (n < aSN1Decoder$NodeArray.length) {
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$NodeArray[n];
            X509CRLEntry x509CRLEntry = X509CRLEntry.X509CRLEntryFromASN1Object(aSN1Decoder$Node2, byArray);
            this.revokedCertificates.put(x509CRLEntry.getSerialNumber(), x509CRLEntry);
            ++n;
        }
    }

    private void configureExtensions(ASN1Decoder$Node aSN1Decoder$Node) {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
        ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[0].data;
        this.extensions = new Hashtable();
        int n = 0;
        while (n < aSN1Decoder$NodeArray2.length) {
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$NodeArray2[n];
            ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
            boolean bl = false;
            if (aSN1Decoder$NodeArray3.length > 2) {
                bl = (Boolean)aSN1Decoder$NodeArray3[1].data;
            }
            ASN1OID aSN1OID = new ASN1OID((int[])aSN1Decoder$NodeArray3[0].data);
            byte[] byArray = (byte[])aSN1Decoder$NodeArray3[aSN1Decoder$NodeArray3.length - 1].data;
            X509Extension x509Extension = new X509Extension(aSN1OID, byArray, bl);
            this.extensions.put(x509Extension.name(), x509Extension);
            ++n;
        }
    }

    private void configureSignature(ASN1Decoder$Node[] aSN1Decoder$NodeArray) {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data;
        ASN1Decoder$BitString aSN1Decoder$BitString = (ASN1Decoder$BitString)aSN1Decoder$NodeArray[2].data;
        this.rawSignature = aSN1Decoder$BitString.data;
        this.sigAlgOID = ASN1OID.OIDToString((int[])aSN1Decoder$NodeArray2[0].data);
        String[] stringArray = new String[1];
        this.signatureName = X509Certificate.getAlias("Alg.Alias.Signature.", this.sigAlgOID, stringArray);
        this.signatureProviderName = stringArray[0];
        if (aSN1Decoder$NodeArray2.length > 1) {
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder$NodeArray2[1];
            if (aSN1Decoder$Node.type != 5) {
                this.sigAlgParams = new byte[aSN1Decoder$Node.endPosition - aSN1Decoder$Node.startPosition + 1];
                System.arraycopy((Object)this.encoded, aSN1Decoder$Node.startPosition - this.originalOffsetIntoRawBytes, (Object)this.sigAlgParams, 0, this.sigAlgParams.length);
            }
        }
    }

    static CRL CRLFromASN1Object(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray) {
        try {
            int n;
            Object object;
            X509CRL x509CRL = new X509CRL();
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
            int n2 = aSN1Decoder$Node.startPosition;
            int n3 = aSN1Decoder$Node.endPosition;
            if (n2 == 0 && n3 == byArray.length - 1) {
                x509CRL.encoded = byArray;
            } else {
                x509CRL.encoded = new byte[n3 - n2 + 1];
                System.arraycopy((Object)byArray, n2, (Object)x509CRL.encoded, 0, x509CRL.encoded.length);
            }
            x509CRL.originalOffsetIntoRawBytes = n2;
            x509CRL.configureSignature(aSN1Decoder$NodeArray);
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$NodeArray[0];
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
            x509CRL.tbsNode = aSN1Decoder$Node2;
            if (aSN1Decoder$NodeArray2[0].type == 2) {
                object = (BigInteger)aSN1Decoder$NodeArray2[0].data;
                x509CRL.version = ((BigInteger)object).intValue() + 1;
                n = 0;
            } else {
                x509CRL.version = 2;
                n = -1;
            }
            x509CRL.issuer = object = new X500Principal(aSN1Decoder$NodeArray2[n + 2]);
            ASN1Decoder$Node aSN1Decoder$Node3 = aSN1Decoder$NodeArray2[n + 3];
            x509CRL.thisUpdate = (Date)aSN1Decoder$Node3.data;
            if (aSN1Decoder$NodeArray2.length <= n + 4) {
                return x509CRL;
            }
            aSN1Decoder$Node3 = aSN1Decoder$NodeArray2[n + 4];
            if (aSN1Decoder$Node3.type == 23 || aSN1Decoder$Node3.type == 24) {
                x509CRL.nextUpdate = (Date)aSN1Decoder$Node3.data;
            } else {
                --n;
            }
            if (aSN1Decoder$NodeArray2.length <= n + 5) {
                return x509CRL;
            }
            ASN1Decoder$Node aSN1Decoder$Node4 = aSN1Decoder$NodeArray2[n + 5];
            if (aSN1Decoder$Node4.originalType == 16) {
                x509CRL.configureRevokedCertificates(aSN1Decoder$Node4, byArray);
            } else {
                --n;
            }
            if (aSN1Decoder$NodeArray2.length <= n + 6) {
                return x509CRL;
            }
            ASN1Decoder$Node aSN1Decoder$Node5 = aSN1Decoder$NodeArray2[n + 6];
            if (aSN1Decoder$Node5.originalType == 0) {
                x509CRL.configureExtensions(aSN1Decoder$Node5);
            }
            return x509CRL;
        }
        catch (ClassCastException classCastException) {
            throw new CRLException();
        }
    }

    static CRL CRLFromASN1Object(InputStream inputStream) {
        try {
            ASN1Decoder aSN1Decoder = X509CRL.CRLDecoder(inputStream);
            aSN1Decoder.collectBytes(true);
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            X509CRL x509CRL = (X509CRL)X509CRL.CRLFromASN1Object(aSN1Decoder$Node, aSN1Decoder.collectedBytes());
            return x509CRL;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CRLException();
        }
        catch (ClassCastException classCastException) {
            throw new CRLException();
        }
    }

    @Override
    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        return new javax.security.auth.x500.X500Principal(this.issuer.getName());
    }
}

