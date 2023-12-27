/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.start;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.internal.speechengine.result.RecognizedResultPublisher;

public interface ResultHandlerServices {
    default public RecognizedResultPublisher getRecognizedResultPublisher() {
    }

    default public ResultHandler getResultHandler(int n) {
    }
}

