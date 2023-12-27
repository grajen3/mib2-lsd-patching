/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.pki.Certificate;

public interface SecurityInfo {
    default public String getCipherSuite() {
    }

    default public String getProtocolName() {
    }

    default public String getProtocolVersion() {
    }

    default public Certificate getServerCertificate() {
    }
}

