/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PipedWriter;
import java.io.Reader;

public class PipedReader
extends Reader {
    private Thread lastReader;
    private Thread lastWriter;
    private boolean isClosed = false;
    private char[] data = new char[1024];
    private int in = -1;
    private int out = 0;
    private static final int PIPE_SIZE;
    private boolean isConnected = false;

    public PipedReader() {
    }

    public PipedReader(PipedWriter pipedWriter) {
        this();
        this.connect(pipedWriter);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.data != null) {
                this.data = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void connect(PipedWriter pipedWriter) {
        Object object = this.lock;
        synchronized (object) {
            pipedWriter.connect(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void establishConnection(PipedWriter pipedWriter) {
        Object object = this.lock;
        synchronized (object) {
            if (this.data == null) {
                throw new IOException(Msg.getString("K0078"));
            }
            if (this.isConnected) {
                throw new IOException(Msg.getString("K007a"));
            }
            this.isConnected = true;
        }
    }

    @Override
    public int read() {
        char[] cArray = new char[1];
        int n = this.read(cArray, 0, 1);
        return n != -1 ? cArray[0] : n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int read(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                if (this.isConnected && this.data != null) {
                    int n3;
                    if (n2 == 0) {
                        return 0;
                    }
                    this.lastReader = Thread.currentThread();
                    try {
                        n3 = 1;
                        while (this.in == -1) {
                            if (this.isClosed) {
                                return -1;
                            }
                            if (n3 == 0 && this.lastWriter != null && !this.lastWriter.isAlive()) {
                                throw new IOException(Msg.getString("K0076"));
                            }
                            n3 = 0;
                            super.notifyAll();
                            this.lock.wait(0);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        throw new InterruptedIOException();
                    }
                    n3 = 0;
                    if (this.out >= this.in) {
                        n3 = n2 > this.data.length - this.out ? this.data.length - this.out : n2;
                        System.arraycopy((Object)this.data, this.out, (Object)cArray, n, n3);
                        this.out += n3;
                        if (this.out == this.data.length) {
                            this.out = 0;
                        }
                        if (this.out == this.in) {
                            this.in = -1;
                            this.out = 0;
                        }
                    }
                    if (n3 == n2 || this.in == -1) {
                        return n3;
                    }
                    int n4 = n3;
                    n3 = this.in - this.out > n2 - n3 ? n2 - n3 : this.in - this.out;
                    System.arraycopy((Object)this.data, this.out, (Object)cArray, n + n4, n3);
                    this.out += n3;
                    if (this.out == this.in) {
                        this.in = -1;
                        this.out = 0;
                    }
                    return n4 + n3;
                }
                if (!this.isConnected) {
                    throw new IOException(Msg.getString("K007b"));
                }
                throw new IOException(Msg.getString("K0078"));
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean ready() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isConnected) {
                if (this.data != null) {
                    return this.in != -1;
                }
                throw new IOException(Msg.getString("K0078"));
            }
            throw new IOException(Msg.getString("K007b"));
        }
    }

    void receive(char c2) {
        Object object = this.lock;
        synchronized (object) {
            if (this.data != null) {
                this.lastWriter = Thread.currentThread();
                try {
                    while (this.data != null && this.out == this.in) {
                        super.notifyAll();
                        super.wait(0);
                        if (this.lastReader == null || this.lastReader.isAlive()) continue;
                        throw new IOException(Msg.getString("K0076"));
                    }
                }
                catch (InterruptedException interruptedException) {
                    throw new InterruptedIOException();
                }
                if (this.data != null) {
                    if (this.in == -1) {
                        this.in = 0;
                    }
                    this.data[this.in++] = c2;
                    if (this.in == this.data.length) {
                        this.in = 0;
                    }
                    return;
                }
            }
            throw new IOException(Msg.getString("K0078"));
        }
    }

    void receive(char[] cArray, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            if (this.data != null) {
                this.lastWriter = Thread.currentThread();
                while (n2 > 0) {
                    int n3;
                    try {
                        while (this.data != null && this.out == this.in) {
                            super.notifyAll();
                            super.wait(0);
                            if (this.lastReader == null || this.lastReader.isAlive()) continue;
                            throw new IOException(Msg.getString("K0076"));
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        throw new InterruptedIOException();
                    }
                    if (this.data == null) break;
                    if (this.in == -1) {
                        this.in = 0;
                    }
                    if (this.in >= this.out) {
                        n3 = this.data.length - this.in;
                        if (n2 < n3) {
                            n3 = n2;
                        }
                        System.arraycopy((Object)cArray, n, (Object)this.data, this.in, n3);
                        n += n3;
                        n2 -= n3;
                        this.in += n3;
                        if (this.in == this.data.length) {
                            this.in = 0;
                        }
                    }
                    if (n2 <= 0 || this.in == this.out) continue;
                    n3 = this.out - this.in;
                    if (n2 < n3) {
                        n3 = n2;
                    }
                    System.arraycopy((Object)cArray, n, (Object)this.data, this.in, n3);
                    n += n3;
                    n2 -= n3;
                    this.in += n3;
                }
                if (n2 == 0) {
                    return;
                }
            }
            throw new IOException(Msg.getString("K0078"));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void done() {
        Object object = this.lock;
        synchronized (object) {
            this.isClosed = true;
            super.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void flush() {
        Object object = this.lock;
        synchronized (object) {
            super.notifyAll();
        }
    }
}

