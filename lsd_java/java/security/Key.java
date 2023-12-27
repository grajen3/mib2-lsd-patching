/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;

public interface Key
extends Serializable {
    public static final long serialVersionUID;

    default public String getAlgorithm() {
    }

    default public byte[] getEncoded() {
    }

    default public String getFormat() {
    }
}

