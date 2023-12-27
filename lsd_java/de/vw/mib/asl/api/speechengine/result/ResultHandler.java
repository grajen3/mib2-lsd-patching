/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result;

import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;

public interface ResultHandler {
    default public ResultControllerRouter getResultControllerRegistry() {
    }

    default public ResultSession getResultSession() {
    }

    default public ResultListHandler getResultListHandler() {
    }

    default public ResultItemRowNumberHandler getResultItemRowNumberHandler() {
    }

    default public ResultItemHandler getResultItemHandler() {
    }
}

