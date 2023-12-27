/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.router;

import de.vw.mib.asl.api.speechengine.result.router.RecognizedResultConsumer;

public interface RecognizedResultRouter {
    public static final int ANY_SPEECH_CONTEXTS;

    default public void register(int n, RecognizedResultConsumer recognizedResultConsumer) {
    }

    default public void unregister(int n, RecognizedResultConsumer recognizedResultConsumer) {
    }

    default public void register(RecognizedResultConsumer recognizedResultConsumer) {
    }

    default public void unregister(RecognizedResultConsumer recognizedResultConsumer) {
    }
}

