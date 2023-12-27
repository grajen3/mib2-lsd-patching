/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.backend.TimestampProvider;
import de.vw.mib.log4mib.internal.MessageFactory$1;
import de.vw.mib.log4mib.internal.MessageFactory$2;
import de.vw.mib.log4mib.internal.PooledBinaryMessage;
import de.vw.mib.log4mib.internal.PooledLogMessage;
import de.vw.mib.pool.ObjectPool;

final class MessageFactory {
    private final ObjectPool debugMessagePool;
    private final ObjectPool logMessagePool;
    private byte messageCount = 0;
    private TimestampProvider timestampProvider = TimestampProvider.DEFAULT;

    MessageFactory(int n) {
        this.debugMessagePool = new MessageFactory$1(this, n);
        this.logMessagePool = new MessageFactory$2(this, n);
    }

    BinaryMessage createBinaryMessage(short s) {
        PooledBinaryMessage pooledBinaryMessage = (PooledBinaryMessage)this.debugMessagePool.borrowObject();
        pooledBinaryMessage.setMetaData(s, this.getCurrentTime());
        return pooledBinaryMessage;
    }

    PooledLogMessage createLogMessage(int n, int n2, int n3) {
        PooledLogMessage pooledLogMessage = (PooledLogMessage)this.logMessagePool.borrowObject();
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        pooledLogMessage.setMetaData(by, this.getCurrentTime(), n, n2, n3, this.getThreadId(), this.getInvocationContext());
        return pooledLogMessage;
    }

    PooledLogMessage createLogMessage(int n, int n2, int n3, String string) {
        PooledLogMessage pooledLogMessage = (PooledLogMessage)this.logMessagePool.borrowObject();
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        pooledLogMessage.setMetaData(by, this.getCurrentTime(), n, n2, n3, this.getThreadId(), this.getInvocationContext());
        pooledLogMessage.append(string);
        return pooledLogMessage;
    }

    long getCurrentTime() {
        return this.timestampProvider.getTimestamp();
    }

    InvocationContext getInvocationContext() {
        return InvocationContext.getCurrentInvocationContext(null);
    }

    int getThreadId() {
        return Thread.currentThread().getName().hashCode();
    }

    void releaseObject(PooledBinaryMessage pooledBinaryMessage) {
        this.debugMessagePool.releaseObject(pooledBinaryMessage);
    }

    void releaseObject(PooledLogMessage pooledLogMessage) {
        this.logMessagePool.releaseObject(pooledLogMessage);
    }

    void setTimestampProvider(TimestampProvider timestampProvider) {
        this.timestampProvider = timestampProvider != null ? timestampProvider : TimestampProvider.DEFAULT;
    }
}

