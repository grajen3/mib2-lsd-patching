/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public interface ResultItemController {
    default public void onResult() {
    }

    default public void notifyResultCompleted(ResultItem resultItem) {
    }
}

