/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import java.security.DigestException;

public abstract class MessageDigestSpi {
    public Object clone() {
        return super.clone();
    }

    protected abstract byte[] engineDigest() {
    }

    protected int engineDigest(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            throw new IllegalArgumentException(Msg.getString("K0047"));
        }
        if (byArray.length < n + n2) {
            throw new IllegalArgumentException(Msg.getString("K03a2"));
        }
        byte[] byArray2 = this.engineDigest();
        if (byArray2.length > byArray.length - n) {
            throw new DigestException(Msg.getString("K03a2"));
        }
        if (n2 < byArray2.length) {
            throw new DigestException("Digest length exceeds passed value");
        }
        int n3 = n2;
        if (byArray2.length < n3) {
            n3 = byArray2.length;
        }
        System.arraycopy((Object)byArray2, 0, (Object)byArray, n, n3);
        this.engineReset();
        return n3;
    }

    protected int engineGetDigestLength() {
        return 0;
    }

    protected abstract void engineReset() {
    }

    protected abstract void engineUpdate(byte[] byArray, int n, int n2) {
    }

    protected abstract void engineUpdate(byte by) {
    }
}

