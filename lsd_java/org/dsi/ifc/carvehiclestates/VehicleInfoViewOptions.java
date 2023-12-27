/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.global.CarViewOption;

public class VehicleInfoViewOptions {
    public CarViewOption drvSchoolSystem;
    public CarViewOption scrInfo;

    public VehicleInfoViewOptions() {
        this.drvSchoolSystem = null;
        this.scrInfo = null;
    }

    public VehicleInfoViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2) {
        this.drvSchoolSystem = carViewOption;
        this.scrInfo = carViewOption2;
    }

    public CarViewOption getDrvSchoolSystem() {
        return this.drvSchoolSystem;
    }

    public CarViewOption getScrInfo() {
        return this.scrInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("VehicleInfoViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("drvSchoolSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.drvSchoolSystem);
        stringBuffer.append(',');
        stringBuffer.append("scrInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.scrInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

