/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.MessageDigest;
import java.security.MessageDigestSpi;

class MessageDigest$Wrapper
extends MessageDigest {
    MessageDigestSpi providerDigest;

    MessageDigest$Wrapper(MessageDigestSpi messageDigestSpi, String string) {
        super(string);
        this.providerDigest = messageDigestSpi;
    }

    @Override
    public Object clone() {
        MessageDigest$Wrapper messageDigest$Wrapper = new MessageDigest$Wrapper((MessageDigestSpi)this.providerDigest.clone(), this.getAlgorithm());
        messageDigest$Wrapper.setProvider(this.getProvider());
        return messageDigest$Wrapper;
    }

    @Override
    protected byte[] engineDigest() {
        return this.providerDigest.engineDigest();
    }

    @Override
    protected void engineReset() {
        this.providerDigest.engineReset();
    }

    @Override
    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.providerDigest.engineUpdate(byArray, n, n2);
    }

    @Override
    protected void engineUpdate(byte by) {
        this.providerDigest.engineUpdate(by);
    }

    @Override
    protected int engineGetDigestLength() {
        return this.providerDigest.engineGetDigestLength();
    }
}

