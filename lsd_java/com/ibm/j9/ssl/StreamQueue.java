/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.StreamQueue$1;
import com.ibm.j9.ssl.StreamQueue$2;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamQueue {
    private byte[] buffer = new byte[1024];
    private int posRead = 0;
    private int posWrite = 0;
    private InputStream queueRead = new StreamQueue$1(this);
    private OutputStream queueWrite = new StreamQueue$2(this);

    public InputStream getReadStream() {
        return this.queueRead;
    }

    public OutputStream getWriteStream() {
        return this.queueWrite;
    }

    public int getCapacity() {
        return this.buffer.length - 1;
    }

    public int getSize() {
        if (this.posRead == this.posWrite) {
            return 0;
        }
        if (this.posRead < this.posWrite) {
            return this.posWrite - this.posRead;
        }
        return this.buffer.length - this.posRead + this.posWrite;
    }

    public int getUnusedCapacity() {
        return this.getCapacity() - this.getSize();
    }

    private int grow(int n) {
        n = n < this.buffer.length / 8 ? this.buffer.length / 8 : n;
        byte[] byArray = new byte[this.buffer.length + n];
        int n2 = this.getSize();
        this.queueRead.read(byArray, 0, n2);
        this.posRead = 0;
        this.posWrite = n2;
        this.buffer = byArray;
        return n;
    }

    static /* synthetic */ byte[] access$0(StreamQueue streamQueue) {
        return streamQueue.buffer;
    }

    static /* synthetic */ int access$1(StreamQueue streamQueue) {
        return streamQueue.posRead;
    }

    static /* synthetic */ void access$2(StreamQueue streamQueue, int n) {
        streamQueue.posRead = n;
    }

    static /* synthetic */ int access$3(StreamQueue streamQueue, int n) {
        return streamQueue.grow(n);
    }

    static /* synthetic */ int access$4(StreamQueue streamQueue) {
        return streamQueue.posWrite;
    }

    static /* synthetic */ void access$5(StreamQueue streamQueue, int n) {
        streamQueue.posWrite = n;
    }
}

