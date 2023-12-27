/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS7$SignerInfo;
import com.ibm.oti.security.provider.X509CRL;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder$Node;
import java.util.Vector;

public class PKCS7$SignedData {
    private ASN1Decoder$Node contents;
    private byte[] encoded;

    PKCS7$SignedData(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray) {
        this.contents = aSN1Decoder$Node;
        this.encoded = byArray;
    }

    public PKCS7$SignerInfo[] signerInfos() {
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])this.contents.data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[aSN1Decoder$NodeArray.length - 1].data;
            PKCS7$SignerInfo[] pKCS7$SignerInfoArray = new PKCS7$SignerInfo[aSN1Decoder$NodeArray2.length];
            int n = 0;
            while (n < aSN1Decoder$NodeArray2.length) {
                pKCS7$SignerInfoArray[n] = new PKCS7$SignerInfo(aSN1Decoder$NodeArray2[n]);
                ++n;
            }
            return pKCS7$SignerInfoArray;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public Vector certificates() {
        Vector vector = new Vector();
        try {
            ASN1Decoder$Node aSN1Decoder$Node = ((ASN1Decoder$Node[])this.contents.data)[3];
            if (aSN1Decoder$Node.originalType != 0) {
                return vector;
            }
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
            int n = 0;
            while (n < aSN1Decoder$NodeArray.length) {
                vector.add(X509Certificate.certificateFromASN1Object(aSN1Decoder$NodeArray[n], this.encoded));
                ++n;
            }
            return vector;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return vector;
        }
        catch (ClassCastException classCastException) {
            return vector;
        }
    }

    public Vector CRLs() {
        Vector vector = new Vector();
        try {
            ASN1Decoder$Node aSN1Decoder$Node = ((ASN1Decoder$Node[])this.contents.data)[3];
            if (aSN1Decoder$Node.originalType != 1) {
                aSN1Decoder$Node = ((ASN1Decoder$Node[])this.contents.data)[4];
                if (aSN1Decoder$Node.originalType != 1) {
                    return vector;
                }
            }
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
            int n = 0;
            while (n < aSN1Decoder$NodeArray.length) {
                vector.add(X509CRL.CRLFromASN1Object(aSN1Decoder$NodeArray[n], this.encoded));
                ++n;
            }
            return vector;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return vector;
        }
        catch (ClassCastException classCastException) {
            return vector;
        }
    }
}

