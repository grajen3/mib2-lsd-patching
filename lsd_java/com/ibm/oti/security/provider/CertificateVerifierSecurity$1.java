/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PrivilegedAction;

final class CertificateVerifierSecurity$1
implements PrivilegedAction {
    private final /* synthetic */ String val$filePath;

    CertificateVerifierSecurity$1(String string) {
        this.val$filePath = string;
    }

    @Override
    public Object run() {
        try {
            return new BufferedInputStream(new FileInputStream(this.val$filePath));
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }
}

