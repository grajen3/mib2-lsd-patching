/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import com.ibm.oti.util.Msg;
import java.security.spec.KeySpec;

public abstract class EncodedKeySpec
implements KeySpec {
    private byte[] encodedKey;

    public EncodedKeySpec(byte[] byArray) {
        if (byArray == null) {
            throw new NullPointerException(Msg.getString("K039e"));
        }
        this.encodedKey = byArray;
    }

    public byte[] getEncoded() {
        return (byte[])this.encodedKey.clone();
    }

    public abstract String getFormat() {
    }
}

