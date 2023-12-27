/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.frontend;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface ITraceFrontendListener {
    default public void executeCallback(int n, byte[] byArray) {
    }

    default public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
    }

    default public void requestQuit() {
    }
}

