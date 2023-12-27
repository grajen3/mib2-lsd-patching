/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class RestSeatStatus {
    public boolean displayDown;
    public boolean displayRestSeatMoving;
    public boolean restSeatPosition;

    public RestSeatStatus() {
        this.displayDown = false;
        this.displayRestSeatMoving = false;
        this.restSeatPosition = false;
    }

    public RestSeatStatus(boolean bl, boolean bl2, boolean bl3) {
        this.displayDown = bl;
        this.displayRestSeatMoving = bl2;
        this.restSeatPosition = bl3;
    }

    public boolean isDisplayDown() {
        return this.displayDown;
    }

    public boolean isDisplayRestSeatMoving() {
        return this.displayRestSeatMoving;
    }

    public boolean isRestSeatPosition() {
        return this.restSeatPosition;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RestSeatStatus");
        stringBuffer.append('(');
        stringBuffer.append("displayDown");
        stringBuffer.append('=');
        stringBuffer.append(this.displayDown);
        stringBuffer.append(',');
        stringBuffer.append("displayRestSeatMoving");
        stringBuffer.append('=');
        stringBuffer.append(this.displayRestSeatMoving);
        stringBuffer.append(',');
        stringBuffer.append("restSeatPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.restSeatPosition);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

