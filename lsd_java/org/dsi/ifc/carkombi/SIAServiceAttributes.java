/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class SIAServiceAttributes {
    public boolean brakeFluid;
    public boolean sparkPlug;
    public boolean airFilter;
    public boolean fuelFilter;
    public boolean tyreSealant;
    public boolean gearboxOil;
    public boolean engineOil;

    public SIAServiceAttributes() {
        this.brakeFluid = false;
        this.sparkPlug = false;
        this.airFilter = false;
        this.fuelFilter = false;
        this.tyreSealant = false;
        this.gearboxOil = false;
        this.engineOil = false;
    }

    public SIAServiceAttributes(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.brakeFluid = bl;
        this.sparkPlug = bl2;
        this.airFilter = bl3;
        this.fuelFilter = bl4;
        this.tyreSealant = bl5;
        this.gearboxOil = bl6;
        this.engineOil = bl7;
    }

    public boolean isBrakeFluid() {
        return this.brakeFluid;
    }

    public boolean isSparkPlug() {
        return this.sparkPlug;
    }

    public boolean isAirFilter() {
        return this.airFilter;
    }

    public boolean isFuelFilter() {
        return this.fuelFilter;
    }

    public boolean isTyreSealant() {
        return this.tyreSealant;
    }

    public boolean isGearboxOil() {
        return this.gearboxOil;
    }

    public boolean isEngineOil() {
        return this.engineOil;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SIAServiceAttributes");
        stringBuffer.append('(');
        stringBuffer.append("brakeFluid");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeFluid);
        stringBuffer.append(',');
        stringBuffer.append("sparkPlug");
        stringBuffer.append('=');
        stringBuffer.append(this.sparkPlug);
        stringBuffer.append(',');
        stringBuffer.append("airFilter");
        stringBuffer.append('=');
        stringBuffer.append(this.airFilter);
        stringBuffer.append(',');
        stringBuffer.append("fuelFilter");
        stringBuffer.append('=');
        stringBuffer.append(this.fuelFilter);
        stringBuffer.append(',');
        stringBuffer.append("tyreSealant");
        stringBuffer.append('=');
        stringBuffer.append(this.tyreSealant);
        stringBuffer.append(',');
        stringBuffer.append("gearboxOil");
        stringBuffer.append('=');
        stringBuffer.append(this.gearboxOil);
        stringBuffer.append(',');
        stringBuffer.append("engineOil");
        stringBuffer.append('=');
        stringBuffer.append(this.engineOil);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

