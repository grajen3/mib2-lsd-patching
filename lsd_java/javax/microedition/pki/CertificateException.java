/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.pki;

import java.io.IOException;
import javax.microedition.pki.Certificate;

public class CertificateException
extends IOException {
    public static final byte BAD_EXTENSIONS;
    public static final byte CERTIFICATE_CHAIN_TOO_LONG;
    public static final byte EXPIRED;
    public static final byte UNAUTHORIZED_INTERMEDIATE_CA;
    public static final byte MISSING_SIGNATURE;
    public static final byte NOT_YET_VALID;
    public static final byte SITENAME_MISMATCH;
    public static final byte UNRECOGNIZED_ISSUER;
    public static final byte UNSUPPORTED_SIGALG;
    public static final byte INAPPROPRIATE_KEY_USAGE;
    public static final byte BROKEN_CHAIN;
    public static final byte ROOT_CA_EXPIRED;
    public static final byte UNSUPPORTED_PUBLIC_KEY_TYPE;
    public static final byte VERIFICATION_FAILED;
    private Certificate certificate = null;
    private byte status;

    public CertificateException(String string, Certificate certificate, byte by) {
        super(string);
        this.certificate = certificate;
        this.status = by;
    }

    public CertificateException(Certificate certificate, byte by) {
        this.certificate = certificate;
        this.status = by;
    }

    public Certificate getCertificate() {
        return this.certificate;
    }

    public byte getReason() {
        return this.status;
    }
}

