/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.backend.MessageWriter;
import de.vw.mib.log4mib.internal.LogWriterAdapter;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.log4mib.internal.PooledBinaryMessage;
import de.vw.mib.log4mib.internal.PooledLogMessage;

class MainLogger$2
extends LogWriterAdapter {
    private final /* synthetic */ MessageWriter val$writer;
    private final /* synthetic */ MainLogger this$0;

    MainLogger$2(MainLogger mainLogger, MessageWriter messageWriter) {
        this.this$0 = mainLogger;
        this.val$writer = messageWriter;
    }

    @Override
    void writeMessage(PooledLogMessage pooledLogMessage) {
        this.val$writer.writeBinaryMessage(pooledLogMessage.getTime(), pooledLogMessage.getType(), pooledLogMessage.getData(), pooledLogMessage.getSize());
    }

    @Override
    void writeMessage(PooledBinaryMessage pooledBinaryMessage) {
        this.val$writer.writeBinaryMessage(pooledBinaryMessage.getTime(), pooledBinaryMessage.getType(), pooledBinaryMessage.getData(), pooledBinaryMessage.getSize());
    }

    @Override
    void writeOSSystemLog(int n, String string) {
    }
}

