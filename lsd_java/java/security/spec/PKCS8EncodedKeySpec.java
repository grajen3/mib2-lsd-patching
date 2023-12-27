/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.security.spec.EncodedKeySpec;

public class PKCS8EncodedKeySpec
extends EncodedKeySpec {
    public PKCS8EncodedKeySpec(byte[] byArray) {
        super(byArray);
    }

    @Override
    public byte[] getEncoded() {
        return super.getEncoded();
    }

    @Override
    public final String getFormat() {
        return "PKCS#8";
    }
}

