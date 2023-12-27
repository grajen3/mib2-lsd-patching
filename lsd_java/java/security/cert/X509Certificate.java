/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Extension;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public abstract class X509Certificate
extends Certificate
implements X509Extension {
    private static final long serialVersionUID;

    protected X509Certificate() {
        super("X.509");
    }

    public abstract void checkValidity() {
    }

    public abstract void checkValidity(Date date) {
    }

    public abstract int getBasicConstraints() {
    }

    public abstract Principal getIssuerDN() {
    }

    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.getIssuerDN().getName());
    }

    public abstract boolean[] getIssuerUniqueID() {
    }

    public abstract boolean[] getKeyUsage() {
    }

    public abstract Date getNotAfter() {
    }

    public abstract Date getNotBefore() {
    }

    public abstract BigInteger getSerialNumber() {
    }

    public abstract String getSigAlgName() {
    }

    public abstract String getSigAlgOID() {
    }

    public abstract byte[] getSigAlgParams() {
    }

    public abstract byte[] getSignature() {
    }

    public abstract Principal getSubjectDN() {
    }

    public X500Principal getSubjectX500Principal() {
        return new X500Principal(this.getSubjectDN().getName());
    }

    public abstract boolean[] getSubjectUniqueID() {
    }

    public abstract byte[] getTBSCertificate() {
    }

    public abstract int getVersion() {
    }

    public List getExtendedKeyUsage() {
        throw new UnsupportedOperationException();
    }

    public Collection getSubjectAlternativeNames() {
        throw new UnsupportedOperationException();
    }

    public Collection getIssuerAlternativeNames() {
        throw new UnsupportedOperationException();
    }
}

