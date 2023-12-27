/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.PersistenceStartupServiceImpl;

class PersistenceStartupServiceImpl$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ PersistenceStartupServiceImpl this$0;

    PersistenceStartupServiceImpl$1(PersistenceStartupServiceImpl persistenceStartupServiceImpl) {
        this.this$0 = persistenceStartupServiceImpl;
    }

    @Override
    public void onProfileChangeStarted() {
        this.this$0.storeProfileChangeModeOverride();
    }

    @Override
    public void onProfileChangeCompleted() {
    }
}

