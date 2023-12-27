/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.NamespaceKeyPair;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;

class PersistableServiceImpl$4
implements PersistenceReadCallback {
    private final /* synthetic */ PersistenceServices val$internalServices;
    private final /* synthetic */ byte val$profileId;
    private final /* synthetic */ PersistableServiceImpl this$0;

    PersistableServiceImpl$4(PersistableServiceImpl persistableServiceImpl, PersistenceServices persistenceServices, byte by) {
        this.this$0 = persistableServiceImpl;
        this.val$internalServices = persistenceServices;
        this.val$profileId = by;
    }

    @Override
    public void onDataRead(int n, long l, int n2, byte[] byArray) {
        this.val$internalServices.getPersistenceLogger().trace(new StringBuffer().append("Got DSI Data, NS=").append(n).append("key=").append(l).toString());
        NamespaceKeyPair namespaceKeyPair = new NamespaceKeyPair(n, l);
        this.this$0.pendingDataToLoad.remove(namespaceKeyPair);
        if (this.this$0.pendingDataToLoad.isEmpty()) {
            this.this$0.changeProfileForLoadedModules(this.val$profileId);
        }
    }
}

