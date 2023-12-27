/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.config.ConfigProvider;

public class TraceConfigProvider
extends ConfigProvider {
    static TraceConfigProvider provider;
    static Object lock;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TraceConfigProvider getInstance() {
        Object object = lock;
        synchronized (object) {
            if (provider == null) {
                provider = new TraceConfigProvider();
            }
            return provider;
        }
    }

    private TraceConfigProvider() {
        super("tracing", "./config");
    }

    static {
        lock = new Object();
    }
}

