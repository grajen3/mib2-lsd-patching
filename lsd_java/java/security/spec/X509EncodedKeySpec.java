/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.security.spec.EncodedKeySpec;

public class X509EncodedKeySpec
extends EncodedKeySpec {
    public X509EncodedKeySpec(byte[] byArray) {
        super(byArray);
    }

    @Override
    public byte[] getEncoded() {
        return super.getEncoded();
    }

    @Override
    public final String getFormat() {
        return "X.509";
    }
}

