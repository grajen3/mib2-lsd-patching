/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.security.spec.AlgorithmParameterSpec;

public class PSSParameterSpec
implements AlgorithmParameterSpec {
    private int saltLength = 0;

    public PSSParameterSpec(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Salt length < 0 ");
        }
        this.saltLength = n;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}

