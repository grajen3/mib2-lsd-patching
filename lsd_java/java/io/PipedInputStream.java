/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PipedOutputStream;

public class PipedInputStream
extends InputStream {
    private Thread lastReader;
    private Thread lastWriter;
    private boolean isClosed = false;
    protected byte[] buffer;
    protected int in = -1;
    protected int out = 0;
    protected static final int PIPE_SIZE;
    boolean isConnected = false;

    public PipedInputStream() {
    }

    public PipedInputStream(PipedOutputStream pipedOutputStream) {
        this.connect(pipedOutputStream);
    }

    @Override
    public synchronized int available() {
        if (this.buffer == null || this.in == -1) {
            return 0;
        }
        return this.in <= this.out ? this.buffer.length - this.out + this.in : this.in - this.out;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        PipedInputStream pipedInputStream = this;
        synchronized (pipedInputStream) {
            if (this.buffer != null) {
                this.buffer = null;
            }
        }
    }

    public void connect(PipedOutputStream pipedOutputStream) {
        pipedOutputStream.connect(this);
    }

    @Override
    public synchronized int read() {
        if (this.isConnected) {
            if (this.buffer != null) {
                byte by;
                this.lastReader = Thread.currentThread();
                try {
                    by = 1;
                    while (this.in == -1) {
                        if (this.isClosed) {
                            return -1;
                        }
                        if (by == 0 && this.lastWriter != null && !this.lastWriter.isAlive()) {
                            throw new IOException(Msg.getString("K0076"));
                        }
                        by = 0;
                        super.notifyAll();
                        super.wait(0);
                    }
                }
                catch (InterruptedException interruptedException) {
                    throw new InterruptedIOException();
                }
                by = this.buffer[this.out++];
                if (this.out == this.buffer.length) {
                    this.out = 0;
                }
                if (this.out == this.in) {
                    this.in = -1;
                    this.out = 0;
                }
                return by & 0xFF;
            }
            throw new IOException(Msg.getString("K0075"));
        }
        throw new IOException(Msg.getString("K0074"));
    }

    @Override
    public synchronized int read(byte[] byArray, int n, int n2) {
        if (byArray != null && n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
            if (n2 == 0) {
                return 0;
            }
            if (this.isConnected && this.buffer != null) {
                int n3;
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
                        super.wait(0);
                    }
                }
                catch (InterruptedException interruptedException) {
                    throw new InterruptedIOException();
                }
                n3 = 0;
                if (this.out >= this.in) {
                    n3 = n2 > this.buffer.length - this.out ? this.buffer.length - this.out : n2;
                    System.arraycopy((Object)this.buffer, this.out, (Object)byArray, n, n3);
                    this.out += n3;
                    if (this.out == this.buffer.length) {
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
                n3 = this.in - this.out > n2 - n4 ? n2 - n4 : this.in - this.out;
                System.arraycopy((Object)this.buffer, this.out, (Object)byArray, n + n4, n3);
                this.out += n3;
                if (this.out == this.in) {
                    this.in = -1;
                    this.out = 0;
                }
                return n4 + n3;
            }
            if (!this.isConnected) {
                throw new IOException(Msg.getString("K0074"));
            }
            throw new IOException(Msg.getString("K0075"));
        }
        if (byArray == null) {
            throw new NullPointerException();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    protected synchronized void receive(int n) {
        if (this.buffer != null && !this.isClosed) {
            this.lastWriter = Thread.currentThread();
            try {
                if (this.out == this.in) {
                    do {
                        super.notifyAll();
                        super.wait(0);
                        if (this.lastReader == null || this.lastReader.isAlive()) continue;
                        throw new IOException(Msg.getString("K0076"));
                    } while (this.buffer != null && this.out == this.in);
                } else if (this.lastReader != null && !this.lastReader.isAlive()) {
                    throw new IOException(Msg.getString("K0076"));
                }
            }
            catch (InterruptedException interruptedException) {
                throw new InterruptedIOException();
            }
            if (this.buffer != null) {
                if (this.in == -1) {
                    this.in = 0;
                }
                this.buffer[this.in++] = (byte)n;
                if (this.in == this.buffer.length) {
                    this.in = 0;
                }
                return;
            }
        }
        throw new IOException(Msg.getString("K0078"));
    }

    synchronized void done() {
        this.isClosed = true;
        super.notifyAll();
    }
}

