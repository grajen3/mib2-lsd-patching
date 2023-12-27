/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ssl;

import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.LimitedX509Certificate;
import com.ibm.oti.connection.ssl.Connection;
import javax.microedition.io.SecurityInfo;
import javax.microedition.pki.Certificate;

final class Connection$1
implements SecurityInfo {
    final /* synthetic */ Connection this$0;

    Connection$1(Connection connection) {
        this.this$0 = connection;
    }

    @Override
    public String getCipherSuite() {
        return new StringBuffer("TLS_").append(this.this$0.sessionState.getCipherSpec().toString()).toString();
    }

    @Override
    public String getProtocolName() {
        return CipherSpec.getProtocolName(this.this$0.sessionState.getProtocolVersion()).substring(0, 3);
    }

    @Override
    public String getProtocolVersion() {
        byte[] byArray = this.this$0.sessionState.getProtocolVersion();
        return new StringBuffer(String.valueOf(String.valueOf(byArray[0]))).append(".").append(String.valueOf(byArray[1])).toString();
    }

    @Override
    public Certificate getServerCertificate() {
        return new LimitedX509Certificate(this.this$0.getCertificate());
    }
}

