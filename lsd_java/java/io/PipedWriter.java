/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Writer;

public class PipedWriter
extends Writer {
    private PipedReader dest;
    private boolean closed = false;

    public PipedWriter() {
    }

    public PipedWriter(PipedReader pipedReader) {
        super(pipedReader);
        this.connect(pipedReader);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.dest != null) {
                this.dest.done();
                this.dest = null;
            }
            this.closed = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void connect(PipedReader pipedReader) {
        Object object = this.lock;
        synchronized (object) {
            if (this.dest == null) {
                if (this.closed) {
                    throw new IOException(Msg.getString("K0078"));
                }
            } else {
                throw new IOException(Msg.getString("K0079"));
            }
            pipedReader.establishConnection(this);
            this.dest = pipedReader;
        }
    }

    @Override
    public void flush() {
        if (this.dest != null) {
            this.dest.flush();
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
                if (!this.closed) {
                    if (this.dest == null) {
                        throw new IOException(Msg.getString("K007b"));
                    }
                } else {
                    throw new IOException(Msg.getString("K0078"));
                }
                this.dest.receive(cArray, n, n2);
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
            if (!this.closed) {
                if (this.dest == null) {
                    throw new IOException(Msg.getString("K007b"));
                }
            } else {
                throw new IOException(Msg.getString("K0078"));
            }
            this.dest.receive((char)n);
        }
    }
}

