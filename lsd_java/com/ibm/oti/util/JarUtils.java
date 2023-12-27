/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.security.provider.PKCS7;
import com.ibm.oti.security.provider.PKCS7$SignerInfo;
import com.ibm.oti.security.provider.X509CertificateChain;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class JarUtils {
    private JarUtils() {
    }

    public static Certificate[] verifySignature(InputStream inputStream, InputStream inputStream2) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        PKCS7 pKCS7;
        Certificate[] certificateArray = null;
        byte[] byArray = new byte[inputStream.available()];
        inputStream.read(byArray, 0, byArray.length);
        byte[] byArray2 = new byte[inputStream2.available()];
        inputStream2.read(byArray2, 0, byArray2.length);
        inputStream.close();
        inputStream2.close();
        try {
            pKCS7 = new PKCS7(byArray2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return certificateArray;
        }
        PKCS7$SignerInfo[] pKCS7$SignerInfoArray = pKCS7.signedData().signerInfos();
        PKCS7$SignerInfo pKCS7$SignerInfo = pKCS7$SignerInfoArray[0];
        Principal principal = pKCS7$SignerInfo.getIssuer();
        BigInteger bigInteger = pKCS7$SignerInfo.getSerialNumber();
        Certificate certificate = null;
        X509Certificate x509Certificate = null;
        Collection collection = null;
        try {
            object5 = CertificateFactory.getInstance("X.509");
            collection = ((CertificateFactory)object5).generateCertificates(new ByteArrayInputStream(byArray2));
            object4 = collection.iterator();
            while (certificate == null && object4.hasNext()) {
                x509Certificate = (X509Certificate)object4.next();
                if (!x509Certificate.getIssuerDN().equals(principal) || !x509Certificate.getSerialNumber().equals(bigInteger)) continue;
                certificate = x509Certificate;
                break;
            }
            if (certificate == null) {
                return certificateArray;
            }
        }
        catch (CertificateException certificateException) {
            return certificateArray;
        }
        object5 = null;
        object4 = pKCS7$SignerInfo.signatureName();
        try {
            if (object4 != null) {
                object5 = Signature.getInstance((String)object4);
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        if (object5 == null) {
            try {
                object4 = pKCS7$SignerInfo.digestEncryptionAlgorithm();
                if (object4 == null) {
                    return certificateArray;
                }
                object5 = Signature.getInstance((String)object4);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                return certificateArray;
            }
        }
        try {
            ((Signature)object5).initVerify(certificate.getPublicKey());
        }
        catch (InvalidKeyException invalidKeyException) {
            return certificateArray;
        }
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = pKCS7$SignerInfo.authenticatedAttributes();
        if (aSN1Decoder$NodeArray.length > 0) {
            object3 = new ASN1Decoder$Node();
            ((ASN1Decoder$Node)object3).type = 17;
            ((ASN1Decoder$Node)object3).data = aSN1Decoder$NodeArray;
            try {
                ((Signature)object5).update(ASN1Encoder.encodeNode((ASN1Decoder$Node)object3));
            }
            catch (SignatureException signatureException) {
                return certificateArray;
            }
        }
        try {
            ((Signature)object5).update(byArray);
        }
        catch (SignatureException signatureException) {
            return certificateArray;
        }
        object3 = pKCS7$SignerInfo.contentMessageDigest();
        if (object3 != null) {
            try {
                object2 = MessageDigest.getInstance(pKCS7$SignerInfo.digestAlgorithm());
                object = ((MessageDigest)object2).digest(byArray);
                if (!Arrays.equals((byte[])object3, (byte[])object)) {
                    throw new SignatureException();
                }
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                return certificateArray;
            }
        }
        if (!((Signature)object5).verify(pKCS7$SignerInfo.encryptedDigest())) {
            throw new SignatureException();
        }
        if (certificate.hasUnsupportedCriticalExtension()) {
            return certificateArray;
        }
        object2 = new X509CertificateChain((X509Certificate)certificate, collection);
        object = new Vector();
        Iterator iterator = ((X509CertificateChain)object2).iterator();
        while (iterator.hasNext()) {
            ((Vector)object).add((Certificate)iterator.next());
        }
        certificateArray = (Certificate[])((Vector)object).toArray(new Certificate[0]);
        return certificateArray;
    }

    public static byte[] getSignatureBlockBytes(byte[] byArray, Certificate[] certificateArray, String string, String string2) {
        return PKCS7.getASN1DEREncoded(certificateArray, string, string2, byArray);
    }
}

