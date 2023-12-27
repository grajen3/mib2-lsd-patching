/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.caraircondition.AirconRowConfiguration;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AirconRowViewOptions {
    public CarViewOption airconSystemOnOffRow;
    public CarViewOption airconSetFactoryDefaultRow;
    public CarViewOption airconNozzleList;
    public CarViewOption airconNozzleControl;
    public CarViewOption airconNozzleStatus;
    public AirconZoneViewOptions zoneLeftViewOptions;
    public AirconZoneViewOptions zoneRightViewOptions;
    public AirconRowConfiguration configuration;

    public AirconRowViewOptions() {
        this.airconSystemOnOffRow = null;
        this.airconSetFactoryDefaultRow = null;
        this.airconNozzleList = null;
        this.airconNozzleControl = null;
        this.airconNozzleStatus = null;
        this.zoneLeftViewOptions = null;
        this.zoneRightViewOptions = null;
        this.configuration = null;
    }

    public AirconRowViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, AirconZoneViewOptions airconZoneViewOptions, AirconZoneViewOptions airconZoneViewOptions2, AirconRowConfiguration airconRowConfiguration) {
        this.airconSystemOnOffRow = carViewOption;
        this.airconSetFactoryDefaultRow = carViewOption2;
        this.airconNozzleList = carViewOption3;
        this.airconNozzleControl = carViewOption4;
        this.airconNozzleStatus = carViewOption5;
        this.zoneLeftViewOptions = airconZoneViewOptions;
        this.zoneRightViewOptions = airconZoneViewOptions2;
        this.configuration = airconRowConfiguration;
    }

    public CarViewOption getAirconSystemOnOffRow() {
        return this.airconSystemOnOffRow;
    }

    public CarViewOption getAirconSetFactoryDefaultRow() {
        return this.airconSetFactoryDefaultRow;
    }

    public CarViewOption getAirconNozzleList() {
        return this.airconNozzleList;
    }

    public CarViewOption getAirconNozzleControl() {
        return this.airconNozzleControl;
    }

    public CarViewOption getAirconNozzleStatus() {
        return this.airconNozzleStatus;
    }

    public AirconZoneViewOptions getZoneLeftViewOptions() {
        return this.zoneLeftViewOptions;
    }

    public AirconZoneViewOptions getZoneRightViewOptions() {
        return this.zoneRightViewOptions;
    }

    public AirconRowConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(8400);
        stringBuffer.append("AirconRowViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("airconSystemOnOffRow");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSystemOnOffRow);
        stringBuffer.append(',');
        stringBuffer.append("airconSetFactoryDefaultRow");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSetFactoryDefaultRow);
        stringBuffer.append(',');
        stringBuffer.append("airconNozzleList");
        stringBuffer.append('=');
        stringBuffer.append(this.airconNozzleList);
        stringBuffer.append(',');
        stringBuffer.append("airconNozzleControl");
        stringBuffer.append('=');
        stringBuffer.append(this.airconNozzleControl);
        stringBuffer.append(',');
        stringBuffer.append("airconNozzleStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.airconNozzleStatus);
        stringBuffer.append(',');
        stringBuffer.append("zoneLeftViewOptions");
        stringBuffer.append('=');
        stringBuffer.append(this.zoneLeftViewOptions);
        stringBuffer.append(',');
        stringBuffer.append("zoneRightViewOptions");
        stringBuffer.append('=');
        stringBuffer.append(this.zoneRightViewOptions);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

