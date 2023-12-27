/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.start;

import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerCallback;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerParameters;

public interface ResultHandlerActivator {
    public static final String RESULT_HANDLER_ACTIVATOR;

    default public void activate(ResultHandlerCallback resultHandlerCallback, ResultHandlerParameters resultHandlerParameters) {
    }
}

