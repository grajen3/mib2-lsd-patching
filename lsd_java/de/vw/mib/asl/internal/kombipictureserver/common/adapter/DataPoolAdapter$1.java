/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.adapter;

import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.list.ASLList;

class DataPoolAdapter$1
implements Runnable {
    private final /* synthetic */ ASLList val$aslList;
    private final /* synthetic */ DataPoolAdapter this$0;

    DataPoolAdapter$1(DataPoolAdapter dataPoolAdapter, ASLList aSLList) {
        this.this$0 = dataPoolAdapter;
        this.val$aslList = aSLList;
    }

    @Override
    public void run() {
        this.this$0.listValueChanged(this.val$aslList.getListId());
    }
}

