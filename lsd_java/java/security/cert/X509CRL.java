/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Extension;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public abstract class X509CRL
extends CRL
implements X509Extension {
    protected X509CRL() {
        super("X.509");
    }

    public abstract byte[] getEncoded() {
    }

    public abstract Principal getIssuerDN() {
    }

    public abstract Date getNextUpdate() {
    }

    public abstract X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
    }

    public abstract Set getRevokedCertificates() {
    }

    public abstract String getSigAlgName() {
    }

    public abstract String getSigAlgOID() {
    }

    public abstract byte[] getSigAlgParams() {
    }

    public abstract byte[] getSignature() {
    }

    public abstract byte[] getTBSCertList() {
    }

    public abstract Date getThisUpdate() {
    }

    public abstract int getVersion() {
    }

    public abstract void verify(PublicKey publicKey) {
    }

    public abstract void verify(PublicKey publicKey, String string) {
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof X509CRL)) {
            return false;
        }
        X509CRL x509CRL = (X509CRL)object;
        try {
            return Arrays.equals(this.getEncoded(), x509CRL.getEncoded());
        }
        catch (CRLException cRLException) {
            return false;
        }
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

    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.getIssuerDN().getName());
    }
}

