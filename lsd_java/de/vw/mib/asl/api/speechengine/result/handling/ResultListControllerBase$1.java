/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListControllerBase;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;

class ResultListControllerBase$1
implements AsyncCallback {
    private final /* synthetic */ ResultListControllerBase this$0;

    ResultListControllerBase$1(ResultListControllerBase resultListControllerBase) {
        this.this$0 = resultListControllerBase;
    }

    @Override
    public void onResponse(Object[] objectArray) {
        this.this$0.getASLList(this.this$0.getListIdTopLevel()).updateList(objectArray);
        this.this$0.notifyItemsRequested();
    }
}

