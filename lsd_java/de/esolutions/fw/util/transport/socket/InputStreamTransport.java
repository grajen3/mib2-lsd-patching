/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.EndOfTransportException;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import java.io.InputStream;

public class InputStreamTransport
implements IByteTransport {
    private static final int BUFFER_SIZE;
    private ITransportDebug debug;
    private final InputStream in;

    public InputStreamTransport(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    @Override
    public void send(byte[] byArray, int n, Object object) {
    }

    @Override
    public int recv(byte[] byArray, Object object) {
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 266, byArray.length, object);
        }
        int n = this.in.read(byArray);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 274, n, object);
        }
        if (n == -1) {
            throw new EndOfTransportException("EOT");
        }
        return n;
    }

    @Override
    public void open() {
    }

    @Override
    public void close(boolean bl) {
        if (this.in != null) {
            this.in.close();
        }
    }

    @Override
    public int getSendBufferSize() {
        return 0;
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
        return new StringBuffer().append("[InputStream;").append(this.in).append("]").toString();
    }
}

