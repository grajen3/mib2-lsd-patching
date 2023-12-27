/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconFreshAirCartridge {
    public int level;
    public int warning;
    public int flavourID;

    public AirconFreshAirCartridge() {
        this.level = 0;
        this.warning = 0;
        this.flavourID = 0;
    }

    public AirconFreshAirCartridge(int n, int n2, int n3) {
        this.level = n;
        this.warning = n2;
        this.flavourID = n3;
    }

    public int getLevel() {
        return this.level;
    }

    public int getWarning() {
        return this.warning;
    }

    public int getFlavourID() {
        return this.flavourID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AirconFreshAirCartridge");
        stringBuffer.append('(');
        stringBuffer.append("level");
        stringBuffer.append('=');
        stringBuffer.append(this.level);
        stringBuffer.append(',');
        stringBuffer.append("warning");
        stringBuffer.append('=');
        stringBuffer.append(this.warning);
        stringBuffer.append(',');
        stringBuffer.append("flavourID");
        stringBuffer.append('=');
        stringBuffer.append(this.flavourID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

