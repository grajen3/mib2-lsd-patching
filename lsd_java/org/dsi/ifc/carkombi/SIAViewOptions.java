/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.SIAConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class SIAViewOptions {
    public CarViewOption oilInspection;
    public CarViewOption serviceData;
    public CarViewOption reset;
    public CarViewOption historyList;
    public CarViewOption distanceOilUser;
    public CarViewOption distanceAirFilterUser;
    public CarViewOption distanceOilFilterUser;
    public CarViewOption inspectionDistanceUser;
    public CarViewOption dailyAverageMileage;
    public SIAConfiguration configuration;

    public SIAViewOptions() {
        this.oilInspection = null;
        this.serviceData = null;
        this.reset = null;
        this.historyList = null;
        this.distanceOilUser = null;
        this.distanceAirFilterUser = null;
        this.distanceOilFilterUser = null;
        this.inspectionDistanceUser = null;
        this.dailyAverageMileage = null;
        this.configuration = null;
    }

    public SIAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3) {
        this.oilInspection = carViewOption;
        this.serviceData = carViewOption2;
        this.reset = carViewOption3;
        this.historyList = null;
        this.distanceOilUser = null;
        this.distanceAirFilterUser = null;
        this.distanceOilFilterUser = null;
        this.inspectionDistanceUser = null;
        this.dailyAverageMileage = null;
        this.configuration = null;
    }

    public SIAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, SIAConfiguration sIAConfiguration) {
        this.oilInspection = carViewOption;
        this.serviceData = carViewOption2;
        this.reset = carViewOption3;
        this.historyList = carViewOption4;
        this.distanceOilUser = carViewOption5;
        this.distanceAirFilterUser = carViewOption6;
        this.distanceOilFilterUser = carViewOption7;
        this.inspectionDistanceUser = carViewOption8;
        this.dailyAverageMileage = carViewOption9;
        this.configuration = sIAConfiguration;
    }

    public CarViewOption getOilInspection() {
        return this.oilInspection;
    }

    public CarViewOption getServiceData() {
        return this.serviceData;
    }

    public CarViewOption getReset() {
        return this.reset;
    }

    public CarViewOption getHistoryList() {
        return this.historyList;
    }

    public CarViewOption getDistanceOilUser() {
        return this.distanceOilUser;
    }

    public CarViewOption getDistanceAirFilterUser() {
        return this.distanceAirFilterUser;
    }

    public CarViewOption getDistanceOilFilterUser() {
        return this.distanceOilFilterUser;
    }

    public CarViewOption getInspectionDistanceUser() {
        return this.inspectionDistanceUser;
    }

    public CarViewOption getDailyAverageMileage() {
        return this.dailyAverageMileage;
    }

    public SIAConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10450);
        stringBuffer.append("SIAViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("oilInspection");
        stringBuffer.append('=');
        stringBuffer.append(this.oilInspection);
        stringBuffer.append(',');
        stringBuffer.append("serviceData");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceData);
        stringBuffer.append(',');
        stringBuffer.append("reset");
        stringBuffer.append('=');
        stringBuffer.append(this.reset);
        stringBuffer.append(',');
        stringBuffer.append("historyList");
        stringBuffer.append('=');
        stringBuffer.append(this.historyList);
        stringBuffer.append(',');
        stringBuffer.append("distanceOilUser");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceOilUser);
        stringBuffer.append(',');
        stringBuffer.append("distanceAirFilterUser");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceAirFilterUser);
        stringBuffer.append(',');
        stringBuffer.append("distanceOilFilterUser");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceOilFilterUser);
        stringBuffer.append(',');
        stringBuffer.append("inspectionDistanceUser");
        stringBuffer.append('=');
        stringBuffer.append(this.inspectionDistanceUser);
        stringBuffer.append(',');
        stringBuffer.append("dailyAverageMileage");
        stringBuffer.append('=');
        stringBuffer.append(this.dailyAverageMileage);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

