/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public interface ResultListHandler
extends ResultItemRowNumberHandler {
    default public ResultItem[] getTopLevelItems() {
    }

    default public ResultItem[] getDetailLevelItems(ResultItem resultItem) {
    }

    default public ResultItem selectByName() {
    }

    default public ResultItem selectByIndex(int n) {
    }
}

