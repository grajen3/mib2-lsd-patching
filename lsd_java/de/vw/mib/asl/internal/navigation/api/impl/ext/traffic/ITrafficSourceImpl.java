/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.traffic;

import de.vw.mib.asl.api.navigation.traffic.ITrafficSource;

public class ITrafficSourceImpl
implements ITrafficSource {
    private String trafficSourceName;
    private int trafficSourceState;
    private int trafficSourceType;

    public ITrafficSourceImpl(String string, int n, int n2) {
        this.setTrafficSourceName(string);
        this.setTrafficSourceState(n);
        this.setTrafficSourceType(n2);
    }

    @Override
    public String getTrafficSourceName() {
        return this.trafficSourceName;
    }

    private void setTrafficSourceName(String string) {
        this.trafficSourceName = string;
    }

    @Override
    public int getTrafficSourceState() {
        return this.trafficSourceState;
    }

    private void setTrafficSourceState(int n) {
        this.trafficSourceState = n;
    }

    @Override
    public int getTrafficSourceType() {
        return this.trafficSourceType;
    }

    private void setTrafficSourceType(int n) {
        this.trafficSourceType = n;
    }
}

