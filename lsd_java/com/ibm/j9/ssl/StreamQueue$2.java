/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.StreamQueue;
import java.io.OutputStream;

final class StreamQueue$2
extends OutputStream {
    final /* synthetic */ StreamQueue this$0;

    StreamQueue$2(StreamQueue streamQueue) {
        this.this$0 = streamQueue;
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (this.this$0.getUnusedCapacity() < n2) {
            StreamQueue.access$3(this.this$0, n2 - this.this$0.getUnusedCapacity());
        }
        int n3 = n2 > StreamQueue.access$0(this.this$0).length - StreamQueue.access$4(this.this$0) ? StreamQueue.access$0(this.this$0).length - StreamQueue.access$4(this.this$0) : n2;
        System.arraycopy((Object)byArray, n, (Object)StreamQueue.access$0(this.this$0), StreamQueue.access$4(this.this$0), n3);
        if (n3 < n2) {
            System.arraycopy((Object)byArray, n + n3, (Object)StreamQueue.access$0(this.this$0), 0, n2 - n3);
            StreamQueue.access$5(this.this$0, n2 - n3);
        } else {
            StreamQueue streamQueue = this.this$0;
            StreamQueue.access$5(streamQueue, StreamQueue.access$4(streamQueue) + n2);
        }
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(int n) {
        byte[] byArray = new byte[]{(byte)n};
        this.write(byArray, 0, 1);
    }
}

