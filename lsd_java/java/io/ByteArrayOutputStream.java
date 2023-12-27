/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.OutputStream;

public class ByteArrayOutputStream
extends OutputStream {
    protected byte[] buf;
    protected int count;

    public ByteArrayOutputStream() {
        this.buf = new byte[32];
    }

    public ByteArrayOutputStream(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K005e"));
        }
        this.buf = new byte[n];
    }

    @Override
    public void close() {
        super.close();
    }

    private void expand(int n) {
        byte[] byArray = new byte[(this.count + n) * 2];
        System.arraycopy((Object)this.buf, 0, (Object)byArray, 0, this.count);
        this.buf = byArray;
    }

    public synchronized void reset() {
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        byte[] byArray = new byte[this.count];
        System.arraycopy((Object)this.buf, 0, (Object)byArray, 0, this.count);
        return byArray;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public String toString(String string) {
        return new String(this.buf, 0, this.count, string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public synchronized void write(byte[] byArray, int n, int n2) {
        if (this.buf == null) {
            return;
        }
        if (byArray == null) throw new NullPointerException(Msg.getString("K0047"));
        if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        if (this.count + n2 > this.buf.length) {
            this.expand(n2);
        }
        System.arraycopy((Object)byArray, n, (Object)this.buf, this.count, n2);
        this.count += n2;
    }

    @Override
    public synchronized void write(int n) {
        if (this.count >= this.buf.length) {
            this.expand(1);
        }
        this.buf[this.count++] = (byte)n;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.buf, 0, this.count);
    }
}

