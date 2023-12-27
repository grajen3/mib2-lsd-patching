/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;

final class X509Extension {
    private ASN1OID id;
    private byte[] value;
    private boolean isCritical;

    public X509Extension(ASN1OID aSN1OID, byte[] byArray, boolean bl) {
        this.id = aSN1OID;
        this.value = byArray;
        this.isCritical = bl;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof X509Extension)) {
            return false;
        }
        X509Extension x509Extension = (X509Extension)object;
        return this.id.equals(x509Extension.id);
    }

    public String toString() {
        return new StringBuffer(String.valueOf(this.id.toString())).append("->").append(this.value).toString();
    }

    public boolean isCritical() {
        return this.isCritical;
    }

    public byte[] value() {
        return this.value;
    }

    public String name() {
        int[] nArray = this.id.representation();
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < nArray.length - 1) {
            stringBuffer.append(nArray[n]);
            stringBuffer.append('.');
            ++n;
        }
        stringBuffer.append(nArray[nArray.length - 1]);
        return stringBuffer.toString();
    }
}

