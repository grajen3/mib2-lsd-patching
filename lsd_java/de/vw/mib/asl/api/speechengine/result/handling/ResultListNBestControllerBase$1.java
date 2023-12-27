/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;

class ResultListNBestControllerBase$1
implements AsyncCallback {
    private final /* synthetic */ ResultItem[] val$items;
    private final /* synthetic */ ResultListNBestControllerBase this$0;

    ResultListNBestControllerBase$1(ResultListNBestControllerBase resultListNBestControllerBase, ResultItem[] resultItemArray) {
        this.this$0 = resultListNBestControllerBase;
        this.val$items = resultItemArray;
    }

    @Override
    public void onResponse(Object[] objectArray) {
        if (this.val$items.length == 1) {
            this.this$0.updateViewModel(this.this$0.getListIdSelectedItem(), objectArray);
            this.this$0.notifyItemsRequested();
        } else {
            this.this$0.updateViewModel(this.this$0.getListIdTopLevel(), objectArray);
            this.this$0.notifyAmbiguousItemsRequested();
        }
    }
}

