/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class BufferedOutputStream
extends FilterOutputStream {
    protected byte[] buf;
    protected int count;

    public BufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.buf = new byte[512];
    }

    public BufferedOutputStream(OutputStream outputStream, int n) {
        super(outputStream);
        if (n <= 0) {
            throw new IllegalArgumentException(Msg.getString("K0058"));
        }
        this.buf = new byte[n];
    }

    @Override
    public synchronized void flush() {
        if (this.count > 0) {
            this.out.write(this.buf, 0, this.count);
        }
        this.count = 0;
        this.out.flush();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public synchronized void write(byte[] byArray, int n, int n2) {
        if (byArray == null) throw new NullPointerException(Msg.getString("K0047"));
        if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        if (this.count == 0 && n2 >= this.buf.length) {
            this.out.write(byArray, n, n2);
            return;
        }
        int n3 = this.buf.length - this.count;
        if (n2 < n3) {
            n3 = n2;
        }
        if (n3 > 0) {
            System.arraycopy((Object)byArray, n, (Object)this.buf, this.count, n3);
            this.count += n3;
        }
        if (this.count != this.buf.length) return;
        this.out.write(this.buf, 0, this.buf.length);
        this.count = 0;
        if (n2 <= n3) return;
        n += n3;
        if ((n3 = n2 - n3) >= this.buf.length) {
            this.out.write(byArray, n, n3);
            return;
        } else {
            System.arraycopy((Object)byArray, n, (Object)this.buf, this.count, n3);
            this.count += n3;
        }
    }

    @Override
    public synchronized void write(int n) {
        if (this.count == this.buf.length) {
            this.out.write(this.buf, 0, this.count);
            this.count = 0;
        }
        this.buf[this.count++] = (byte)n;
    }
}

