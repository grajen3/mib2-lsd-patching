/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.util.ObjectFactory;

public class BackendRegistry
extends ObjectFactory {
    private static BackendRegistry registry;

    public static BackendRegistry getInstance() {
        if (registry == null) {
            registry = new BackendRegistry();
        }
        return registry;
    }

    public ITraceBackend createBackend(String string) {
        return (ITraceBackend)super.create(string);
    }
}

