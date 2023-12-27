/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.ByteArrayInputStream;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class Certificate$CertificateRep
implements Serializable {
    static final long serialVersionUID;
    String type;
    byte[] data;

    protected Certificate$CertificateRep(String string, byte[] byArray) {
        this.type = string;
        this.data = byArray;
    }

    protected Object readResolve() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(this.type);
            Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(this.data));
            return certificate;
        }
        catch (CertificateException certificateException) {
            throw new InvalidObjectException(certificateException.toString());
        }
    }
}

