/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.StreamQueue;
import java.io.InputStream;

final class StreamQueue$1
extends InputStream {
    final /* synthetic */ StreamQueue this$0;

    StreamQueue$1(StreamQueue streamQueue) {
        this.this$0 = streamQueue;
    }

    @Override
    public int available() {
        return this.this$0.getSize();
    }

    @Override
    public int read() {
        byte[] byArray = new byte[1];
        this.read(byArray, 0, 1);
        return byArray[0] & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (n2 > this.available()) {
            n2 = this.available();
        }
        int n3 = n2 > StreamQueue.access$0(this.this$0).length - StreamQueue.access$1(this.this$0) ? StreamQueue.access$0(this.this$0).length - StreamQueue.access$1(this.this$0) : n2;
        System.arraycopy((Object)StreamQueue.access$0(this.this$0), StreamQueue.access$1(this.this$0), (Object)byArray, n, n3);
        if (n3 < n2) {
            System.arraycopy((Object)StreamQueue.access$0(this.this$0), 0, (Object)byArray, n + n3, n2 - n3);
            StreamQueue.access$2(this.this$0, n2 - n3);
        } else {
            StreamQueue streamQueue = this.this$0;
            StreamQueue.access$2(streamQueue, StreamQueue.access$1(streamQueue) + n2);
        }
        return n2;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }
}

