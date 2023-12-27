/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.X509Extension;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class X509CRLEntry
extends java.security.cert.X509CRLEntry {
    private byte[] encoded;
    private BigInteger serialNumber;
    private Date revocationDate;
    private Hashtable extensions;
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS = new String[0];

    @Override
    public byte[] getEncoded() {
        return this.encoded;
    }

    @Override
    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public Date getRevocationDate() {
        return this.revocationDate;
    }

    @Override
    public boolean hasExtensions() {
        if (this.extensions == null) {
            return false;
        }
        return this.extensions.size() > 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 CRL Entry S/N=");
        stringBuffer.append(this.getSerialNumber());
        stringBuffer.append(" , Extensions: ");
        stringBuffer.append(this.extensions == null ? 0 : this.extensions.size());
        stringBuffer.append(" , Revocation: ");
        stringBuffer.append(this.getRevocationDate());
        return stringBuffer.toString();
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

    static X509CRLEntry X509CRLEntryFromASN1Object(ASN1Decoder$Node aSN1Decoder$Node, byte[] byArray) {
        try {
            X509CRLEntry x509CRLEntry = new X509CRLEntry();
            int n = aSN1Decoder$Node.startPosition;
            int n2 = aSN1Decoder$Node.endPosition;
            if (n == 0 && n2 == byArray.length - 1) {
                x509CRLEntry.encoded = byArray;
            } else {
                x509CRLEntry.encoded = new byte[n2 - n + 1];
                System.arraycopy((Object)byArray, n, (Object)x509CRLEntry.encoded, 0, x509CRLEntry.encoded.length);
            }
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
            x509CRLEntry.serialNumber = (BigInteger)aSN1Decoder$NodeArray[0].data;
            x509CRLEntry.revocationDate = (Date)aSN1Decoder$NodeArray[1].data;
            if (aSN1Decoder$NodeArray.length > 2) {
                x509CRLEntry.extensions = new Hashtable();
                ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[2].data;
                int n3 = 0;
                while (n3 < aSN1Decoder$NodeArray2.length) {
                    ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder$NodeArray2[n3];
                    ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
                    x509CRLEntry.extensions.put(aSN1Decoder$NodeArray3[0], aSN1Decoder$NodeArray3[1]);
                    ++n3;
                }
            }
            return x509CRLEntry;
        }
        catch (ClassCastException classCastException) {
            throw new CRLException();
        }
    }
}

