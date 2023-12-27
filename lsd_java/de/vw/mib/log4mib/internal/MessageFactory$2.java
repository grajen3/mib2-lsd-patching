/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.internal.MessageFactory;
import de.vw.mib.log4mib.internal.PooledLogMessage;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;

class MessageFactory$2
extends AbstractSynchronizedObjectPool {
    private final /* synthetic */ MessageFactory this$0;

    MessageFactory$2(MessageFactory messageFactory, int n) {
        this.this$0 = messageFactory;
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new PooledLogMessage();
    }
}

