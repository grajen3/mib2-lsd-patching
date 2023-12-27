/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconFreshAirConfiguration {
    public int setup;
    public int flavourSelection;
    public int intensityCartridge1;
    public int intensityCartridge2;

    public AirconFreshAirConfiguration() {
        this.setup = 0;
        this.flavourSelection = 0;
        this.intensityCartridge1 = 0;
        this.intensityCartridge2 = 0;
    }

    public AirconFreshAirConfiguration(int n, int n2, int n3, int n4) {
        this.setup = n;
        this.flavourSelection = n2;
        this.intensityCartridge1 = n3;
        this.intensityCartridge2 = n4;
    }

    public int getSetup() {
        return this.setup;
    }

    public int getFlavourSelection() {
        return this.flavourSelection;
    }

    public int getIntensityCartridge1() {
        return this.intensityCartridge1;
    }

    public int getIntensityCartridge2() {
        return this.intensityCartridge2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("AirconFreshAirConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("setup");
        stringBuffer.append('=');
        stringBuffer.append(this.setup);
        stringBuffer.append(',');
        stringBuffer.append("flavourSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.flavourSelection);
        stringBuffer.append(',');
        stringBuffer.append("intensityCartridge1");
        stringBuffer.append('=');
        stringBuffer.append(this.intensityCartridge1);
        stringBuffer.append(',');
        stringBuffer.append("intensityCartridge2");
        stringBuffer.append('=');
        stringBuffer.append(this.intensityCartridge2);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

