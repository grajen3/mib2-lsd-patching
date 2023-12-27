/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.TSDConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class TSDViewOptions {
    public CarViewOption systemOnOff;
    public CarViewOption trailerDetection;
    public CarViewOption roadSign;
    public CarViewOption roadSignFilter;
    public CarViewOption tsdSetFactoryDefault;
    public CarViewOption speedWarningThreshold;
    public CarViewOption trailerSpeedLimit;
    public CarViewOption systemMessages;
    public CarViewOption speedWarnAcoustics;
    public TSDConfiguration configuration;

    public TSDViewOptions() {
        this.systemOnOff = null;
        this.trailerDetection = null;
        this.roadSign = null;
        this.roadSignFilter = null;
        this.tsdSetFactoryDefault = null;
        this.speedWarningThreshold = null;
        this.trailerSpeedLimit = null;
        this.systemMessages = null;
        this.speedWarnAcoustics = null;
        this.configuration = null;
    }

    public TSDViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, TSDConfiguration tSDConfiguration) {
        this.systemOnOff = carViewOption;
        this.trailerDetection = carViewOption2;
        this.roadSign = carViewOption3;
        this.roadSignFilter = carViewOption4;
        this.tsdSetFactoryDefault = carViewOption5;
        this.speedWarningThreshold = carViewOption6;
        this.trailerSpeedLimit = carViewOption7;
        this.systemMessages = carViewOption8;
        this.speedWarnAcoustics = null;
        this.configuration = tSDConfiguration;
    }

    public TSDViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, TSDConfiguration tSDConfiguration) {
        this.systemOnOff = carViewOption;
        this.trailerDetection = carViewOption2;
        this.roadSign = carViewOption3;
        this.roadSignFilter = carViewOption4;
        this.tsdSetFactoryDefault = carViewOption5;
        this.speedWarningThreshold = carViewOption6;
        this.trailerSpeedLimit = carViewOption7;
        this.systemMessages = carViewOption8;
        this.speedWarnAcoustics = carViewOption9;
        this.configuration = tSDConfiguration;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public CarViewOption getTrailerDetection() {
        return this.trailerDetection;
    }

    public CarViewOption getRoadSign() {
        return this.roadSign;
    }

    public CarViewOption getSpeedWarningThreshold() {
        return this.speedWarningThreshold;
    }

    public CarViewOption getTsdSetFactoryDefault() {
        return this.tsdSetFactoryDefault;
    }

    public CarViewOption getTrailerSpeedLimit() {
        return this.trailerSpeedLimit;
    }

    public CarViewOption getRoadSignFilter() {
        return this.roadSignFilter;
    }

    public CarViewOption getSystemMessages() {
        return this.systemMessages;
    }

    public CarViewOption getSpeedWarnAcoustics() {
        return this.speedWarnAcoustics;
    }

    public TSDConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10450);
        stringBuffer.append("TSDViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("trailerDetection");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerDetection);
        stringBuffer.append(',');
        stringBuffer.append("roadSign");
        stringBuffer.append('=');
        stringBuffer.append(this.roadSign);
        stringBuffer.append(',');
        stringBuffer.append("roadSignFilter");
        stringBuffer.append('=');
        stringBuffer.append(this.roadSignFilter);
        stringBuffer.append(',');
        stringBuffer.append("tsdSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.tsdSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("speedWarningThreshold");
        stringBuffer.append('=');
        stringBuffer.append(this.speedWarningThreshold);
        stringBuffer.append(',');
        stringBuffer.append("trailerSpeedLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerSpeedLimit);
        stringBuffer.append(',');
        stringBuffer.append("systemMessages");
        stringBuffer.append('=');
        stringBuffer.append(this.systemMessages);
        stringBuffer.append(',');
        stringBuffer.append("speedWarnAcoustics");
        stringBuffer.append('=');
        stringBuffer.append(this.speedWarnAcoustics);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

