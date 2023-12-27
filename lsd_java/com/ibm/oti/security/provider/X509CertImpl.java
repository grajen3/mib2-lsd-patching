/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.UnparsedX509PublicKey;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509CertImpl$1;
import com.ibm.oti.security.provider.X509CertImpl$1$prinFactory;
import com.ibm.oti.security.provider.X509CertImpl$GeneralNamesMapper;
import com.ibm.oti.security.provider.X509CertImpl$PrincipalFactory;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.security.provider.X509Extension;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.ASN1Decoder$Data;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Decoder$TypeMapper;
import com.ibm.oti.util.ASN1Decoder$UTCTime;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class X509CertImpl {
    byte[] encoded;
    int originalOffsetIntoRawBytes;
    ASN1Decoder$Node tbsNode;
    int version;
    BigInteger serialNumber;
    X500Principal issuer;
    X500Principal subject;
    Date notBefore;
    Date notAfter;
    String sigAlgOID;
    byte[] sigAlgParams;
    byte[] rawSignature;
    String signatureName;
    String signatureProviderName;
    String subjectAlgOID;
    ASN1Decoder$Node subjectPublicKeyASN1DER;
    PublicKey subjectPublicKey;
    boolean[] subjectUniqueID;
    boolean[] issuerUniqueID;
    Hashtable extensions;
    static final String extendedKeyUsageOID;
    static final String subjectAltNamesOID;
    static final String issuerAltNamesOID;
    public static final Hashtable OID_DATABASE;
    private static final String OID_BasicConstraints;
    private static final String OID_KeyUsage;
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS;
    protected static final ASN1Decoder$TypeMapper X509_MAPPER;
    static final Hashtable KEYALGORITHM_OID;
    static final Hashtable SIGNALGORITHM_OID;

    static {
        OID_DATABASE = new Hashtable(5);
        OID_DATABASE.put("1.2.840.113549.1.1.2", "MD2withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.4", "MD5withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.5", "SHA1withRSA");
        OID_DATABASE.put("1.2.840.10040.4.3", "SHA1withDSA");
        OID_DATABASE.put("1.3.14.3.2.26", "SHA");
        OID_DATABASE.put("1.2.840.113549.2.5", "MD5");
        OID_DATABASE.put("1.2.840.113549.1.1.1", "RSA");
        OID_DATABASE.put("1.2.840.10040.4.1", "DSA");
        OID_DATABASE.put("1.3.14.3.2.12", "DSA");
        OID_DATABASE.put("1.2.840.10046.2.1", "DiffieHellman");
        SUPPORTED_CRITICAL_EXTENSIONS = new String[]{"2.5.29.19", "2.5.29.15"};
        X509_MAPPER = new X509CertImpl$1();
        KEYALGORITHM_OID = new Hashtable(7);
        KEYALGORITHM_OID.put("RSA", "1.2.840.113549.1.1.1");
        KEYALGORITHM_OID.put("DSA", "1.2.840.10040.4.1");
        KEYALGORITHM_OID.put("DiffieHellman", "1.2.840.10046.2.1");
        SIGNALGORITHM_OID = new Hashtable(7);
        SIGNALGORITHM_OID.put("MD2withRSA", "1.2.840.113549.1.1.2");
        SIGNALGORITHM_OID.put("MD5withRSA", "1.2.840.113549.1.1.4");
        SIGNALGORITHM_OID.put("SHA1withRSA", "1.2.840.113549.1.1.5");
        SIGNALGORITHM_OID.put("SHA1withDSA", "1.2.840.10040.4.3");
    }

    protected X509CertImpl() {
    }

    public void checkValidity() {
        this.checkValidity(new Date());
    }

    public void checkValidity(Date date) {
        if (date.getTime() < this.notBefore.getTime()) {
            String string = Msg.getString("K0328");
            throw new CertificateNotYetValidException(string);
        }
        if (date.getTime() > this.notAfter.getTime()) {
            String string = Msg.getString("K0329");
            throw new CertificateExpiredException(string);
        }
    }

    public int getBasicConstraints() {
        if (this.extensions == null) {
            return -1;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get("2.5.29.19");
        if (x509Extension == null) {
            return -1;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            return -1;
        }
        ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
        try {
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$Node.subnode(0);
            boolean bl = false;
            if (aSN1Decoder$Node2 == null) {
                return -1;
            }
            if (aSN1Decoder$Node2.type == 1) {
                bl = (Boolean)aSN1Decoder$Node2.data;
            }
            if (!bl) {
                return -1;
            }
            ASN1Decoder$Node aSN1Decoder$Node3 = aSN1Decoder$Node.subnode(-129);
            if (aSN1Decoder$Node3 == null) {
                return -1;
            }
            if (aSN1Decoder$Node3.type != 2) {
                return -2;
            }
            return ((BigInteger)aSN1Decoder$Node3.data).intValue();
        }
        catch (ASN1Exception aSN1Exception) {
        }
        catch (ClassCastException classCastException) {
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
        return -1;
    }

    public Principal getIssuerDN() {
        return this.issuer;
    }

    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        return new javax.security.auth.x500.X500Principal(this.issuer.getName());
    }

    public boolean[] getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public boolean[] getKeyUsage() {
        if (this.extensions == null) {
            return null;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get("2.5.29.15");
        if (x509Extension == null) {
            return null;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            return null;
        }
        if (byArray.length < 1) {
            return null;
        }
        ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
        try {
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            if (aSN1Decoder$Node.type != 3) {
                return null;
            }
            ASN1Decoder$BitString aSN1Decoder$BitString = (ASN1Decoder$BitString)aSN1Decoder$Node.data;
            int n = aSN1Decoder$BitString.bitLength();
            boolean[] blArray = new boolean[Math.max(n, 9)];
            int n2 = 0;
            while (n2 < n) {
                blArray[n2] = aSN1Decoder$BitString.bitAt(n2);
                ++n2;
            }
            return blArray;
        }
        catch (ASN1Exception aSN1Exception) {
        }
        catch (ClassCastException classCastException) {
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
        return null;
    }

    public Date getNotAfter() {
        return this.notAfter;
    }

    public Date getNotBefore() {
        return this.notBefore;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public String getSigAlgName() {
        return this.signatureName;
    }

    public String getSigAlgOID() {
        return this.sigAlgOID;
    }

    public byte[] getSigAlgParams() {
        return this.sigAlgParams;
    }

    public byte[] getSignature() {
        return this.rawSignature;
    }

    public Principal getSubjectDN() {
        return this.subject;
    }

    public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
        return new javax.security.auth.x500.X500Principal(this.subject.getName());
    }

    public boolean[] getSubjectUniqueID() {
        return this.subjectUniqueID;
    }

    public byte[] getTBSCertificate() {
        byte[] byArray = new byte[this.tbsNode.endPosition - this.tbsNode.startPosition + 1];
        System.arraycopy((Object)this.encoded, this.tbsNode.startPosition - this.originalOffsetIntoRawBytes, (Object)byArray, 0, byArray.length);
        return byArray;
    }

    public int getVersion() {
        return this.version;
    }

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

    public Set getCriticalExtensionOIDs() {
        return this.getExtensionOIDs(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.getExtensionOIDs(false);
    }

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

    public List getExtendedKeyUsage() {
        byte[] byArray = this.getExtensionValue("2.5.29.37");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        ASN1Decoder$Node aSN1Decoder$Node = null;
        try {
            aSN1Decoder$Node = aSN1Decoder.readContents();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateParsingException();
        }
        byte[] byArray2 = (byte[])aSN1Decoder$Node.data;
        aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray2));
        try {
            aSN1Decoder$Node = aSN1Decoder.readContents();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateParsingException();
        }
        ArrayList arrayList = new ArrayList();
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
        int n = 0;
        while (n < aSN1Decoder$NodeArray.length) {
            if (aSN1Decoder$NodeArray[n].type != 6) {
                throw new CertificateParsingException();
            }
            int[] nArray = (int[])aSN1Decoder$NodeArray[n].data;
            ASN1OID aSN1OID = new ASN1OID(nArray);
            arrayList.add(aSN1OID.toString());
            ++n;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public byte[] getEncoded() {
        return this.encoded;
    }

    public PublicKey getPublicKey() {
        return this.subjectPublicKey;
    }

    private byte[] getSubjectPublicKeyInfoAsBytes() {
        byte[] byArray = new byte[this.subjectPublicKeyASN1DER.endPosition - this.subjectPublicKeyASN1DER.startPosition + 1];
        System.arraycopy((Object)this.encoded, this.subjectPublicKeyASN1DER.startPosition - this.originalOffsetIntoRawBytes, (Object)byArray, 0, byArray.length);
        return byArray;
    }

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

    public void verify(PublicKey publicKey, String string) {
        if (this.signatureName == null) {
            throw new NoSuchAlgorithmException(this.sigAlgOID);
        }
        Signature signature = Signature.getInstance(this.signatureName, string);
        this.verify(publicKey, signature);
    }

    private void verify(PublicKey publicKey, Signature signature) {
        signature.initVerify(publicKey);
        signature.update(this.getTBSCertificate());
        boolean bl = signature.verify(this.getSignature());
        if (!bl) {
            throw new SignatureException();
        }
    }

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

    private void configureSignature(ASN1Decoder$Node[] aSN1Decoder$NodeArray) {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data;
        ASN1Decoder$BitString aSN1Decoder$BitString = (ASN1Decoder$BitString)aSN1Decoder$NodeArray[2].data;
        this.rawSignature = aSN1Decoder$BitString.data;
        this.sigAlgOID = ASN1OID.OIDToString((int[])aSN1Decoder$NodeArray2[0].data);
        String[] stringArray = new String[1];
        this.signatureName = X509CertImpl.getAlias("Alg.Alias.Signature.", this.sigAlgOID, stringArray);
        this.signatureProviderName = stringArray[0];
        ASN1Decoder$Node aSN1Decoder$Node = null;
        if (aSN1Decoder$NodeArray2.length > 1) {
            aSN1Decoder$Node = aSN1Decoder$NodeArray2[1];
        }
        if (aSN1Decoder$Node != null && aSN1Decoder$Node.type != 5) {
            this.sigAlgParams = new byte[aSN1Decoder$Node.endPosition - aSN1Decoder$Node.startPosition + 1];
            System.arraycopy((Object)this.encoded, aSN1Decoder$Node.startPosition - this.originalOffsetIntoRawBytes, (Object)this.sigAlgParams, 0, this.sigAlgParams.length);
        }
    }

    static String getAlias(String string, String string2, String[] stringArray) {
        String string3 = new StringBuffer(String.valueOf(string)).append(string2).toString();
        String string4 = null;
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            string4 = (String)provider.get(string3);
            if (string4 != null) {
                if (stringArray != null) {
                    stringArray[0] = provider.getName();
                }
                return string4;
            }
            ++n;
        }
        return (String)X509Certificate.OID_DATABASE.get(string2);
    }

    private void configureSubjectPublicKeyInfo(ASN1Decoder$Node[] aSN1Decoder$NodeArray, int n) {
        ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder$NodeArray[n + 6];
        ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
        ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$NodeArray2[0];
        ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
        this.subjectAlgOID = ASN1OID.OIDToString((int[])aSN1Decoder$NodeArray3[0].data);
        this.subjectPublicKeyASN1DER = aSN1Decoder$Node;
        String string = X509CertImpl.getAlias("Alg.Alias.KeyFactory.", this.subjectAlgOID, null);
        byte[] byArray = this.getSubjectPublicKeyInfoAsBytes();
        this.subjectPublicKey = this.createPublicKeyUsingProviders(string, byArray);
        if (this.subjectPublicKey != null) {
            return;
        }
        UnparsedX509PublicKey unparsedX509PublicKey = new UnparsedX509PublicKey(byArray);
        unparsedX509PublicKey.algorithm = string == null ? this.subjectAlgOID : string;
        this.subjectPublicKey = unparsedX509PublicKey;
    }

    protected PublicKey createPublicKeyUsingProviders(String string, byte[] byArray) {
        KeyFactory keyFactory = null;
        try {
            if (string != null) {
                keyFactory = KeyFactory.getInstance(string);
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        if (keyFactory != null) {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
            return keyFactory.generatePublic(x509EncodedKeySpec);
        }
        return null;
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

    private boolean[] computeUniqueID(ASN1Decoder$Node aSN1Decoder$Node) {
        byte[] byArray = aSN1Decoder$Node.data instanceof ASN1Decoder$BitString ? ((ASN1Decoder$BitString)aSN1Decoder$Node.data).data : ((BigInteger)aSN1Decoder$Node.data).toByteArray();
        boolean[] blArray = new boolean[byArray.length * 8];
        int n = 0;
        while (n < byArray.length * 8) {
            blArray[n] = (byArray[n / 8] & 128 >> n % 8) != 0;
            ++n;
        }
        return blArray;
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

    private void configureOptionalParts(ASN1Decoder$Node[] aSN1Decoder$NodeArray, int n) {
        int n2 = n + 7;
        while (n2 < aSN1Decoder$NodeArray.length) {
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder$NodeArray[n2];
            ++n2;
            switch (aSN1Decoder$Node.originalType) {
                case 1: {
                    this.issuerUniqueID = this.computeUniqueID(aSN1Decoder$Node);
                    break;
                }
                case 2: {
                    this.subjectUniqueID = this.computeUniqueID(aSN1Decoder$Node);
                    break;
                }
                case 3: {
                    this.configureExtensions(aSN1Decoder$Node);
                }
            }
        }
    }

    public static X509CertImpl certificateFromASN1Object(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return X509CertImpl.certificateFromASN1Object(byteArrayInputStream);
    }

    public static X509CertImpl certificateFromASN1Object(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray) {
        X509CertImpl x509CertImpl = new X509CertImpl();
        return X509CertImpl.certificateFromASN1Object(aSN1Decoder$Node, byArray, x509CertImpl, new X509CertImpl$1$prinFactory());
    }

    public static X509CertImpl certificateFromASN1Object(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray, X509CertImpl x509CertImpl, X509CertImpl$PrincipalFactory x509CertImpl$PrincipalFactory) {
        try {
            X500Principal x500Principal;
            X500Principal x500Principal2;
            int n;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray;
            Object object;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
            int n2 = aSN1Decoder$Node.startPosition;
            int n3 = aSN1Decoder$Node.endPosition;
            if (n2 == 0 && n3 == byArray.length - 1) {
                x509CertImpl.encoded = byArray;
            } else {
                x509CertImpl.encoded = new byte[n3 - n2 + 1];
                System.arraycopy((Object)byArray, n2, (Object)x509CertImpl.encoded, 0, x509CertImpl.encoded.length);
            }
            x509CertImpl.originalOffsetIntoRawBytes = n2;
            x509CertImpl.configureSignature(aSN1Decoder$NodeArray2);
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$NodeArray2[0];
            ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
            x509CertImpl.tbsNode = aSN1Decoder$Node2;
            if (aSN1Decoder$NodeArray3[0].originalType == 0) {
                object = (ASN1Decoder$Node[])aSN1Decoder$NodeArray3[0].data;
                aSN1Decoder$NodeArray = (ASN1Decoder$Node[])object[0].data;
                x509CertImpl.version = aSN1Decoder$NodeArray.intValue() + 1;
                n = 0;
            } else {
                x509CertImpl.version = 1;
                n = -1;
            }
            x509CertImpl.serialNumber = (BigInteger)aSN1Decoder$NodeArray3[n + 1].data;
            object = aSN1Decoder$NodeArray3[n + 4];
            aSN1Decoder$NodeArray = (ASN1Decoder$Node[])object.data;
            x509CertImpl.notBefore = (Date)aSN1Decoder$NodeArray[0].data;
            x509CertImpl.notAfter = (Date)aSN1Decoder$NodeArray[1].data;
            x509CertImpl.issuer = x500Principal2 = x509CertImpl$PrincipalFactory.getInstance(aSN1Decoder$NodeArray3[n + 3]);
            x509CertImpl.subject = x500Principal = x509CertImpl$PrincipalFactory.getInstance(aSN1Decoder$NodeArray3[n + 5]);
            x509CertImpl.configureSubjectPublicKeyInfo(aSN1Decoder$NodeArray3, n);
            x509CertImpl.configureOptionalParts(aSN1Decoder$NodeArray3, n);
            return x509CertImpl;
        }
        catch (ClassCastException classCastException) {
            throw new CertificateException();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new CertificateException();
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new CertificateException();
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new CertificateException();
        }
    }

    public static X509CertImpl certificateFromASN1Object(InputStream inputStream) {
        try {
            ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
            aSN1Decoder.configureTypeRedirection(2, X509_MAPPER);
            aSN1Decoder.collectBytes(true);
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            if (aSN1Decoder$Node == null) {
                throw new CertificateException();
            }
            X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(aSN1Decoder$Node, aSN1Decoder.collectedBytes());
            return x509CertImpl;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateException();
        }
    }

    public static X509CertImpl certificateFromData(PublicKey publicKey, String string, Date date, Date date2, BigInteger bigInteger) {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromData(publicKey, string, date, date2);
        x509CertImpl.serialNumber = bigInteger;
        return x509CertImpl;
    }

    public static X509CertImpl certificateFromData(PublicKey publicKey, String string, Date date, Date date2) {
        try {
            X509CertImpl x509CertImpl = new X509CertImpl();
            x509CertImpl.encoded = null;
            x509CertImpl.subjectPublicKey = publicKey;
            x509CertImpl.notBefore = date;
            x509CertImpl.notAfter = date2;
            x509CertImpl.version = 1;
            x509CertImpl.serialNumber = new BigInteger(String.valueOf(x509CertImpl.notBefore.getTime() / 0));
            if (string != null) {
                X500Principal x500Principal;
                X500Principal x500Principal2;
                x509CertImpl.issuer = x500Principal2 = new X500Principal(string);
                x509CertImpl.subject = x500Principal = new X500Principal(string);
            }
            return x509CertImpl;
        }
        catch (ClassCastException classCastException) {
            throw new CertificateException(classCastException.getMessage());
        }
    }

    public byte[] getSignedAndEncoded(String string, PrivateKey privateKey) {
        try {
            int n = -1;
            Object[] objectArray = new Object[n + 7];
            objectArray[n + 1] = this.serialNumber;
            Object[] objectArray2 = new Object[2];
            String string2 = (String)SIGNALGORITHM_OID.get(string);
            objectArray2[0] = ASN1OID.stringToIntOID(string2);
            objectArray2[1] = null;
            objectArray[n + 2] = objectArray2;
            objectArray[n + 3] = new ASN1Decoder$Data(this.issuer.getEncoded());
            Object[] objectArray3 = new Object[]{new ASN1Decoder$UTCTime(this.notBefore), new ASN1Decoder$UTCTime(this.notAfter)};
            objectArray[n + 4] = objectArray3;
            objectArray[n + 5] = new ASN1Decoder$Data(this.subject.getEncoded());
            objectArray[n + 6] = new ASN1Decoder$Data(this.subjectPublicKey.getEncoded());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
            aSN1Encoder.writeObject(objectArray);
            Signature signature = Signature.getInstance(string);
            signature.initSign(privateKey);
            signature.update(byteArrayOutputStream.toByteArray());
            Object[] objectArray4 = new Object[2];
            string2 = (String)SIGNALGORITHM_OID.get(string);
            objectArray4[0] = ASN1OID.stringToIntOID(string2);
            objectArray4[1] = null;
            ASN1Decoder$BitString aSN1Decoder$BitString = new ASN1Decoder$BitString(0, signature.sign());
            Object[] objectArray5 = new Object[]{new ASN1Decoder$Data(byteArrayOutputStream.toByteArray()), objectArray4, aSN1Decoder$BitString};
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ASN1Encoder aSN1Encoder2 = new ASN1Encoder(byteArrayOutputStream2);
            aSN1Encoder2.writeObject(objectArray5);
            return byteArrayOutputStream2.toByteArray();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateException(aSN1Exception.getMessage());
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new CertificateException(invalidKeyException.getMessage());
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new CertificateException(noSuchAlgorithmException.getMessage());
        }
        catch (SignatureException signatureException) {
            throw new CertificateException(signatureException.getMessage());
        }
    }

    public Collection getSubjectAlternativeNames() {
        return this.getAlternativeNames("2.5.29.17");
    }

    public Collection getIssuerAlternativeNames() {
        return this.getAlternativeNames("2.5.29.18");
    }

    private Collection getAlternativeNames(String string) {
        try {
            byte[] byArray = this.getExtensionValue(string);
            if (byArray == null) {
                return null;
            }
            ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            if (aSN1Decoder$Node.type != 4) {
                throw new CertificateParsingException();
            }
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream((byte[])aSN1Decoder$Node.data));
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder.readContents();
            if (aSN1Decoder$Node2.type != 16) {
                throw new CertificateParsingException();
            }
            LinkedList linkedList = new LinkedList();
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
            int n = 0;
            while (n < aSN1Decoder$NodeArray.length) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])aSN1Decoder$Node.data, aSN1Decoder$NodeArray[n].startPosition, aSN1Decoder$NodeArray[n].endPosition);
                aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
                aSN1Decoder.configureTypeRedirection(0, new X509CertImpl$GeneralNamesMapper());
                ASN1Decoder$Node aSN1Decoder$Node3 = aSN1Decoder.readContents();
                int n2 = aSN1Decoder$NodeArray[n].type;
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new Integer(n2));
                switch (n2) {
                    case 1: 
                    case 2: 
                    case 4: 
                    case 6: {
                        arrayList.add(new String((String)aSN1Decoder$Node3.data));
                        linkedList.add(arrayList);
                        break;
                    }
                    case 3: 
                    case 5: {
                        byte[] byArray2 = (byte[])aSN1Decoder$Node3.data;
                        byte[] byArray3 = new byte[byArray2.length];
                        System.arraycopy((Object)byArray2, 0, (Object)byArray3, 0, byArray2.length);
                        arrayList.add(byArray3);
                        linkedList.add(arrayList);
                        break;
                    }
                    case 7: {
                        byte[] byArray4 = (byte[])aSN1Decoder$Node3.data;
                        InetAddress inetAddress = null;
                        inetAddress = InetAddress.getByAddress(byArray4);
                        arrayList.add(inetAddress.getHostAddress());
                        linkedList.add(arrayList);
                        break;
                    }
                    case 8: {
                        arrayList.add(ASN1OID.OIDToString((int[])aSN1Decoder$Node3.data));
                        linkedList.add(arrayList);
                        break;
                    }
                    default: {
                        throw new CertificateParsingException(Msg.getString("K0414", n2));
                    }
                }
                ++n;
            }
            return Collections.unmodifiableList(linkedList);
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateParsingException();
        }
        catch (UnknownHostException unknownHostException) {
            throw new CertificateParsingException();
        }
    }

    public void setIssuerDN(Principal principal) {
        this.issuer = new X500Principal(principal.getName());
    }

    public void setSubjectDN(Principal principal) {
        this.subject = new X500Principal(principal.getName());
    }
}

