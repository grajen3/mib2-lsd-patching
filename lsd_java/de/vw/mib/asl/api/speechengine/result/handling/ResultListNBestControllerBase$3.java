/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;

class ResultListNBestControllerBase$3
implements AsyncCallback {
    private final /* synthetic */ ResultListNBestControllerBase this$0;

    ResultListNBestControllerBase$3(ResultListNBestControllerBase resultListNBestControllerBase) {
        this.this$0 = resultListNBestControllerBase;
    }

    @Override
    public void onResponse(Object[] objectArray) {
        this.this$0.updateViewModel(this.this$0.getListIdSelectedItem(), objectArray);
        this.this$0.notifyItemSelected();
    }
}

