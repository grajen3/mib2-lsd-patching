/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.codec.ByteArrayWriter;
import de.vw.mib.log4mib.internal.LogWriterManager;
import de.vw.mib.log4mib.internal.LoggingThread;

abstract class AbstractMessage
extends ByteArrayWriter {
    private static final int INITIALCAPACITY;
    static final int HEADER_LENGTH;
    static final long EMPTY_TIMESTAMP;
    static LoggingThread loggingThread;
    static LogWriterManager logWriter;
    static final byte POOLED;
    static final byte QUEUED;
    static final byte USABLE;
    private byte state = 0;
    AbstractMessage next;

    AbstractMessage() {
        super(256);
    }

    public byte[] getData() {
        return this.buffer;
    }

    public int getSize() {
        return this.count;
    }

    public abstract short getType() {
    }

    void checkLifecyleState(byte by) {
        if (by == 2) {
            if (this.state == 0) {
                new IllegalStateException("Illegal access to pooled log message!").printStackTrace();
            } else if (this.state == 1) {
                new IllegalStateException("Illegal access to queued log message!").printStackTrace();
            }
        } else if (by != this.state) {
            new IllegalStateException(new StringBuffer().append("Invalid lifecycle state! expected: ").append(by).append(", actual: ").append(this.state).toString()).printStackTrace();
        }
    }

    void checkLifecyleState(byte by, byte by2) {
        this.checkLifecyleState(by);
        this.state = by2;
    }

    abstract void dispatchMessage() {
    }

    abstract long getTime() {
    }

    void resetMessage() {
        this.reset();
        this.count = 5;
    }

    boolean shouldDiscardMessage() {
        return true;
    }
}

