/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;

public interface Action
extends RecognizedEventConsumer,
ModelEventConsumer {
    default public int getDownEvent() {
    }
}

