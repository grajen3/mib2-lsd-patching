/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.PDCPLAInstructions;
import org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot;

public class PDCPLAStatus {
    public int mode;
    public PDCPLAParkingSpot parkingSpot;
    public int drivingDirection;
    public PDCPLAInstructions instructions;
    public int preSelection;

    public PDCPLAStatus() {
        this.mode = 0;
        this.parkingSpot = null;
        this.drivingDirection = 0;
        this.instructions = null;
        this.preSelection = 0;
    }

    public PDCPLAStatus(int n, PDCPLAParkingSpot pDCPLAParkingSpot, int n2, PDCPLAInstructions pDCPLAInstructions, int n3) {
        this.mode = n;
        this.parkingSpot = pDCPLAParkingSpot;
        this.drivingDirection = n2;
        this.instructions = pDCPLAInstructions;
        this.preSelection = n3;
    }

    public int getMode() {
        return this.mode;
    }

    public PDCPLAParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }

    public int getDrivingDirection() {
        return this.drivingDirection;
    }

    public PDCPLAInstructions getInstructions() {
        return this.instructions;
    }

    public int getPreSelection() {
        return this.preSelection;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2250);
        stringBuffer.append("PDCPLAStatus");
        stringBuffer.append('(');
        stringBuffer.append("mode");
        stringBuffer.append('=');
        stringBuffer.append(this.mode);
        stringBuffer.append(',');
        stringBuffer.append("parkingSpot");
        stringBuffer.append('=');
        stringBuffer.append(this.parkingSpot);
        stringBuffer.append(',');
        stringBuffer.append("drivingDirection");
        stringBuffer.append('=');
        stringBuffer.append(this.drivingDirection);
        stringBuffer.append(',');
        stringBuffer.append("instructions");
        stringBuffer.append('=');
        stringBuffer.append(this.instructions);
        stringBuffer.append(',');
        stringBuffer.append("preSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.preSelection);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

