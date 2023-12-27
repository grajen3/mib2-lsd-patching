/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.RGSConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class RGSViewOptions {
    public CarViewOption beltPretensionerFrontDataLeft;
    public CarViewOption beltPretensionerFrontDataRight;
    public CarViewOption beltPretensionerRearDataLeft;
    public CarViewOption beltPretensionerRearDataRight;
    public CarViewOption preCrashSystem;
    public CarViewOption rgsSetFactoryDefault;
    public CarViewOption preSenseSystem;
    public CarViewOption preSenseWarning;
    public CarViewOption localHazardDetection;
    public CarViewOption localHazardInformation;
    public RGSConfiguration configuration;

    public RGSViewOptions() {
        this.beltPretensionerFrontDataLeft = null;
        this.beltPretensionerFrontDataRight = null;
        this.beltPretensionerRearDataLeft = null;
        this.beltPretensionerRearDataRight = null;
        this.preCrashSystem = null;
        this.rgsSetFactoryDefault = null;
        this.preSenseSystem = null;
        this.preSenseWarning = null;
        this.configuration = null;
        this.localHazardDetection = null;
        this.localHazardInformation = null;
    }

    public RGSViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, RGSConfiguration rGSConfiguration) {
        this.beltPretensionerFrontDataLeft = carViewOption;
        this.beltPretensionerFrontDataRight = carViewOption2;
        this.beltPretensionerRearDataLeft = carViewOption3;
        this.beltPretensionerRearDataRight = carViewOption4;
        this.preCrashSystem = carViewOption5;
        this.rgsSetFactoryDefault = carViewOption6;
        this.preSenseSystem = carViewOption7;
        this.preSenseWarning = carViewOption8;
        this.localHazardDetection = carViewOption9;
        this.localHazardInformation = carViewOption10;
        this.configuration = rGSConfiguration;
    }

    public CarViewOption getBeltPretensionerFrontDataLeft() {
        return this.beltPretensionerFrontDataLeft;
    }

    public CarViewOption getBeltPretensionerFrontDataRight() {
        return this.beltPretensionerFrontDataRight;
    }

    public CarViewOption getBeltPretensionerRearDataLeft() {
        return this.beltPretensionerRearDataLeft;
    }

    public CarViewOption getBeltPretensionerRearDataRight() {
        return this.beltPretensionerRearDataRight;
    }

    public CarViewOption getPreCrashSystem() {
        return this.preCrashSystem;
    }

    public CarViewOption getRgsSetFactoryDefault() {
        return this.rgsSetFactoryDefault;
    }

    public CarViewOption getPreSenseSystem() {
        return this.preSenseSystem;
    }

    public CarViewOption getPreSenseWarning() {
        return this.preSenseWarning;
    }

    public CarViewOption getLocalHazardDetection() {
        return this.localHazardDetection;
    }

    public CarViewOption getLocalHazardInformation() {
        return this.localHazardInformation;
    }

    public RGSConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(11600);
        stringBuffer.append("RGSViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("beltPretensionerFrontDataLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.beltPretensionerFrontDataLeft);
        stringBuffer.append(',');
        stringBuffer.append("beltPretensionerFrontDataRight");
        stringBuffer.append('=');
        stringBuffer.append(this.beltPretensionerFrontDataRight);
        stringBuffer.append(',');
        stringBuffer.append("beltPretensionerRearDataLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.beltPretensionerRearDataLeft);
        stringBuffer.append(',');
        stringBuffer.append("beltPretensionerRearDataRight");
        stringBuffer.append('=');
        stringBuffer.append(this.beltPretensionerRearDataRight);
        stringBuffer.append(',');
        stringBuffer.append("preCrashSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.preCrashSystem);
        stringBuffer.append(',');
        stringBuffer.append("rgsSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.rgsSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("preSenseSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.preSenseSystem);
        stringBuffer.append(',');
        stringBuffer.append("preSenseWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.preSenseWarning);
        stringBuffer.append(',');
        stringBuffer.append("localHazardDetection");
        stringBuffer.append('=');
        stringBuffer.append(this.localHazardDetection);
        stringBuffer.append(',');
        stringBuffer.append("localHazardInformation");
        stringBuffer.append('=');
        stringBuffer.append(this.localHazardInformation);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

