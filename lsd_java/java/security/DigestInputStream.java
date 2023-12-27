/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class DigestInputStream
extends FilterInputStream {
    protected MessageDigest digest;
    private boolean on;

    public DigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream);
        this.setMessageDigest(messageDigest);
        this.on(true);
    }

    public MessageDigest getMessageDigest() {
        return this.digest;
    }

    public void on(boolean bl) {
        this.on = bl;
    }

    @Override
    public int read() {
        int n = super.read();
        if (this.on && n >= 0) {
            this.digest.engineUpdate((byte)n);
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = super.read(byArray, n, n2);
        if (this.on && n3 > 0) {
            this.digest.engineUpdate(byArray, n, n3);
        }
        return n3;
    }

    public void setMessageDigest(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[Digest Input Stream]");
        if (this.digest != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.digest.toString());
        }
        if (this.on) {
            stringBuffer.append(", <on>");
        } else {
            stringBuffer.append(", <off>");
        }
        return stringBuffer.toString();
    }
}

