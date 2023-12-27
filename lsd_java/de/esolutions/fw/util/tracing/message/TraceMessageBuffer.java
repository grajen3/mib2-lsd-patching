/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.message;

import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.RingBuffer;

public class TraceMessageBuffer {
    private RingBuffer buffer;
    private int seqNum;
    private int numEntries;
    private int numBytes;

    public TraceMessageBuffer(int n) {
        this.buffer = new RingBuffer(n);
        this.seqNum = 0;
    }

    public synchronized boolean put(ITraceMessage iTraceMessage, boolean bl) {
        if (!bl) {
            while (this.buffer.isFull()) {
                try {
                    super.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        iTraceMessage.setSeqNum(this.seqNum++);
        Object object = this.buffer.peekNext();
        if (object != null) {
            ITraceMessage iTraceMessage2 = (ITraceMessage)object;
            this.numBytes -= iTraceMessage2.getMessageSize();
        } else {
            ++this.numEntries;
        }
        this.numBytes += iTraceMessage.getMessageSize();
        return this.buffer.put(iTraceMessage);
    }

    public synchronized void skipEntry() {
        ++this.seqNum;
    }

    public synchronized void skipEntries(int n) {
        this.seqNum += n;
    }

    public synchronized int getCurrentSequenceNumber() {
        return this.seqNum - 1;
    }

    public synchronized ITraceMessage[] getMessageRange(int n, int n2) {
        int n3 = this.buffer.size();
        if (n3 == 0) {
            return null;
        }
        int n4 = n3;
        int n5 = 0;
        ITraceMessage iTraceMessage = (ITraceMessage)this.buffer.peekOldest();
        if (iTraceMessage == null) {
            return null;
        }
        int n6 = iTraceMessage.getSeqNum();
        while (n6 < n) {
            ++n5;
            if (--n4 == 0) {
                return null;
            }
            iTraceMessage = (ITraceMessage)this.buffer.peekAt(n5);
            if (iTraceMessage == null) {
                return null;
            }
            n6 = iTraceMessage.getSeqNum();
        }
        int n7 = n6;
        for (int i2 = n5; i2 < n3; ++i2) {
            ITraceMessage iTraceMessage2 = (ITraceMessage)this.buffer.peekAt(i2);
            if (iTraceMessage2 != null && (iTraceMessage2.getEpoch() > n2 || iTraceMessage2.getSeqNum() != n7)) {
                n4 -= n3 - i2;
                break;
            }
            ++n7;
        }
        if (n4 == 0) {
            return null;
        }
        ITraceMessage[] iTraceMessageArray = new ITraceMessage[n4];
        for (int i3 = 0; i3 < n4; ++i3) {
            iTraceMessageArray[i3] = (ITraceMessage)this.buffer.peekAt(i3 + n5);
        }
        return iTraceMessageArray;
    }

    public synchronized ITraceMessage[] getAll() {
        int n = this.buffer.size();
        if (n == 0) {
            return null;
        }
        ITraceMessage[] iTraceMessageArray = new ITraceMessage[n];
        int n2 = 0;
        while (!this.buffer.isEmpty()) {
            iTraceMessageArray[n2++] = (ITraceMessage)this.buffer.getOldest();
        }
        this.numEntries = 0;
        this.numBytes = 0;
        return iTraceMessageArray;
    }

    public synchronized void dropAll() {
        this.buffer.dropAll();
        this.numEntries = 0;
        this.numBytes = 0;
    }

    public synchronized int dropUpToSeqNum(int n) {
        ITraceMessage iTraceMessage;
        int n2 = 0;
        while (!(this.buffer.isEmpty() || (iTraceMessage = (ITraceMessage)this.buffer.peekOldest()) != null && iTraceMessage.getSeqNum() >= n)) {
            --this.numEntries;
            this.numBytes -= iTraceMessage.getMessageSize();
            this.buffer.getOldest();
            ++n2;
        }
        if (n2 > 0) {
            super.notifyAll();
        }
        return n2;
    }

    public synchronized boolean resize(int n) {
        while (this.buffer.size() > 0 && this.buffer.size() > n) {
            ITraceMessage iTraceMessage = (ITraceMessage)this.buffer.peekOldest();
            --this.numEntries;
            this.numBytes -= iTraceMessage.getMessageSize();
            this.buffer.getOldest();
        }
        return this.buffer.resize(n);
    }

    public synchronized boolean isEmpty() {
        return this.buffer.isEmpty();
    }

    public synchronized int size() {
        return this.buffer.size();
    }

    public synchronized int capacity() {
        return this.buffer.capacity();
    }

    public synchronized int[] getNumEntriesAndBytes() {
        return new int[]{this.numEntries, this.numBytes};
    }
}

