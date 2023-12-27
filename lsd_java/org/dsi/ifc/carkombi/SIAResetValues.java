/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class SIAResetValues {
    public boolean distanceOil;
    public boolean timeOil;
    public boolean inspectionDistance;
    public boolean inspectionTime;

    public SIAResetValues() {
        this.distanceOil = false;
        this.timeOil = false;
        this.inspectionDistance = false;
        this.inspectionTime = false;
    }

    public SIAResetValues(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.distanceOil = bl;
        this.timeOil = bl2;
        this.inspectionDistance = bl3;
        this.inspectionTime = bl4;
    }

    public boolean isDistanceOil() {
        return this.distanceOil;
    }

    public boolean isTimeOil() {
        return this.timeOil;
    }

    public boolean isInspectionDistance() {
        return this.inspectionDistance;
    }

    public boolean isInspectionTime() {
        return this.inspectionTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SIAResetValues");
        stringBuffer.append('(');
        stringBuffer.append("distanceOil");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceOil);
        stringBuffer.append(',');
        stringBuffer.append("timeOil");
        stringBuffer.append('=');
        stringBuffer.append(this.timeOil);
        stringBuffer.append(',');
        stringBuffer.append("inspectionDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.inspectionDistance);
        stringBuffer.append(',');
        stringBuffer.append("inspectionTime");
        stringBuffer.append('=');
        stringBuffer.append(this.inspectionTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

