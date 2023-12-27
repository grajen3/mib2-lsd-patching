/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.debug.ITransportDebug;

public interface ITransport {
    default public void send(IWriter iWriter) {
    }

    default public void sendSync(IWriter iWriter) {
    }

    default public IReadable recv() {
    }

    default public void flush() {
    }

    default public void open() {
    }

    default public boolean isOpen() {
    }

    default public void close(boolean bl) {
    }

    default public int maxMsgSize() {
    }

    default public boolean keepsRecordBoundaries() {
    }

    default public boolean isReliable() {
    }

    default public boolean detectsPeerReset() {
    }

    default public String getDescription() {
    }

    default public void setDebug(ITransportDebug iTransportDebug) {
    }
}

