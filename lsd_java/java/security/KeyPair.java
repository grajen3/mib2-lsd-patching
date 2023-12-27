/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;

public final class KeyPair
implements Serializable {
    private static final long serialVersionUID;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public PrivateKey getPrivate() {
        return this.privateKey;
    }

    public PublicKey getPublic() {
        return this.publicKey;
    }
}

