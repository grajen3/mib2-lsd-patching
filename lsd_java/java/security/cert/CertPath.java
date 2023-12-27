/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.security.cert.CertPath$CertPathRep;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Iterator;
import java.util.List;

public abstract class CertPath
implements Serializable {
    private String type;

    protected CertPath(String string) {
        this.type = string;
    }

    public String getType() {
        return this.type;
    }

    public abstract Iterator getEncodings() {
    }

    public boolean equals(Object object) {
        if (!(object instanceof CertPath)) {
            return false;
        }
        CertPath certPath = (CertPath)object;
        if (certPath.type != this.type) {
            return false;
        }
        return certPath.getCertificates() == this.getCertificates();
    }

    public abstract List getCertificates() {
    }

    public int hashCode() {
        return 31 * this.getType().hashCode() + this.getCertificates().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = this.getCertificates().iterator();
        while (iterator.hasNext()) {
            Certificate certificate = (Certificate)iterator.next();
            stringBuffer.append(certificate.toString());
        }
        return stringBuffer.toString();
    }

    public abstract byte[] getEncoded() {
    }

    public abstract byte[] getEncoded(String string) {
    }

    protected Object writeReplace() {
        byte[] byArray;
        try {
            byArray = this.getEncoded(this.type);
        }
        catch (CertificateEncodingException certificateEncodingException) {
            throw new NotSerializableException(certificateEncodingException.getMessage());
        }
        return new CertPath$CertPathRep(this.type, byArray);
    }
}

