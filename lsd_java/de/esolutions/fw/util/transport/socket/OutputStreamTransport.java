/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import java.io.OutputStream;

public class OutputStreamTransport
implements IByteTransport {
    private static final int BUFFER_SIZE;
    private ITransportDebug debug;
    private final OutputStream out;

    public OutputStreamTransport(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    @Override
    public void send(byte[] byArray, int n, Object object) {
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 265, n, object);
        }
        this.out.write(byArray, 0, n);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 273, n, object);
        }
    }

    @Override
    public int recv(byte[] byArray, Object object) {
        return 0;
    }

    @Override
    public void open() {
    }

    @Override
    public void close(boolean bl) {
        this.out.close();
    }

    @Override
    public int getSendBufferSize() {
        return 8192;
    }

    @Override
    public int getReceiveBufferSize() {
        return 0;
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
        return new StringBuffer().append("[OutputStream;").append(this.out).append("]").toString();
    }
}

