/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.operation.TaskPool;

class TaskPool$1
implements Runnable {
    private final /* synthetic */ int val$worker;
    private final /* synthetic */ Runnable val$callback;
    private final /* synthetic */ TaskPool this$0;

    TaskPool$1(TaskPool taskPool, int n, Runnable runnable) {
        this.this$0 = taskPool;
        this.val$worker = n;
        this.val$callback = runnable;
    }

    @Override
    public void run() {
        this.this$0.releaseWorker(this.val$worker);
        this.val$callback.run();
    }
}

