/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$DelegatedExecutorService;

class Executors$FinalizableDelegatedExecutorService
extends Executors$DelegatedExecutorService {
    Executors$FinalizableDelegatedExecutorService(ExecutorService executorService) {
        super(executorService);
    }

    protected void finalize() {
        super.shutdown();
    }
}

