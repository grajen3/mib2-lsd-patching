/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlProfileOperation {
    public boolean charge;
    public boolean climate;
    public boolean climateWithoutExternalSupply;
    public boolean autoDefrost;
    public boolean seatHeaterFrontLeft;
    public boolean seatHeaterFrontRight;
    public boolean seatHeaterRearLeft;
    public boolean seatHeaterRearRight;

    public BatteryControlProfileOperation() {
        this.charge = false;
        this.climate = false;
        this.climateWithoutExternalSupply = false;
        this.autoDefrost = false;
        this.seatHeaterFrontLeft = false;
        this.seatHeaterFrontRight = false;
        this.seatHeaterRearLeft = false;
        this.seatHeaterRearRight = false;
    }

    public BatteryControlProfileOperation(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.charge = bl;
        this.climate = bl2;
        this.climateWithoutExternalSupply = bl3;
        this.autoDefrost = bl4;
        this.seatHeaterFrontLeft = bl5;
        this.seatHeaterFrontRight = bl6;
        this.seatHeaterRearLeft = bl7;
        this.seatHeaterRearRight = bl8;
    }

    public boolean isCharge() {
        return this.charge;
    }

    public boolean isClimate() {
        return this.climate;
    }

    public boolean isClimateWithoutExternalSupply() {
        return this.climateWithoutExternalSupply;
    }

    public boolean isAutoDefrost() {
        return this.autoDefrost;
    }

    public boolean isSeatHeaterFrontLeft() {
        return this.seatHeaterFrontLeft;
    }

    public boolean isSeatHeaterFrontRight() {
        return this.seatHeaterFrontRight;
    }

    public boolean isSeatHeaterRearLeft() {
        return this.seatHeaterRearLeft;
    }

    public boolean isSeatHeaterRearRight() {
        return this.seatHeaterRearRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("BatteryControlProfileOperation");
        stringBuffer.append('(');
        stringBuffer.append("charge");
        stringBuffer.append('=');
        stringBuffer.append(this.charge);
        stringBuffer.append(',');
        stringBuffer.append("climate");
        stringBuffer.append('=');
        stringBuffer.append(this.climate);
        stringBuffer.append(',');
        stringBuffer.append("climateWithoutExternalSupply");
        stringBuffer.append('=');
        stringBuffer.append(this.climateWithoutExternalSupply);
        stringBuffer.append(',');
        stringBuffer.append("autoDefrost");
        stringBuffer.append('=');
        stringBuffer.append(this.autoDefrost);
        stringBuffer.append(',');
        stringBuffer.append("seatHeaterFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.seatHeaterFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("seatHeaterFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.seatHeaterFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("seatHeaterRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.seatHeaterRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("seatHeaterRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.seatHeaterRearRight);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

