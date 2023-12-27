/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.PKCS7;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder$Data;
import com.ibm.oti.util.ASN1Decoder$ImplicitSet;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Decoder$Set2;
import com.ibm.oti.util.ASN1Encoder;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Arrays;

public class PKCS7$SignerInfo {
    private ASN1Decoder$Node contents;
    private Principal issuer = null;
    private BigInteger serialNumber = null;
    private static final int[] ATTRIBUTE_MESSAGE_DIGEST = new int[]{1, 2, 840, -1917124352, 1, 9, 4};
    private ASN1Decoder$Set2 signedAttributes = null;
    private String digestAlgorithmName;
    private String encryptionAlgorithmName;
    private byte[] encryptedDigest;

    PKCS7$SignerInfo(ASN1Decoder$Node aSN1Decoder$Node) {
        this.contents = aSN1Decoder$Node;
    }

    public byte[] encryptedDigest() {
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])this.contents.data;
            int n = 0;
            while (aSN1Decoder$NodeArray[n].type != 4) {
                ++n;
            }
            return (byte[])aSN1Decoder$NodeArray[n].data;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public String digestEncryptionAlgorithm() {
        int[] nArray = this.digestEncryptionAlgorithmOID();
        if (nArray == null) {
            return null;
        }
        String string = ASN1OID.OIDToString(nArray);
        return X509Certificate.getAlias("Alg.Alias.KeyFactory.", string, null);
    }

    public String digestAlgorithm() {
        int[] nArray = this.digestAlgorithmOID();
        if (nArray == null) {
            return null;
        }
        String string = ASN1OID.OIDToString(nArray);
        return X509Certificate.getAlias("Alg.Alias.MessageDigest.", string, null);
    }

    public int[] digestEncryptionAlgorithmOID() {
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])this.contents.data;
            int n = 0;
            while (aSN1Decoder$NodeArray[n].type != 4) {
                ++n;
            }
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[--n].data;
            return (int[])aSN1Decoder$NodeArray2[0].data;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public int[] digestAlgorithmOID() {
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])this.contents.data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[2].data;
            return (int[])aSN1Decoder$NodeArray2[0].data;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public String signatureName() {
        String string = this.digestAlgorithm();
        String string2 = this.digestEncryptionAlgorithm();
        if (string == null || string2 == null) {
            return null;
        }
        return new StringBuffer(String.valueOf(string)).append("with").append(string2).toString();
    }

    public ASN1Decoder$Node[] authenticatedAttributes() {
        ASN1Decoder$Node aSN1Decoder$Node = this.contents.subnodeWithOriginalType(0);
        if (aSN1Decoder$Node == null || aSN1Decoder$Node.data == null) {
            return new ASN1Decoder$Node[0];
        }
        return (ASN1Decoder$Node[])aSN1Decoder$Node.data;
    }

    public byte[] contentMessageDigest() {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = this.authenticatedAttributes();
        int n = 0;
        while (n < aSN1Decoder$NodeArray.length) {
            int[] nArray = (int[])aSN1Decoder$NodeArray[n].subnode((int)0).data;
            if (Arrays.equals(nArray, ATTRIBUTE_MESSAGE_DIGEST)) {
                ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder$NodeArray[n].subnode(1).subnode(0);
                return (byte[])aSN1Decoder$Node.data;
            }
            ++n;
        }
        return null;
    }

    public Principal getIssuer() {
        if (this.issuer == null) {
            X500Principal x500Principal = new X500Principal(this.contents.subnode(1).subnode(0));
            this.issuer = x500Principal;
        }
        return this.issuer;
    }

    public BigInteger getSerialNumber() {
        if (this.serialNumber == null) {
            this.serialNumber = (BigInteger)this.contents.subnode((int)1).subnode((int)1).data;
        }
        return this.serialNumber;
    }

    private PKCS7$SignerInfo(java.security.cert.X509Certificate x509Certificate, String string, String string2, byte[] byArray, ASN1Decoder$Set2 aSN1Decoder$Set2) {
        this.digestAlgorithmName = string;
        this.encryptionAlgorithmName = string2;
        this.encryptedDigest = byArray;
        this.signedAttributes = aSN1Decoder$Set2;
        this.issuer = x509Certificate.getIssuerDN();
        this.serialNumber = x509Certificate.getSerialNumber();
    }

    private byte[] getEncoded() {
        Object[] objectArray;
        int n = 0;
        if (this.signedAttributes == null) {
            objectArray = new Object[5];
        } else {
            objectArray = new Object[6];
            n = 1;
        }
        objectArray[0] = BigInteger.ONE;
        Object[] objectArray2 = new Object[]{!(this.issuer instanceof X500Principal) ? new ASN1Decoder$Data(new X500Principal(this.issuer.getName()).getEncoded()) : new ASN1Decoder$Data(((X500Principal)this.issuer).getEncoded()), this.serialNumber};
        objectArray[1] = objectArray2;
        Object[] objectArray3 = new Object[]{PKCS7.algorithmNameToOID(this.digestAlgorithmName), null};
        objectArray[2] = objectArray3;
        if (this.signedAttributes != null) {
            objectArray[3] = new ASN1Decoder$ImplicitSet(this.signedAttributes, 0);
        }
        Object[] objectArray4 = new Object[]{PKCS7.algorithmNameToOID(this.encryptionAlgorithmName), null};
        objectArray[3 + n] = objectArray4;
        objectArray[4 + n] = this.encryptedDigest;
        byte[] byArray = ASN1Encoder.getEncoding(objectArray);
        return byArray;
    }

    public static byte[] getASN1DEREncoded(java.security.cert.X509Certificate x509Certificate, String string, String string2, byte[] byArray, ASN1Decoder$Set2 aSN1Decoder$Set2) {
        return new PKCS7$SignerInfo(x509Certificate, string, string2, byArray, aSN1Decoder$Set2).getEncoded();
    }
}

