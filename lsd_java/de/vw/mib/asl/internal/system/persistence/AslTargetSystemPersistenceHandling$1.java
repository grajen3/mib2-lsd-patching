/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.system.persistence.AslTargetSystemPersistenceHandling;

class AslTargetSystemPersistenceHandling$1
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ AslTargetSystemPersistenceHandling this$0;

    AslTargetSystemPersistenceHandling$1(AslTargetSystemPersistenceHandling aslTargetSystemPersistenceHandling) {
        this.this$0 = aslTargetSystemPersistenceHandling;
    }

    @Override
    public void registered(String string, int n) {
        this.this$0.connectToDsi();
    }
}

