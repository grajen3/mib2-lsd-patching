/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class RouteProperties {
    public boolean isolatedMapArea;
    public boolean vignetteDuty;
    public boolean restrictedArea;
    public float energyConsumption;

    public RouteProperties(boolean bl, boolean bl2, boolean bl3, float f2) {
        this.isolatedMapArea = bl;
        this.vignetteDuty = bl2;
        this.restrictedArea = bl3;
        this.energyConsumption = f2;
    }

    public RouteProperties() {
        this.isolatedMapArea = false;
        this.vignetteDuty = false;
        this.restrictedArea = false;
        this.energyConsumption = 0.0f;
    }

    public boolean isIsolatedMapArea() {
        return this.isolatedMapArea;
    }

    public boolean isVignetteDuty() {
        return this.vignetteDuty;
    }

    public boolean isRestrictedArea() {
        return this.restrictedArea;
    }

    public float getEnergyConsumption() {
        return this.energyConsumption;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RouteProperties");
        stringBuffer.append('(');
        stringBuffer.append("isolatedMapArea");
        stringBuffer.append('=');
        stringBuffer.append(this.isolatedMapArea);
        stringBuffer.append(',');
        stringBuffer.append("vignetteDuty");
        stringBuffer.append('=');
        stringBuffer.append(this.vignetteDuty);
        stringBuffer.append(',');
        stringBuffer.append("restrictedArea");
        stringBuffer.append('=');
        stringBuffer.append(this.restrictedArea);
        stringBuffer.append(',');
        stringBuffer.append("energyConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.energyConsumption);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

