/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.global.CarViewOption;

public class AirconZoneViewOptions {
    public CarViewOption airconTemp;
    public CarViewOption airconAirVolume;
    public CarViewOption airconAirDistribution;
    public CarViewOption airconFootwellTemp;
    public CarViewOption airconSeatHeater;
    public CarViewOption airconSeatVentilation;
    public CarViewOption airconSeatHeaterDistribution;
    public CarViewOption airconSeatVentilationDistribution;
    public CarViewOption airconTempStep;
    public CarViewOption airconAirVolumeRegulated;
    public CarViewOption airconNeckHeater;
    public CarViewOption airconSurfaceHeaterState;
    public CarViewOption airconSurfaceHeaterLink;
    public CarViewOption airconSurfaceHeaterHeaterLevel;
    public CarViewOption airconIndividualClimatisation;
    public CarViewOption airconIonisator;
    public CarViewOption airconBodyCloseMeasures;
    public CarViewOption airconClimateStyle;
    public CarViewOption airconClimateState;

    public AirconZoneViewOptions() {
        this.airconTemp = null;
        this.airconAirVolume = null;
        this.airconAirDistribution = null;
        this.airconFootwellTemp = null;
        this.airconSeatHeater = null;
        this.airconSeatVentilation = null;
        this.airconSeatHeaterDistribution = null;
        this.airconSeatVentilationDistribution = null;
        this.airconTempStep = null;
        this.airconAirVolumeRegulated = null;
        this.airconNeckHeater = null;
        this.airconSurfaceHeaterState = null;
        this.airconSurfaceHeaterLink = null;
        this.airconSurfaceHeaterHeaterLevel = null;
        this.airconIndividualClimatisation = null;
        this.airconIonisator = null;
        this.airconBodyCloseMeasures = null;
        this.airconClimateStyle = null;
        this.airconClimateState = null;
    }

    public AirconZoneViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15, CarViewOption carViewOption16, CarViewOption carViewOption17, CarViewOption carViewOption18, CarViewOption carViewOption19) {
        this.airconTemp = carViewOption;
        this.airconAirVolume = carViewOption2;
        this.airconAirDistribution = carViewOption3;
        this.airconFootwellTemp = carViewOption4;
        this.airconSeatHeater = carViewOption5;
        this.airconSeatVentilation = carViewOption6;
        this.airconSeatHeaterDistribution = carViewOption7;
        this.airconSeatVentilationDistribution = carViewOption8;
        this.airconTempStep = carViewOption9;
        this.airconAirVolumeRegulated = carViewOption10;
        this.airconNeckHeater = carViewOption11;
        this.airconSurfaceHeaterState = carViewOption12;
        this.airconSurfaceHeaterLink = carViewOption13;
        this.airconSurfaceHeaterHeaterLevel = carViewOption14;
        this.airconIndividualClimatisation = carViewOption15;
        this.airconIonisator = carViewOption16;
        this.airconBodyCloseMeasures = carViewOption17;
        this.airconClimateStyle = carViewOption18;
        this.airconClimateState = carViewOption19;
    }

    public CarViewOption getAirconTemp() {
        return this.airconTemp;
    }

    public CarViewOption getAirconAirVolume() {
        return this.airconAirVolume;
    }

    public CarViewOption getAirconAirDistribution() {
        return this.airconAirDistribution;
    }

    public CarViewOption getAirconFootwellTemp() {
        return this.airconFootwellTemp;
    }

    public CarViewOption getAirconSeatHeater() {
        return this.airconSeatHeater;
    }

    public CarViewOption getAirconSeatVentilation() {
        return this.airconSeatVentilation;
    }

    public CarViewOption getAirconSeatHeaterDistribution() {
        return this.airconSeatHeaterDistribution;
    }

    public CarViewOption getAirconSeatVentilationDistribution() {
        return this.airconSeatVentilationDistribution;
    }

    public CarViewOption getAirconTempStep() {
        return this.airconTempStep;
    }

    public CarViewOption getAirconClimateStyle() {
        return this.airconClimateStyle;
    }

    public CarViewOption getAirconClimateState() {
        return this.airconClimateState;
    }

    public CarViewOption getAirconAirVolumeRegulated() {
        return this.airconAirVolumeRegulated;
    }

    public CarViewOption getAirconNeckHeater() {
        return this.airconNeckHeater;
    }

    public CarViewOption getAirconSurfaceHeaterState() {
        return this.airconSurfaceHeaterState;
    }

    public CarViewOption getAirconSurfaceHeaterLink() {
        return this.airconSurfaceHeaterLink;
    }

    public CarViewOption getAirconSurfaceHeaterHeaterLevel() {
        return this.airconSurfaceHeaterHeaterLevel;
    }

    public CarViewOption getAirconIndividualClimatisation() {
        return this.airconIndividualClimatisation;
    }

    public CarViewOption getAirconIonisator() {
        return this.airconIonisator;
    }

    public CarViewOption getAirconBodyCloseMeasures() {
        return this.airconBodyCloseMeasures;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(20000);
        stringBuffer.append("AirconZoneViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("airconTemp");
        stringBuffer.append('=');
        stringBuffer.append(this.airconTemp);
        stringBuffer.append(',');
        stringBuffer.append("airconAirVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.airconAirVolume);
        stringBuffer.append(',');
        stringBuffer.append("airconAirDistribution");
        stringBuffer.append('=');
        stringBuffer.append(this.airconAirDistribution);
        stringBuffer.append(',');
        stringBuffer.append("airconFootwellTemp");
        stringBuffer.append('=');
        stringBuffer.append(this.airconFootwellTemp);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSeatHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatVentilation");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSeatVentilation);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatHeaterDistribution");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSeatHeaterDistribution);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatVentilationDistribution");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSeatVentilationDistribution);
        stringBuffer.append(',');
        stringBuffer.append("airconTempStep");
        stringBuffer.append('=');
        stringBuffer.append(this.airconTempStep);
        stringBuffer.append(',');
        stringBuffer.append("airconAirVolumeRegulated");
        stringBuffer.append('=');
        stringBuffer.append(this.airconAirVolumeRegulated);
        stringBuffer.append(',');
        stringBuffer.append("airconNeckHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.airconNeckHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconSurfaceHeaterState");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSurfaceHeaterState);
        stringBuffer.append(',');
        stringBuffer.append("airconSurfaceHeaterLink");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSurfaceHeaterLink);
        stringBuffer.append(',');
        stringBuffer.append("airconSurfaceHeaterHeaterLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.airconSurfaceHeaterHeaterLevel);
        stringBuffer.append(',');
        stringBuffer.append("airconIndividualClimatisation");
        stringBuffer.append('=');
        stringBuffer.append(this.airconIndividualClimatisation);
        stringBuffer.append(',');
        stringBuffer.append("airconIonisator");
        stringBuffer.append('=');
        stringBuffer.append(this.airconIonisator);
        stringBuffer.append(',');
        stringBuffer.append("airconBodyCloseMeasures");
        stringBuffer.append('=');
        stringBuffer.append(this.airconBodyCloseMeasures);
        stringBuffer.append(',');
        stringBuffer.append("airconClimateStyle");
        stringBuffer.append('=');
        stringBuffer.append(this.airconClimateStyle);
        stringBuffer.append(',');
        stringBuffer.append("airconClimateState");
        stringBuffer.append('=');
        stringBuffer.append(this.airconClimateState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

