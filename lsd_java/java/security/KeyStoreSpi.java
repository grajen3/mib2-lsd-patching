/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Enumeration;

public abstract class KeyStoreSpi {
    public abstract Enumeration engineAliases() {
    }

    public abstract boolean engineContainsAlias(String string) {
    }

    public abstract void engineDeleteEntry(String string) {
    }

    public abstract Certificate engineGetCertificate(String string) {
    }

    public abstract String engineGetCertificateAlias(Certificate certificate) {
    }

    public abstract Certificate[] engineGetCertificateChain(String string) {
    }

    public abstract Date engineGetCreationDate(String string) {
    }

    public abstract Key engineGetKey(String string, char[] cArray) {
    }

    public abstract boolean engineIsCertificateEntry(String string) {
    }

    public abstract boolean engineIsKeyEntry(String string) {
    }

    public abstract void engineLoad(InputStream inputStream, char[] cArray) {
    }

    public abstract void engineSetCertificateEntry(String string, Certificate certificate) {
    }

    public abstract void engineSetKeyEntry(String string, byte[] byArray, Certificate[] certificateArray) {
    }

    public abstract void engineSetKeyEntry(String string, Key key, char[] cArray, Certificate[] certificateArray) {
    }

    public abstract int engineSize() {
    }

    public abstract void engineStore(OutputStream outputStream, char[] cArray) {
    }
}

