/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.frontend;

import de.esolutions.fw.util.tracing.frontend.TraceFrontend;

public interface ITraceFrontendErrorHandler {
    default public void errorShutdown(TraceFrontend traceFrontend, Throwable throwable) {
    }
}

