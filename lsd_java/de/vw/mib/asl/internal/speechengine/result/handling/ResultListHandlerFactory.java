/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;

public interface ResultListHandlerFactory {
    default public ResultListHandler create(ResultSession resultSession) {
    }
}

