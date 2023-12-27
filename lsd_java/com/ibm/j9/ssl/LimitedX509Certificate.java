/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.oti.security.provider.X509Certificate;
import javax.microedition.pki.Certificate;

public class LimitedX509Certificate
implements Certificate {
    private X509Certificate certImpl = null;

    public LimitedX509Certificate(X509Certificate x509Certificate) {
        this.certImpl = x509Certificate;
    }

    @Override
    public String getIssuer() {
        return this.certImpl.getIssuerDN().getName();
    }

    @Override
    public long getNotAfter() {
        return this.certImpl.getNotAfter().getTime();
    }

    @Override
    public long getNotBefore() {
        return this.certImpl.getNotBefore().getTime();
    }

    @Override
    public String getSerialNumber() {
        String string = this.certImpl.getSerialNumber().toString(16).toUpperCase();
        if (string.length() % 2 != 0) {
            string = new StringBuffer("0").append(string).toString();
        }
        String string2 = "";
        int n = 0;
        while (n < string.length()) {
            string2 = new StringBuffer(String.valueOf(string2)).append(string.substring(n, n + 2)).toString();
            if ((n += 2) >= string.length()) continue;
            string2 = new StringBuffer(String.valueOf(string2)).append(":").toString();
        }
        return string2;
    }

    @Override
    public String getSigAlgName() {
        return this.certImpl.getSigAlgName();
    }

    @Override
    public String getSubject() {
        return this.certImpl.getSubjectDN().getName();
    }

    @Override
    public String getType() {
        return "X.509";
    }

    @Override
    public String getVersion() {
        return Integer.toString(this.certImpl.getVersion());
    }
}

