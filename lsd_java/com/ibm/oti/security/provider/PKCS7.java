/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.PKCS7$1;
import com.ibm.oti.security.provider.PKCS7$2;
import com.ibm.oti.security.provider.PKCS7$3;
import com.ibm.oti.security.provider.PKCS7$4;
import com.ibm.oti.security.provider.PKCS7$SignedData;
import com.ibm.oti.security.provider.PKCS7$SignerInfo;
import com.ibm.oti.security.provider.X509CertImpl;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$CertificateSet;
import com.ibm.oti.util.ASN1Decoder$Data;
import com.ibm.oti.util.ASN1Decoder$Explicit;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Decoder$Set2;
import com.ibm.oti.util.ASN1Decoder$TypeMapper;
import com.ibm.oti.util.ASN1Decoder$UTCTime;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.OIDDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PKCS7 {
    private ASN1Decoder decoder;
    private ASN1Decoder$Node contents;
    private byte[] encoded;
    static final int[] DATA_OID = new int[]{1, 2, 840, -1917124352, 1, 7, 1};
    static final int[] SIGNED_DATA_OID = new int[]{1, 2, 840, -1917124352, 1, 7, 2};
    static final int[] ENVELOPED_DATA_OID = new int[]{1, 2, 840, -1917124352, 1, 7, 3};
    static final int[] SIGNED_AND_ENVELOPED_DATA_OID = new int[]{1, 2, 840, -1917124352, 1, 7, 4};
    static final int[] DIGESTED_DATA_OID = new int[]{1, 2, 840, -1917124352, 1, 7, 5};
    static final int[] ENCRYPTED_DATA_OID = new int[]{1, 2, 840, -1917124352, 1, 7, 6};
    static final int[][] POSSIBLE_CONTENTS = new int[6][];

    static {
        PKCS7.POSSIBLE_CONTENTS[0] = DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[1] = SIGNED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[2] = ENVELOPED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[3] = SIGNED_AND_ENVELOPED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[4] = DIGESTED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[5] = ENCRYPTED_DATA_OID;
    }

    public static ASN1Decoder decoder(InputStream inputStream) {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        ASN1Decoder$TypeMapper aSN1Decoder$TypeMapper = new PKCS7$1();
        aSN1Decoder.configureTypeRedirection(1, aSN1Decoder$TypeMapper);
        aSN1Decoder$TypeMapper = new PKCS7$2();
        aSN1Decoder.configureTypeRedirection(3, aSN1Decoder$TypeMapper);
        aSN1Decoder$TypeMapper = new PKCS7$3();
        aSN1Decoder.configureTypeRedirection(4, aSN1Decoder$TypeMapper);
        aSN1Decoder$TypeMapper = new PKCS7$4();
        aSN1Decoder.configureTypeRedirection(5, aSN1Decoder$TypeMapper);
        aSN1Decoder.configureTypeRedirection(6, X509CertImpl.X509_MAPPER);
        return aSN1Decoder;
    }

    public static byte[] encodeCertList(List list) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3;
        Object[] objectArray4 = new Object[list.size()];
        int n = 0;
        Object object = list.iterator();
        while (object.hasNext()) {
            try {
                objectArray3 = (Object[])object.next();
                objectArray2 = objectArray3.getEncoded();
                objectArray = new ASN1Decoder$Data((byte[])objectArray2);
                objectArray4[n++] = objectArray;
            }
            catch (CertificateEncodingException certificateEncodingException) {
                return null;
            }
        }
        object = new ASN1Decoder$CertificateSet(objectArray4);
        objectArray3 = new Object[]{BigInteger.ONE, new ASN1Decoder$Set2(new Object[0]), DATA_OID, object, new ASN1Decoder$Set2(new Object[0])};
        objectArray2 = new Object[1];
        objectArray2[0] = (byte)objectArray3;
        objectArray = new Object[]{SIGNED_DATA_OID, objectArray2};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(objectArray);
        byte[] byArray = byteArrayOutputStream.toByteArray();
        return byArray;
    }

    public static byte[] getASN1DEREncoded(Certificate[] certificateArray, String string, String string2, byte[] byArray) {
        return PKCS7.getASN1DEREncoded(certificateArray, string, string2, byArray, true, null, null);
    }

    public static byte[] getASN1DEREncoded(Certificate[] certificateArray, String string, String string2, byte[] byArray, boolean bl, byte[] byArray2, ASN1Decoder$Set2 aSN1Decoder$Set2) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3;
        Object[] objectArray4 = new Object[certificateArray.length];
        int n = 0;
        while (n < certificateArray.length) {
            try {
                objectArray3 = certificateArray[n];
                objectArray2 = objectArray3.getEncoded();
                objectArray = new ASN1Decoder$Data((byte[])objectArray2);
                objectArray4[n] = objectArray;
            }
            catch (CertificateEncodingException certificateEncodingException) {
                return null;
            }
            ++n;
        }
        ASN1Decoder$CertificateSet aSN1Decoder$CertificateSet = new ASN1Decoder$CertificateSet(objectArray4);
        objectArray3 = null;
        objectArray3 = bl ? new Object[5] : new Object[4];
        objectArray3[0] = BigInteger.ONE;
        objectArray2 = new Object[2];
        objectArray2[0] = (byte)PKCS7.algorithmNameToOID(string);
        objectArray2[1] = (byte)null;
        objectArray3[1] = new ASN1Decoder$Set2(new Object[]{objectArray2});
        objectArray = null;
        if (byArray2 == null) {
            objectArray = new Object[]{DATA_OID};
        } else {
            objectArray = new Object[2];
            objectArray[0] = DATA_OID;
            ASN1Decoder$Explicit aSN1Decoder$Explicit = new ASN1Decoder$Explicit(byArray2);
            objectArray[1] = aSN1Decoder$Explicit;
        }
        objectArray3[2] = objectArray;
        int n2 = 3;
        if (bl) {
            objectArray3[3] = aSN1Decoder$CertificateSet;
            n2 = 4;
        }
        X509Certificate x509Certificate = null;
        if (certificateArray == null || certificateArray.length <= 0) {
            return null;
        }
        x509Certificate = (X509Certificate)certificateArray[0];
        byte[] byArray3 = PKCS7$SignerInfo.getASN1DEREncoded(x509Certificate, string, string2, byArray, aSN1Decoder$Set2);
        objectArray3[n2] = new ASN1Decoder$Set2(new Object[]{new ASN1Decoder$Data(byArray3)});
        Object[] objectArray5 = new Object[]{objectArray3};
        Object[] objectArray6 = new Object[]{SIGNED_DATA_OID, objectArray5};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(objectArray6);
        byte[] byArray4 = byteArrayOutputStream.toByteArray();
        return byArray4;
    }

    static int[] algorithmNameToOID(String string) {
        String string2 = OIDDatabase.getInstance().getFirstOIDForAlgorithm(string);
        return ASN1OID.stringToIntOID(string2);
    }

    public PKCS7(InputStream inputStream) {
        this.decoder = PKCS7.decoder(inputStream);
        try {
            this.decoder.collectBytes(true);
            this.contents = this.decoder.readContents();
            this.encoded = this.decoder.collectedBytes();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
        if (!this.contentsIsPKCS7()) {
            throw new IllegalArgumentException();
        }
    }

    public PKCS7(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        this.decoder = PKCS7.decoder(byteArrayInputStream);
        try {
            this.contents = this.decoder.readContents();
            this.encoded = byArray;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
        if (!this.contentsIsPKCS7()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSignedData() {
        try {
            ASN1Decoder$Node aSN1Decoder$Node = this.contents.subnode(0);
            if (aSN1Decoder$Node == null) {
                return false;
            }
            int[] nArray = (int[])aSN1Decoder$Node.data;
            return Arrays.equals(SIGNED_DATA_OID, nArray);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public PKCS7$SignedData signedData() {
        try {
            if (!this.isSignedData()) {
                return null;
            }
            int[] nArray = new int[2];
            nArray[0] = 1;
            int[] nArray2 = nArray;
            return new PKCS7$SignedData((ASN1Decoder$Node)this.contents.subnode(nArray2), this.encoded);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public ASN1Decoder$Node contents() {
        return this.contents;
    }

    boolean contentsIsPKCS7() {
        int[] nArray = null;
        try {
            ASN1Decoder$Node aSN1Decoder$Node = this.contents.subnode(0);
            if (aSN1Decoder$Node == null) {
                return false;
            }
            nArray = (int[])aSN1Decoder$Node.data;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        int n = 0;
        while (n < POSSIBLE_CONTENTS.length) {
            if (Arrays.equals(POSSIBLE_CONTENTS[n], nArray)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public static ASN1Decoder$Set2 getSignedAttributes(byte[] byArray, String string) {
        byte[] byArray2 = byArray;
        byte[] byArray3 = null;
        if (string.equals("SHA")) {
            byArray3 = new byte[20];
            CL3.sha(null, byArray2, 0, byArray2.length, byArray3, 0);
        } else if (string.equals("MD5")) {
            byArray3 = new byte[16];
            CL3.md5(null, byArray2, 0, byArray2.length, byArray3, 0);
        }
        Object[] objectArray = new Object[2];
        Object[] objectArray2 = new Object[]{DATA_OID};
        objectArray[0] = ASN1OID.stringToIntOID("1.2.840.113549.1.9.3");
        objectArray[1] = new ASN1Decoder$Set2(objectArray2);
        Object[] objectArray3 = new Object[2];
        Object[] objectArray4 = new Object[]{byArray3};
        objectArray3[0] = ASN1OID.stringToIntOID("1.2.840.113549.1.9.4");
        objectArray3[1] = new ASN1Decoder$Set2(objectArray4);
        Object[] objectArray5 = new Object[2];
        Object[] objectArray6 = new Object[]{new ASN1Decoder$UTCTime(new Date())};
        objectArray5[0] = ASN1OID.stringToIntOID("1.2.840.113549.1.9.5");
        objectArray5[1] = new ASN1Decoder$Set2(objectArray6);
        return new ASN1Decoder$Set2(new Object[]{objectArray, objectArray3, objectArray5});
    }

    public static byte[] encodeSignedAttributesForDigest(ASN1Decoder$Set2 aSN1Decoder$Set2) {
        byte[] byArray = ASN1Encoder.getEncoding(aSN1Decoder$Set2);
        return byArray;
    }
}

