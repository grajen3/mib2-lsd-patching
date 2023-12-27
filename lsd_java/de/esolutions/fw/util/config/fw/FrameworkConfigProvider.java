/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.fw;

import de.esolutions.fw.util.config.ConfigProvider;

public class FrameworkConfigProvider
extends ConfigProvider {
    static FrameworkConfigProvider provider;
    static Object lock;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static FrameworkConfigProvider getInstance() {
        Object object = lock;
        synchronized (object) {
            if (provider == null) {
                provider = new FrameworkConfigProvider();
            }
            return provider;
        }
    }

    private FrameworkConfigProvider() {
        super("framework", "./config");
    }

    static {
        lock = new Object();
    }
}

