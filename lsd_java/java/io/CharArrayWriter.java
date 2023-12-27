/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.Writer;

public class CharArrayWriter
extends Writer {
    protected char[] buf;
    protected int count;

    public CharArrayWriter() {
        this.buf = new char[32];
        this.lock = this.buf;
    }

    public CharArrayWriter(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K005e"));
        }
        this.buf = new char[n];
        this.lock = this.buf;
    }

    @Override
    public void close() {
    }

    private void expand(int n) {
        if (this.count + n <= this.buf.length) {
            return;
        }
        char[] cArray = new char[this.buf.length + 2 * n];
        System.arraycopy((Object)this.buf, 0, (Object)cArray, 0, this.count);
        this.buf = cArray;
    }

    @Override
    public void flush() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        Object object = this.lock;
        synchronized (object) {
            this.count = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int size() {
        Object object = this.lock;
        synchronized (object) {
            return this.count;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public char[] toCharArray() {
        Object object = this.lock;
        synchronized (object) {
            char[] cArray = new char[this.count];
            System.arraycopy((Object)this.buf, 0, (Object)cArray, 0, this.count);
            return cArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.lock;
        synchronized (object) {
            return new String(this.buf, 0, this.count);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                this.expand(n2);
                System.arraycopy((Object)cArray, n, (Object)this.buf, this.count, n2);
                this.count += n2;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            this.expand(1);
            this.buf[this.count++] = (char)n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String string, int n, int n2) {
        if (n >= 0 && n <= string.length() && n2 >= 0 && n2 <= string.length() - n) {
            Object object = this.lock;
            synchronized (object) {
                this.expand(n2);
                string.getChars(n, n + n2, this.buf, this.count);
                this.count += n2;
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(Writer writer) {
        Object object = this.lock;
        synchronized (object) {
            writer.write(this.buf, 0, this.count);
        }
    }
}

