/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.service;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;

public interface AdditionalDataService {
    default public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
    }
}

