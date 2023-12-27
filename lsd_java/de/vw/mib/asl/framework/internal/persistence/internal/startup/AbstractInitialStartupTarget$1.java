/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.AbstractInitialStartupTarget;

class AbstractInitialStartupTarget$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ PersistableService val$persistableService;
    private final /* synthetic */ AslPersistenceSyncApi val$syncApi;
    private final /* synthetic */ AbstractInitialStartupTarget this$0;

    AbstractInitialStartupTarget$1(AbstractInitialStartupTarget abstractInitialStartupTarget, PersistableService persistableService, AslPersistenceSyncApi aslPersistenceSyncApi) {
        this.this$0 = abstractInitialStartupTarget;
        this.val$persistableService = persistableService;
        this.val$syncApi = aslPersistenceSyncApi;
    }

    @Override
    public void onProfileChangeStarted() {
    }

    @Override
    public void onProfileChangeCompleted() {
        byte by = this.val$persistableService.getActiveProfile();
        this.this$0.writeInitialProfile(by, this.val$syncApi);
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append("$GlobalProfileChangeListener").toString();
    }
}

