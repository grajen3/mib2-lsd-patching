/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.util.Set;

public interface X509Extension {
    default public boolean hasUnsupportedCriticalExtension() {
    }

    default public Set getCriticalExtensionOIDs() {
    }

    default public Set getNonCriticalExtensionOIDs() {
    }

    default public byte[] getExtensionValue(String string) {
    }
}

