/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedResultConsumer;

public interface ResultControllerRouter
extends RecognizedResultConsumer,
ModelEventConsumer {
    public static final int UNKNOWN_EVENT_ID;

    default public void register(ModelEventConsumer modelEventConsumer, int n) {
    }

    default public void register(ModelEventConsumer modelEventConsumer, int n, int n2) {
    }

    default public void register(RecognizedEventConsumer recognizedEventConsumer, int n) {
    }

    default public void register(RecognizedEventConsumer recognizedEventConsumer, int n, int n2) {
    }
}

