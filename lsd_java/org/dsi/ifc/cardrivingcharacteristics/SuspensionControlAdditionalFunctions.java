/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlAdditionalFunctions {
    public boolean actualNiveau;
    public boolean targetNiveau;
    public boolean vehicleStatus;
    public boolean vehicleStateControl;

    public SuspensionControlAdditionalFunctions() {
        this.actualNiveau = false;
        this.targetNiveau = false;
        this.vehicleStatus = false;
        this.vehicleStateControl = false;
    }

    public SuspensionControlAdditionalFunctions(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.actualNiveau = bl;
        this.targetNiveau = bl2;
        this.vehicleStatus = bl3;
        this.vehicleStateControl = bl4;
    }

    public boolean isActualNiveau() {
        return this.actualNiveau;
    }

    public boolean isTargetNiveau() {
        return this.targetNiveau;
    }

    public boolean isVehicleStatus() {
        return this.vehicleStatus;
    }

    public boolean isVehicleStateControl() {
        return this.vehicleStateControl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SuspensionControlAdditionalFunctions");
        stringBuffer.append('(');
        stringBuffer.append("actualNiveau");
        stringBuffer.append('=');
        stringBuffer.append(this.actualNiveau);
        stringBuffer.append(',');
        stringBuffer.append("targetNiveau");
        stringBuffer.append('=');
        stringBuffer.append(this.targetNiveau);
        stringBuffer.append(',');
        stringBuffer.append("vehicleStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleStatus);
        stringBuffer.append(',');
        stringBuffer.append("vehicleStateControl");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleStateControl);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

