/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.service;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.browser.MediaEntriesCallback;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechmedia.titles.service.AbstractMusicDataService;
import java.util.List;

class AbstractMusicDataService$1
implements MediaEntriesCallback {
    private final /* synthetic */ AsyncCallback val$caller;
    private final /* synthetic */ ResultItem[] val$items;
    private final /* synthetic */ AbstractMusicDataService this$0;

    AbstractMusicDataService$1(AbstractMusicDataService abstractMusicDataService, AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        this.this$0 = abstractMusicDataService;
        this.val$caller = asyncCallback;
        this.val$items = resultItemArray;
    }

    @Override
    public void responseMediaEntry(List list, ResultCode resultCode) {
        if (resultCode == ResultCode.NOK) {
            this.this$0.logger.error("Media returend ResultCode.NOK on requestEntries()");
            this.this$0.msController.doFatalError();
            return;
        }
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("requestEntries() ResultCode.OK");
        }
        this.this$0.callbackData(this.val$caller, this.val$items, list);
    }
}

