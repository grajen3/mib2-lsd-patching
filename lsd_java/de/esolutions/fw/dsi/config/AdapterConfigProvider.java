/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.config;

import de.esolutions.fw.util.config.ConfigProvider;

public class AdapterConfigProvider
extends ConfigProvider {
    static AdapterConfigProvider provider;

    public static AdapterConfigProvider getInstance() {
        if (provider == null) {
            provider = new AdapterConfigProvider();
        }
        return provider;
    }

    private AdapterConfigProvider() {
        super("dsiadapter", "./config");
    }
}

