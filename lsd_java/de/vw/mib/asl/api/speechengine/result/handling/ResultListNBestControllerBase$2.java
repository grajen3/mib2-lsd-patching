/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;

class ResultListNBestControllerBase$2
implements AsyncCallback {
    private final /* synthetic */ ResultItem val$item;
    private final /* synthetic */ ResultListNBestControllerBase this$0;

    ResultListNBestControllerBase$2(ResultListNBestControllerBase resultListNBestControllerBase, ResultItem resultItem) {
        this.this$0 = resultListNBestControllerBase;
        this.val$item = resultItem;
    }

    @Override
    public void onResponse(Object[] objectArray) {
        boolean bl;
        this.this$0.updateViewModel(this.this$0.getListIdDetailLevel(), objectArray);
        int n = this.val$item.getGroupIndex();
        int n2 = this.this$0.getASLList(this.this$0.getListIdTopLevel()).getActivatedIndex();
        boolean bl2 = bl = n == n2;
        if (!bl) {
            this.this$0.getASLList(this.this$0.getListIdTopLevel()).setActiveIndex(n);
            this.this$0.notifyGroupExpanded(n);
        } else {
            this.this$0.getASLList(this.this$0.getListIdTopLevel()).setActiveIndex(-1);
            this.this$0.notifyGroupCollapsed(n);
        }
    }
}

