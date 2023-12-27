/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupListener;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.PersistenceStartupServiceImpl;

class PersistenceStartupServiceImpl$2
implements Runnable {
    private final /* synthetic */ PersistenceStartupListener val$listener;
    private final /* synthetic */ PersistenceStartupServiceImpl this$0;

    PersistenceStartupServiceImpl$2(PersistenceStartupServiceImpl persistenceStartupServiceImpl, PersistenceStartupListener persistenceStartupListener) {
        this.this$0 = persistenceStartupServiceImpl;
        this.val$listener = persistenceStartupListener;
    }

    @Override
    public void run() {
        this.val$listener.notifyInitialStartupProfileSet();
    }
}

