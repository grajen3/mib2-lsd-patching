/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataUpdate;

class ASLClientListImpl$InternalObserver
implements HMIListDataObserver {
    private final /* synthetic */ ASLClientListImpl this$0;

    ASLClientListImpl$InternalObserver(ASLClientListImpl aSLClientListImpl) {
        this.this$0 = aSLClientListImpl;
    }

    @Override
    public void onUpdate(HMIListDataUpdate hMIListDataUpdate) {
        this.this$0.execute(hMIListDataUpdate);
    }
}

