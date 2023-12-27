/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public class ClientContext {
    private IOException ioException;
    private TransportException transportException;

    public synchronized void setIOException(IOException iOException) {
        this.ioException = iOException;
    }

    public synchronized void setTransportException(TransportException transportException) {
        this.transportException = transportException;
    }

    public synchronized void throwPendingException() {
        IOException iOException = null;
        if (this.ioException != null) {
            iOException = this.ioException;
            this.ioException = null;
        }
        TransportException transportException = null;
        if (this.transportException != null) {
            transportException = this.transportException;
            this.transportException = null;
        }
        if (iOException != null) {
            throw iOException;
        }
        if (transportException != null) {
            throw transportException;
        }
    }
}

