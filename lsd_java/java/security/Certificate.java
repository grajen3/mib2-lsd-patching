/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.security.PublicKey;

public interface Certificate {
    default public void decode(InputStream inputStream) {
    }

    default public void encode(OutputStream outputStream) {
    }

    default public String getFormat() {
    }

    default public Principal getGuarantor() {
    }

    default public Principal getPrincipal() {
    }

    default public PublicKey getPublicKey() {
    }

    default public String toString(boolean bl) {
    }
}

