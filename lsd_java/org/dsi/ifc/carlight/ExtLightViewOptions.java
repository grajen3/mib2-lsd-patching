/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.carlight.ExtLightConfig;
import org.dsi.ifc.global.CarViewOption;

public class ExtLightViewOptions {
    public CarViewOption comingHome;
    public CarViewOption leavingHome;
    public CarViewOption switchOnSensitivity;
    public CarViewOption dayLight;
    public CarViewOption touristLight;
    public CarViewOption motorwayBlinking;
    public CarViewOption adaptiveLightSystem;
    public CarViewOption headlightSystem;
    public CarViewOption glidingLightSystem;
    public CarViewOption maskedHighBeam;
    public ExtLightConfig extLightConfig;
    public CarViewOption automaticLight;
    public CarViewOption extLightSetFactoryDefault;
    public CarViewOption laserLight;
    public CarViewOption signatureLight;
    public CarViewOption headlightRange;

    public ExtLightViewOptions() {
        this.comingHome = null;
        this.leavingHome = null;
        this.switchOnSensitivity = null;
        this.dayLight = null;
        this.touristLight = null;
        this.motorwayBlinking = null;
        this.adaptiveLightSystem = null;
        this.headlightSystem = null;
        this.glidingLightSystem = null;
        this.maskedHighBeam = null;
        this.extLightConfig = null;
        this.automaticLight = null;
        this.extLightSetFactoryDefault = null;
        this.laserLight = null;
        this.signatureLight = null;
        this.headlightRange = null;
    }

    public ExtLightViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, ExtLightConfig extLightConfig, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13) {
        this.comingHome = carViewOption;
        this.leavingHome = carViewOption2;
        this.switchOnSensitivity = carViewOption3;
        this.dayLight = carViewOption4;
        this.touristLight = carViewOption5;
        this.motorwayBlinking = carViewOption6;
        this.adaptiveLightSystem = carViewOption7;
        this.headlightSystem = carViewOption8;
        this.glidingLightSystem = carViewOption9;
        this.maskedHighBeam = carViewOption10;
        this.extLightConfig = extLightConfig;
        this.automaticLight = carViewOption11;
        this.extLightSetFactoryDefault = carViewOption12;
        this.laserLight = carViewOption13;
        this.signatureLight = null;
        this.headlightRange = null;
    }

    public ExtLightViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, ExtLightConfig extLightConfig, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, CarViewOption carViewOption15) {
        this.comingHome = carViewOption;
        this.leavingHome = carViewOption2;
        this.switchOnSensitivity = carViewOption3;
        this.dayLight = carViewOption4;
        this.touristLight = carViewOption5;
        this.motorwayBlinking = carViewOption6;
        this.adaptiveLightSystem = carViewOption7;
        this.headlightSystem = carViewOption8;
        this.glidingLightSystem = carViewOption9;
        this.maskedHighBeam = carViewOption10;
        this.extLightConfig = extLightConfig;
        this.automaticLight = carViewOption11;
        this.extLightSetFactoryDefault = carViewOption12;
        this.laserLight = carViewOption13;
        this.signatureLight = carViewOption14;
        this.headlightRange = carViewOption15;
    }

    public CarViewOption getComingHome() {
        return this.comingHome;
    }

    public CarViewOption getLeavingHome() {
        return this.leavingHome;
    }

    public CarViewOption getSwitchOnSensitivity() {
        return this.switchOnSensitivity;
    }

    public CarViewOption getDayLight() {
        return this.dayLight;
    }

    public CarViewOption getTouristLight() {
        return this.touristLight;
    }

    public CarViewOption getMotorwayBlinking() {
        return this.motorwayBlinking;
    }

    public CarViewOption getAdaptiveLightSystem() {
        return this.adaptiveLightSystem;
    }

    public CarViewOption getHeadlightSystem() {
        return this.headlightSystem;
    }

    public CarViewOption getGlidingLightSystem() {
        return this.glidingLightSystem;
    }

    public CarViewOption getMaskedHighBeam() {
        return this.maskedHighBeam;
    }

    public ExtLightConfig getExtLightConfig() {
        return this.extLightConfig;
    }

    public CarViewOption getAutomaticLight() {
        return this.automaticLight;
    }

    public CarViewOption getExtLightSetFactoryDefault() {
        return this.extLightSetFactoryDefault;
    }

    public CarViewOption getLaserLight() {
        return this.laserLight;
    }

    public CarViewOption getSignatureLight() {
        return this.signatureLight;
    }

    public CarViewOption getHeadlightRange() {
        return this.headlightRange;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(16650);
        stringBuffer.append("ExtLightViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("comingHome");
        stringBuffer.append('=');
        stringBuffer.append(this.comingHome);
        stringBuffer.append(',');
        stringBuffer.append("leavingHome");
        stringBuffer.append('=');
        stringBuffer.append(this.leavingHome);
        stringBuffer.append(',');
        stringBuffer.append("switchOnSensitivity");
        stringBuffer.append('=');
        stringBuffer.append(this.switchOnSensitivity);
        stringBuffer.append(',');
        stringBuffer.append("dayLight");
        stringBuffer.append('=');
        stringBuffer.append(this.dayLight);
        stringBuffer.append(',');
        stringBuffer.append("touristLight");
        stringBuffer.append('=');
        stringBuffer.append(this.touristLight);
        stringBuffer.append(',');
        stringBuffer.append("motorwayBlinking");
        stringBuffer.append('=');
        stringBuffer.append(this.motorwayBlinking);
        stringBuffer.append(',');
        stringBuffer.append("adaptiveLightSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.adaptiveLightSystem);
        stringBuffer.append(',');
        stringBuffer.append("headlightSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.headlightSystem);
        stringBuffer.append(',');
        stringBuffer.append("glidingLightSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.glidingLightSystem);
        stringBuffer.append(',');
        stringBuffer.append("maskedHighBeam");
        stringBuffer.append('=');
        stringBuffer.append(this.maskedHighBeam);
        stringBuffer.append(',');
        stringBuffer.append("extLightConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.extLightConfig);
        stringBuffer.append(',');
        stringBuffer.append("automaticLight");
        stringBuffer.append('=');
        stringBuffer.append(this.automaticLight);
        stringBuffer.append(',');
        stringBuffer.append("extLightSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.extLightSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("laserLight");
        stringBuffer.append('=');
        stringBuffer.append(this.laserLight);
        stringBuffer.append(',');
        stringBuffer.append("signatureLight");
        stringBuffer.append('=');
        stringBuffer.append(this.signatureLight);
        stringBuffer.append(',');
        stringBuffer.append("headlightRange");
        stringBuffer.append('=');
        stringBuffer.append(this.headlightRange);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

