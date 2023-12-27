/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.security.PublicKey;
import java.security.cert.Certificate$CertificateRep;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.zip.CRC32;

public abstract class Certificate
implements Serializable {
    private static final long serialVersionUID;
    private String type;

    protected Certificate(String string) {
        this.type = string;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        Certificate certificate = null;
        try {
            certificate = (Certificate)object;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        try {
            return Arrays.equals(this.getEncoded(), certificate.getEncoded());
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return false;
        }
    }

    public abstract byte[] getEncoded() {
    }

    public abstract PublicKey getPublicKey() {
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        try {
            CRC32 cRC32 = new CRC32();
            cRC32.update(this.getEncoded());
            return (int)cRC32.getValue();
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return super.hashCode();
        }
    }

    public abstract String toString() {
    }

    public abstract void verify(PublicKey publicKey) {
    }

    public abstract void verify(PublicKey publicKey, String string) {
    }

    protected Object writeReplace() {
        byte[] byArray = null;
        try {
            byArray = this.getEncoded();
        }
        catch (CertificateEncodingException certificateEncodingException) {
            throw new NotSerializableException(certificateEncodingException.toString());
        }
        return new Certificate$CertificateRep(this.type, byArray);
    }
}

