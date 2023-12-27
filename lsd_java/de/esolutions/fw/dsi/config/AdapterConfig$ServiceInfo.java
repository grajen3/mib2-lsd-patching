/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.config;

public class AdapterConfig$ServiceInfo {
    private String interfaceName;
    private int instance;
    private boolean earlyStartup;
    private boolean earlyRegistration;

    public AdapterConfig$ServiceInfo(String string, int n, boolean bl, boolean bl2) {
        this.interfaceName = string;
        this.instance = n;
        this.earlyStartup = bl;
        this.earlyRegistration = bl2;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public int getInstance() {
        return this.instance;
    }

    public boolean isEarlyStartup() {
        return this.earlyStartup;
    }

    public boolean isEarlyRegistration() {
        return this.earlyRegistration;
    }
}

