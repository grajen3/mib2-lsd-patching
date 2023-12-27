/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CertificateFactorySpi {
    public abstract Certificate engineGenerateCertificate(InputStream inputStream) {
    }

    public abstract Collection engineGenerateCertificates(InputStream inputStream) {
    }

    public abstract CRL engineGenerateCRL(InputStream inputStream) {
    }

    public abstract Collection engineGenerateCRLs(InputStream inputStream) {
    }

    public Iterator engineGetCertPathEncodings() {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(InputStream inputStream) {
        Collection collection = this.engineGenerateCertificates(inputStream);
        ArrayList arrayList = new ArrayList(collection);
        return this.engineGenerateCertPath(arrayList);
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String string) {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(List list) {
        throw new UnsupportedOperationException();
    }
}

