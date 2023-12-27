/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.internal.UpdateTaskRequest;

final class UpdateTaskRequestFactory
extends AbstractSynchronizedObjectPool {
    private static final int MAX_OBJECTS_TO_HOLD;

    UpdateTaskRequestFactory() {
        super(10);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new UpdateTaskRequest(this);
    }

    UpdateTaskRequest getUpdateTaskRequest(int n, int n2, String string, long l, boolean bl, Runnable runnable, Invoker invoker) {
        UpdateTaskRequest updateTaskRequest = (UpdateTaskRequest)this.borrowObject();
        updateTaskRequest.init(n, n2, string, l, bl, runnable, invoker);
        return updateTaskRequest;
    }
}

