/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.model.ResultCollection;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;

public interface ResultSession {
    default public void add(ResultCollection resultCollection) {
    }

    default public ResultCollection getResultList() {
    }

    default public ResultItem getLastCommand() {
    }
}

