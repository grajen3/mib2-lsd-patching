/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.OutputStream;

public class FilterOutputStream
extends OutputStream {
    protected OutputStream out;

    public FilterOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override
    public void close() {
        try {
            this.flush();
        }
        finally {
            this.out.close();
        }
    }

    @Override
    public void flush() {
        this.out.flush();
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n >= 0 && n2 >= 0 && n2 <= byArray.length - n) {
            int n3 = 0;
            while (n3 < n2) {
                this.write(byArray[n + n3]);
                ++n3;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        }
    }

    @Override
    public void write(int n) {
        this.out.write(n);
    }
}

