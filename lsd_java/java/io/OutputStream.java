/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;

public abstract class OutputStream {
    public void close() {
    }

    public void flush() {
    }

    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    public void write(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n >= 0 && n2 >= 0 && n2 <= byArray.length - n) {
            int n3 = n;
            while (n3 < n + n2) {
                this.write(byArray[n3]);
                ++n3;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        }
    }

    public abstract void write(int n) {
    }
}

