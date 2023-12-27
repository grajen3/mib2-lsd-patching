/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.EndOfTransportException;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileByteTransport
implements IByteTransport {
    private ITransportDebug debug;
    private static final int BUFFER_SIZE;
    private String fileName;
    private RandomAccessFile file;
    private boolean connected;

    public FileByteTransport(String string) {
        this.fileName = string;
        this.connected = false;
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    @Override
    public void open() {
        if (this.file == null) {
            this.file = new RandomAccessFile(this.fileName, "rw");
            this.connected = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close(boolean bl) {
        if (this.connected) {
            try {
                this.file.close();
            }
            finally {
                this.file = null;
                this.connected = false;
            }
        }
    }

    @Override
    public int recv(byte[] byArray, Object object) {
        if (this.file == null) {
            throw new TransportException("recieve without open");
        }
        int n = 0;
        if (this.debug != null) {
            try {
                this.debug.log(System.currentTimeMillis(), 266, 0, object);
                n = this.file.read(byArray);
                this.debug.log(System.currentTimeMillis(), 274, n, object);
            }
            catch (IOException iOException) {
                this.debug.log(System.currentTimeMillis(), 290, 1, object);
                throw iOException;
            }
        } else {
            n = this.file.read(byArray);
        }
        if (n == -1) {
            throw new EndOfTransportException("EOT");
        }
        return n;
    }

    @Override
    public void send(byte[] byArray, int n, Object object) {
        if (this.connected) {
            if (this.debug != null) {
                try {
                    this.debug.log(System.currentTimeMillis(), 265, n, object);
                    this.file.write(byArray, 0, n);
                    this.debug.log(System.currentTimeMillis(), 273, n, object);
                }
                catch (IOException iOException) {
                    this.debug.log(System.currentTimeMillis(), 289, 1, object);
                    throw iOException;
                }
            } else {
                this.file.write(byArray, 0, n);
            }
        }
    }

    public boolean isConnected() {
        return this.connected;
    }

    @Override
    public int getSendBufferSize() {
        return 8192;
    }

    @Override
    public int getReceiveBufferSize() {
        return 8192;
    }

    @Override
    public boolean isReliable() {
        return true;
    }

    @Override
    public boolean detectsPeerReset() {
        return true;
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[File:").append(this.fileName).append("]").toString();
    }
}

