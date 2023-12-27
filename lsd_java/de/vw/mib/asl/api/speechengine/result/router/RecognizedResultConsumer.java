/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.router;

import de.vw.mib.asl.api.speechengine.result.model.ResultCollection;

public interface RecognizedResultConsumer {
    default public void onRecognizedResult(int n, ResultCollection resultCollection) {
    }
}

