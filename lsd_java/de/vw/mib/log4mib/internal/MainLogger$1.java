/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.LogWriter;
import de.vw.mib.log4mib.internal.LogWriterAdapter;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.log4mib.internal.PooledLogMessage;

class MainLogger$1
extends LogWriterAdapter {
    private final /* synthetic */ LogWriter val$writer;
    private final /* synthetic */ MainLogger this$0;

    MainLogger$1(MainLogger mainLogger, LogWriter logWriter) {
        this.this$0 = mainLogger;
        this.val$writer = logWriter;
    }

    @Override
    void writeMessage(PooledLogMessage pooledLogMessage) {
        this.val$writer.write(pooledLogMessage);
    }
}

