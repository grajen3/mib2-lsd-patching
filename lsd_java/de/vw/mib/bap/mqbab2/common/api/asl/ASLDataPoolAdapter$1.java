/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.asl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;

class ASLDataPoolAdapter$1
implements Runnable {
    private final /* synthetic */ ASLList val$aslList;
    private final /* synthetic */ ASLDataPoolAdapter this$0;

    ASLDataPoolAdapter$1(ASLDataPoolAdapter aSLDataPoolAdapter, ASLList aSLList) {
        this.this$0 = aSLDataPoolAdapter;
        this.val$aslList = aSLList;
    }

    @Override
    public void run() {
        this.this$0.listValueChanged(this.val$aslList.getListId());
    }
}

