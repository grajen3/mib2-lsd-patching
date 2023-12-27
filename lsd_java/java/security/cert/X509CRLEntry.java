/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509Extension;
import java.util.Arrays;
import java.util.Date;

public abstract class X509CRLEntry
implements X509Extension {
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof X509CRLEntry)) {
            return false;
        }
        X509CRLEntry x509CRLEntry = (X509CRLEntry)object;
        try {
            return Arrays.equals(this.getEncoded(), x509CRLEntry.getEncoded());
        }
        catch (CRLException cRLException) {
            return false;
        }
    }

    public abstract byte[] getEncoded() {
    }

    public abstract BigInteger getSerialNumber() {
    }

    public abstract Date getRevocationDate() {
    }

    public abstract boolean hasExtensions() {
    }

    public int hashCode() {
        try {
            byte[] byArray = this.getEncoded();
            int n = 1;
            int n2 = 0;
            while (n2 < byArray.length) {
                n *= byArray[n2] & 0xFF;
                ++n2;
            }
            return n;
        }
        catch (CRLException cRLException) {
            return 0;
        }
    }

    public abstract String toString() {
    }
}

