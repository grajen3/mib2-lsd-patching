/*
 * Decompiled with CFR 0.152.
 */
package java.security.interfaces;

import java.security.SecureRandom;
import java.security.interfaces.DSAParams;

public interface DSAKeyPairGenerator {
    default public void initialize(DSAParams dSAParams, SecureRandom secureRandom) {
    }

    default public void initialize(int n, boolean bl, SecureRandom secureRandom) {
    }
}

