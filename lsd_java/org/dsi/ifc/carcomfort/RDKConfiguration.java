/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.RDKSpeedLimitAvailability;

public class RDKConfiguration {
    public int system;
    public RDKSpeedLimitAvailability speedLimitAvailability;
    public boolean pressureLevel2;
    public boolean pressureLevel3;
    public boolean pressureLevel1;
    public boolean pressureLevel4;
    public boolean wheelDetails;
    public boolean calibrationViaHardkey;
    public int systemType;

    public RDKConfiguration() {
        this.system = 255;
        this.speedLimitAvailability = null;
        this.pressureLevel2 = false;
        this.pressureLevel3 = false;
        this.pressureLevel1 = false;
        this.pressureLevel4 = false;
        this.wheelDetails = false;
        this.calibrationViaHardkey = false;
        this.systemType = 255;
    }

    public RDKConfiguration(int n, RDKSpeedLimitAvailability rDKSpeedLimitAvailability) {
        this.system = n;
        this.speedLimitAvailability = rDKSpeedLimitAvailability;
        this.pressureLevel2 = false;
        this.pressureLevel3 = false;
        this.pressureLevel1 = false;
        this.pressureLevel4 = false;
        this.wheelDetails = false;
        this.calibrationViaHardkey = false;
        this.systemType = 255;
    }

    public RDKConfiguration(int n, RDKSpeedLimitAvailability rDKSpeedLimitAvailability, boolean bl, boolean bl2) {
        this.system = n;
        this.speedLimitAvailability = rDKSpeedLimitAvailability;
        this.pressureLevel2 = bl;
        this.pressureLevel3 = bl2;
        this.pressureLevel1 = false;
        this.pressureLevel4 = false;
        this.wheelDetails = false;
        this.calibrationViaHardkey = false;
        this.systemType = 255;
    }

    public RDKConfiguration(int n, RDKSpeedLimitAvailability rDKSpeedLimitAvailability, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n2) {
        this.system = n;
        this.speedLimitAvailability = rDKSpeedLimitAvailability;
        this.pressureLevel2 = bl;
        this.pressureLevel3 = bl2;
        this.pressureLevel1 = bl3;
        this.pressureLevel4 = bl4;
        this.wheelDetails = bl5;
        this.calibrationViaHardkey = bl6;
        this.systemType = n2;
    }

    public int getSystem() {
        return this.system;
    }

    public RDKSpeedLimitAvailability getSpeedLimitAvailability() {
        return this.speedLimitAvailability;
    }

    public boolean isPressureLevel2() {
        return this.pressureLevel2;
    }

    public boolean isPressureLevel3() {
        return this.pressureLevel3;
    }

    public boolean isPressureLevel1() {
        return this.pressureLevel1;
    }

    public boolean isPressureLevel4() {
        return this.pressureLevel4;
    }

    public boolean isWheelDetails() {
        return this.wheelDetails;
    }

    public boolean isCalibrationViaHardkey() {
        return this.calibrationViaHardkey;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("RDKConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(',');
        stringBuffer.append("speedLimitAvailability");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimitAvailability);
        stringBuffer.append(',');
        stringBuffer.append("pressureLevel2");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureLevel2);
        stringBuffer.append(',');
        stringBuffer.append("pressureLevel3");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureLevel3);
        stringBuffer.append(',');
        stringBuffer.append("pressureLevel1");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureLevel1);
        stringBuffer.append(',');
        stringBuffer.append("pressureLevel4");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureLevel4);
        stringBuffer.append(',');
        stringBuffer.append("wheelDetails");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelDetails);
        stringBuffer.append(',');
        stringBuffer.append("calibrationViaHardkey");
        stringBuffer.append('=');
        stringBuffer.append(this.calibrationViaHardkey);
        stringBuffer.append(',');
        stringBuffer.append("systemType");
        stringBuffer.append('=');
        stringBuffer.append(this.systemType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

