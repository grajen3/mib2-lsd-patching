/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.OTI$1;
import java.security.AccessController;
import java.security.Provider;

public final class OTI
extends Provider {
    private static final String NAME;
    private static final double VERSION;
    private static final String INFO;

    public OTI() {
        super("OTI", 1.4, "OTI DSA key, parameter generation and signing; SHA-1 digest; SHA1PRNG SecureRandom; JKS keystore");
        this.registerServices();
    }

    private void registerServices() {
        AccessController.doPrivileged(new OTI$1(this));
    }
}

