/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public final class SignedObject
implements Serializable {
    private static final long serialVersionUID;
    private byte[] content;
    private byte[] signature;
    private String thealgorithm;

    public SignedObject(Serializable serializable, PrivateKey privateKey, Signature signature) {
        this.thealgorithm = signature.getAlgorithm();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        this.content = byteArrayOutputStream.toByteArray();
        signature.initSign(privateKey);
        signature.update(this.content);
        this.signature = signature.sign();
    }

    public String getAlgorithm() {
        return this.thealgorithm;
    }

    public byte[] getSignature() {
        return (byte[])this.signature.clone();
    }

    public boolean verify(PublicKey publicKey, Signature signature) {
        signature.initVerify(publicKey);
        signature.update(this.content);
        return signature.verify(this.getSignature());
    }

    public Object getObject() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }
}

