/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.ByteArrayInputStream;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class CertPath$CertPathRep
implements Serializable {
    private String type;
    private byte[] data;

    protected CertPath$CertPathRep(String string, byte[] byArray) {
        this.type = string;
        this.data = byArray;
    }

    protected Object readResolve() {
        CertPath certPath;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(this.type);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
            certPath = certificateFactory.generateCertPath(byteArrayInputStream);
        }
        catch (CertificateException certificateException) {
            throw new InvalidObjectException(certificateException.getMessage());
        }
        return certPath;
    }
}

