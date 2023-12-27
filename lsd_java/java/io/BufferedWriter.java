/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.Writer;
import java.security.AccessController;

public class BufferedWriter
extends Writer {
    private Writer out;
    private char[] buf;
    private int pos;
    private final String lineSeparator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));

    public BufferedWriter(Writer writer) {
        super(writer);
        this.out = writer;
        this.buf = new char[8192];
    }

    public BufferedWriter(Writer writer, int n) {
        super(writer);
        if (n <= 0) {
            throw new IllegalArgumentException(Msg.getString("K0058"));
        }
        this.out = writer;
        this.buf = new char[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                this.flush();
                this.out.close();
                this.buf = null;
                this.out = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void flush() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                if (this.pos > 0) {
                    this.out.write(this.buf, 0, this.pos);
                }
            } else {
                throw new IOException(Msg.getString("K005d"));
            }
            this.pos = 0;
            this.out.flush();
        }
    }

    private boolean isOpen() {
        return this.out != null;
    }

    public void newLine() {
        this.write(this.lineSeparator, 0, this.lineSeparator.length());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                if (this.isOpen()) {
                    if (this.pos == 0 && n2 >= this.buf.length) {
                        this.out.write(cArray, n, n2);
                        return;
                    }
                    int n3 = this.buf.length - this.pos;
                    if (n2 < n3) {
                        n3 = n2;
                    }
                    if (n3 > 0) {
                        System.arraycopy((Object)cArray, n, (Object)this.buf, this.pos, n3);
                        this.pos += n3;
                    }
                    if (this.pos == this.buf.length) {
                        this.out.write(this.buf, 0, this.buf.length);
                        this.pos = 0;
                        if (n2 > n3) {
                            n += n3;
                            if ((n3 = n2 - n3) >= this.buf.length) {
                                this.out.write(cArray, n, n3);
                                return;
                            }
                            System.arraycopy((Object)cArray, n, (Object)this.buf, this.pos, n3);
                            this.pos += n3;
                        }
                    }
                } else {
                    throw new IOException(Msg.getString("K005d"));
                }
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
            if (this.isOpen()) {
                if (this.pos >= this.buf.length) {
                    this.out.write(this.buf, 0, this.buf.length);
                    this.pos = 0;
                }
            } else {
                throw new IOException(Msg.getString("K005d"));
            }
            this.buf[this.pos++] = (char)n;
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
                if (this.isOpen()) {
                    if (this.pos == 0 && n2 >= this.buf.length) {
                        char[] cArray = new char[n2];
                        string.getChars(n, n + n2, cArray, 0);
                        this.out.write(cArray, 0, n2);
                        return;
                    }
                    int n3 = this.buf.length - this.pos;
                    if (n2 < n3) {
                        n3 = n2;
                    }
                    if (n3 > 0) {
                        string.getChars(n, n + n3, this.buf, this.pos);
                        this.pos += n3;
                    }
                    if (this.pos == this.buf.length) {
                        this.out.write(this.buf, 0, this.buf.length);
                        this.pos = 0;
                        if (n2 > n3) {
                            n += n3;
                            if ((n3 = n2 - n3) >= this.buf.length) {
                                char[] cArray = new char[n2];
                                string.getChars(n, n + n3, cArray, 0);
                                this.out.write(cArray, 0, n3);
                                return;
                            }
                            string.getChars(n, n + n3, this.buf, this.pos);
                            this.pos += n3;
                        }
                    }
                } else {
                    throw new IOException(Msg.getString("K005d"));
                }
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }
}

