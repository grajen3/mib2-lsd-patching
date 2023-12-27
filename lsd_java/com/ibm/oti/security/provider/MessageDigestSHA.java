/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.SHAOutputStream;
import java.security.MessageDigest;

public class MessageDigestSHA
extends MessageDigest
implements Cloneable {
    private SHAOutputStream shaStream = new SHAOutputStream();

    public MessageDigestSHA() {
        super("SHA-1");
    }

    @Override
    public Object clone() {
        MessageDigestSHA messageDigestSHA = (MessageDigestSHA)super.clone();
        messageDigestSHA.shaStream = (SHAOutputStream)this.shaStream.clone();
        return messageDigestSHA;
    }

    @Override
    protected byte[] engineDigest() {
        return this.shaStream.getHashAsBytes();
    }

    @Override
    protected int engineGetDigestLength() {
        return 20;
    }

    @Override
    protected void engineReset() {
        this.shaStream.reset();
    }

    @Override
    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.shaStream.write(byArray, n, n2);
    }

    @Override
    protected void engineUpdate(byte by) {
        this.shaStream.write(by);
    }
}

