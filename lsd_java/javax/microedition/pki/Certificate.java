/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.pki;

public interface Certificate {
    default public String getIssuer() {
    }

    default public long getNotAfter() {
    }

    default public long getNotBefore() {
    }

    default public String getSerialNumber() {
    }

    default public String getSigAlgName() {
    }

    default public String getSubject() {
    }

    default public String getType() {
    }

    default public String getVersion() {
    }
}

