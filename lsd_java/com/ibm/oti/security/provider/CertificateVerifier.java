/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.CertificateVerifierSecurity;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateVerifier {
    public static final int USAGE_MIDLET_SUITE_INSTALL;
    public static final int USAGE_SSL_SERVER_AUTH;

    public static void verifyCertificateChain(X509Certificate[] x509CertificateArray, Date date, int n) {
        CertificateVerifierSecurity.verifyCertificateChain(x509CertificateArray, date);
    }
}

