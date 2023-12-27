/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.service;

import de.vw.mib.asl.api.media.services.browser.MediaBrowserService;
import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import de.vw.mib.asl.internal.speechmedia.titles.service.AbstractMusicDataService$1;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMusicDataService
implements AdditionalDataService {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[AbstractMusicDataService] ");
    protected final MediaBrowserService mediaBrowserService;
    protected final MediaServiceController msController;
    protected final int contentType;

    public AbstractMusicDataService(MediaServiceController mediaServiceController, int n) {
        this.msController = mediaServiceController;
        this.contentType = n;
        this.mediaBrowserService = mediaServiceController.getMediaBrowserService();
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        if (this.logger.isTraceEnabled()) {
            this.traceResultItems(resultItemArray);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            if (resultItemArray[i2].isGroup()) continue;
            arrayList.add(new Long(resultItemArray[i2].getIdentifier().getObjectId()));
        }
        if (arrayList.size() == 0) {
            this.callbackData(asyncCallback, resultItemArray, null);
            return;
        }
        this.mediaBrowserService.requestEntries(arrayList, this.contentType, new AbstractMusicDataService$1(this, asyncCallback, resultItemArray));
    }

    private void traceResultItems(ResultItem[] resultItemArray) {
        LogMessage logMessage = this.logger.trace();
        logMessage.append("requested items : ");
        if (resultItemArray == null) {
            logMessage.append("null");
            logMessage.log();
            return;
        }
        logMessage.append("[");
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            if (resultItemArray[i2].isGroup()) {
                logMessage.append("G:");
                logMessage.append(resultItemArray[i2].getText());
            } else {
                logMessage.append(resultItemArray[i2].getIdentifier().getObjectId());
            }
            if (i2 >= resultItemArray.length - 1) continue;
            logMessage.append(",");
        }
        logMessage.append("]");
        logMessage.log();
    }

    private void traceModels(TitleModel[] titleModelArray) {
        LogMessage logMessage = this.logger.trace();
        logMessage.append("response items: ");
        if (titleModelArray == null) {
            logMessage.append("null");
            logMessage.log();
            return;
        }
        logMessage.append("[");
        for (int i2 = 0; i2 < titleModelArray.length; ++i2) {
            if (titleModelArray[i2] == null) {
                logMessage.append("null");
            } else {
                logMessage.append(titleModelArray[i2].toString());
            }
            if (i2 >= titleModelArray.length - 1) continue;
            logMessage.append(", ");
        }
        logMessage.append("]");
        logMessage.log();
    }

    protected void callbackData(AsyncCallback asyncCallback, ResultItem[] resultItemArray, List list) {
        Object[] objectArray = new TitleModel[resultItemArray.length];
        int n = 0;
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            Object object;
            if (resultItemArray[i2].isGroup()) {
                object = resultItemArray[i2];
                objectArray[i2] = this.fromGroup((ResultItem)object);
                continue;
            }
            if (n < list.size()) {
                object = (MediaEntry)list.get(n);
                objectArray[i2] = this.fromMediaEntry((MediaEntry)object);
                ++n;
                continue;
            }
            this.logger.error("requestEntries() returned more items than requested");
        }
        if (this.logger.isTraceEnabled()) {
            this.traceModels((TitleModel[])objectArray);
        }
        asyncCallback.onResponse(objectArray);
    }

    protected abstract TitleModel fromMediaEntry(MediaEntry mediaEntry) {
    }

    protected abstract TitleModel fromGroup(ResultItem resultItem) {
    }
}

