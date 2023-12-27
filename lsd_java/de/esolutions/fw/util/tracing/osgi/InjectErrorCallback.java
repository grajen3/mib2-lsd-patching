/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.osgi;

import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;

public class InjectErrorCallback
implements ITraceCallback {
    private final TraceFrontend frontend;

    public InjectErrorCallback(TraceFrontend traceFrontend) {
        this.frontend = traceFrontend;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        if (this.frontend != null) {
            System.err.println("JavaTraceCore: injecting error for testing purposes...");
            this.frontend.injectError(new Throwable("A test error"));
        }
    }
}

