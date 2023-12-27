/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCPLAInstructions {
    public boolean brakeSymbol;
    public boolean steeringInterventionSymbol;
    public boolean plaDeactivation;
    public boolean plaSearchLeftSide;
    public boolean plaSearchRightSide;
    public boolean neighborLaneWarning;

    public PDCPLAInstructions() {
        this.brakeSymbol = false;
        this.steeringInterventionSymbol = false;
        this.plaDeactivation = false;
        this.plaSearchLeftSide = false;
        this.plaSearchRightSide = false;
        this.neighborLaneWarning = false;
    }

    public PDCPLAInstructions(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.brakeSymbol = bl;
        this.steeringInterventionSymbol = bl2;
        this.plaDeactivation = bl3;
        this.plaSearchLeftSide = bl4;
        this.plaSearchRightSide = bl5;
        this.neighborLaneWarning = bl6;
    }

    public boolean isBrakeSymbol() {
        return this.brakeSymbol;
    }

    public boolean isSteeringInterventionSymbol() {
        return this.steeringInterventionSymbol;
    }

    public boolean isPlaDeactivation() {
        return this.plaDeactivation;
    }

    public boolean isPlaSearchLeftSide() {
        return this.plaSearchLeftSide;
    }

    public boolean isPlaSearchRightSide() {
        return this.plaSearchRightSide;
    }

    public boolean isNeighborLaneWarning() {
        return this.neighborLaneWarning;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("PDCPLAInstructions");
        stringBuffer.append('(');
        stringBuffer.append("brakeSymbol");
        stringBuffer.append('=');
        stringBuffer.append(this.brakeSymbol);
        stringBuffer.append(',');
        stringBuffer.append("steeringInterventionSymbol");
        stringBuffer.append('=');
        stringBuffer.append(this.steeringInterventionSymbol);
        stringBuffer.append(',');
        stringBuffer.append("plaDeactivation");
        stringBuffer.append('=');
        stringBuffer.append(this.plaDeactivation);
        stringBuffer.append(',');
        stringBuffer.append("plaSearchLeftSide");
        stringBuffer.append('=');
        stringBuffer.append(this.plaSearchLeftSide);
        stringBuffer.append(',');
        stringBuffer.append("plaSearchRightSide");
        stringBuffer.append('=');
        stringBuffer.append(this.plaSearchRightSide);
        stringBuffer.append(',');
        stringBuffer.append("neighborLaneWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.neighborLaneWarning);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

