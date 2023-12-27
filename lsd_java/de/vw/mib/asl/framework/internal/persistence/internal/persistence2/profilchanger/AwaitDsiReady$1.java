/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ReadyForProfileChangesListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitDsiReady;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;

class AwaitDsiReady$1
implements ReadyForProfileChangesListener {
    private final /* synthetic */ ProfileChanger$Context val$context;
    private final /* synthetic */ AwaitDsiReady this$0;

    AwaitDsiReady$1(AwaitDsiReady awaitDsiReady, ProfileChanger$Context profileChanger$Context) {
        this.this$0 = awaitDsiReady;
        this.val$context = profileChanger$Context;
    }

    @Override
    public void onReadyForProfileChanges(PersistenceModule persistenceModule) {
        this.val$context.markTaskFinished();
        this.this$0.trace(this.val$context, new StringBuffer().append("Module >").append(persistenceModule).append("< is ready for profile changes.").toString());
    }
}

