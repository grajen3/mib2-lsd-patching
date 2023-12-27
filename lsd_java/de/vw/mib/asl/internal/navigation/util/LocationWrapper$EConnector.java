/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.IEConnector;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;

public final class LocationWrapper$EConnector
implements IEConnector {
    private String chargeMode;
    private String chargeLevel;
    private int countAvailable;
    private String fuseProtection;
    private String name;
    private float powerOutput;
    private int type;
    private final /* synthetic */ LocationWrapper this$0;

    protected LocationWrapper$EConnector(LocationWrapper locationWrapper, String string, String string2, int n, String string3, String string4, float f2, int n2) {
        this.this$0 = locationWrapper;
        this.chargeMode = string;
        this.chargeLevel = string2;
        this.countAvailable = n;
        this.fuseProtection = string3;
        this.name = string4;
        this.powerOutput = f2;
        this.type = n2;
    }

    @Override
    public String getChargeMode() {
        return this.chargeMode;
    }

    @Override
    public String getChargeLevel() {
        return this.chargeLevel;
    }

    @Override
    public int getCountAvailable() {
        return this.countAvailable;
    }

    @Override
    public String getFuseProtection() {
        return this.fuseProtection;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getPowerOutput() {
        return this.powerOutput;
    }

    @Override
    public int getType() {
        return this.type;
    }
}

