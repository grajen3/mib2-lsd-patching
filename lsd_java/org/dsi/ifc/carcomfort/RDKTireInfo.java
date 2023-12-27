/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.RDKSpeedLimit;

public class RDKTireInfo {
    public int position;
    public String vendorName;
    public String wheelSize;
    public int wheelType;
    public int frontPressure1;
    public int frontPressure2;
    public int frontPressure3;
    public int rearPressure1;
    public int rearPressure2;
    public int rearPressure3;
    public int spareWheelPressure;
    public int pressureUnit;
    public RDKSpeedLimit speedLimit1;
    public RDKSpeedLimit speedLimit2;
    public RDKSpeedLimit speedLimit3;
    public int frontPressure4;
    public int rearPressure4;

    public RDKTireInfo() {
        this.position = 0;
        this.vendorName = null;
        this.wheelSize = null;
        this.wheelType = 0;
        this.frontPressure1 = 0;
        this.frontPressure2 = 0;
        this.frontPressure3 = 0;
        this.rearPressure1 = 0;
        this.rearPressure2 = 0;
        this.rearPressure3 = 0;
        this.spareWheelPressure = 0;
        this.pressureUnit = 0;
        this.speedLimit1 = null;
        this.speedLimit2 = null;
        this.speedLimit3 = null;
        this.frontPressure4 = 0;
        this.rearPressure4 = 0;
    }

    public RDKTireInfo(int n, String string, String string2, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, RDKSpeedLimit rDKSpeedLimit, RDKSpeedLimit rDKSpeedLimit2, RDKSpeedLimit rDKSpeedLimit3) {
        this.position = n;
        this.vendorName = string;
        this.wheelSize = string2;
        this.wheelType = n2;
        this.frontPressure1 = n3;
        this.frontPressure2 = n4;
        this.frontPressure3 = n5;
        this.rearPressure1 = n6;
        this.rearPressure2 = n7;
        this.rearPressure3 = n8;
        this.spareWheelPressure = n9;
        this.pressureUnit = n10;
        this.speedLimit1 = rDKSpeedLimit;
        this.speedLimit2 = rDKSpeedLimit2;
        this.speedLimit3 = rDKSpeedLimit3;
        this.frontPressure4 = 0;
        this.rearPressure4 = 0;
    }

    public RDKTireInfo(int n, String string, String string2, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, RDKSpeedLimit rDKSpeedLimit, RDKSpeedLimit rDKSpeedLimit2, RDKSpeedLimit rDKSpeedLimit3, int n11, int n12) {
        this.position = n;
        this.vendorName = string;
        this.wheelSize = string2;
        this.wheelType = n2;
        this.frontPressure1 = n3;
        this.frontPressure2 = n4;
        this.frontPressure3 = n5;
        this.rearPressure1 = n6;
        this.rearPressure2 = n7;
        this.rearPressure3 = n8;
        this.spareWheelPressure = n9;
        this.pressureUnit = n10;
        this.speedLimit1 = rDKSpeedLimit;
        this.speedLimit2 = rDKSpeedLimit2;
        this.speedLimit3 = rDKSpeedLimit3;
        this.frontPressure4 = n11;
        this.rearPressure4 = n12;
    }

    public int getPosition() {
        return this.position;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public String getWheelSize() {
        return this.wheelSize;
    }

    public int getWheelType() {
        return this.wheelType;
    }

    public int getFrontPressure1() {
        return this.frontPressure1;
    }

    public int getFrontPressure2() {
        return this.frontPressure2;
    }

    public int getFrontPressure3() {
        return this.frontPressure3;
    }

    public int getRearPressure1() {
        return this.rearPressure1;
    }

    public int getRearPressure2() {
        return this.rearPressure2;
    }

    public int getRearPressure3() {
        return this.rearPressure3;
    }

    public int getSpareWheelPressure() {
        return this.spareWheelPressure;
    }

    public int getPressureUnit() {
        return this.pressureUnit;
    }

    public RDKSpeedLimit getSpeedLimit1() {
        return this.speedLimit1;
    }

    public RDKSpeedLimit getSpeedLimit2() {
        return this.speedLimit2;
    }

    public RDKSpeedLimit getSpeedLimit3() {
        return this.speedLimit3;
    }

    public int getFrontPressure4() {
        return this.frontPressure4;
    }

    public int getRearPressure4() {
        return this.rearPressure4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3950);
        stringBuffer.append("RDKTireInfo");
        stringBuffer.append('(');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("vendorName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.vendorName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("wheelSize");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.wheelSize);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("wheelType");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelType);
        stringBuffer.append(',');
        stringBuffer.append("frontPressure1");
        stringBuffer.append('=');
        stringBuffer.append(this.frontPressure1);
        stringBuffer.append(',');
        stringBuffer.append("frontPressure2");
        stringBuffer.append('=');
        stringBuffer.append(this.frontPressure2);
        stringBuffer.append(',');
        stringBuffer.append("frontPressure3");
        stringBuffer.append('=');
        stringBuffer.append(this.frontPressure3);
        stringBuffer.append(',');
        stringBuffer.append("rearPressure1");
        stringBuffer.append('=');
        stringBuffer.append(this.rearPressure1);
        stringBuffer.append(',');
        stringBuffer.append("rearPressure2");
        stringBuffer.append('=');
        stringBuffer.append(this.rearPressure2);
        stringBuffer.append(',');
        stringBuffer.append("rearPressure3");
        stringBuffer.append('=');
        stringBuffer.append(this.rearPressure3);
        stringBuffer.append(',');
        stringBuffer.append("spareWheelPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.spareWheelPressure);
        stringBuffer.append(',');
        stringBuffer.append("pressureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureUnit);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit1");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit1);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit2");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit2);
        stringBuffer.append(',');
        stringBuffer.append("speedLimit3");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit3);
        stringBuffer.append(',');
        stringBuffer.append("frontPressure4");
        stringBuffer.append('=');
        stringBuffer.append(this.frontPressure4);
        stringBuffer.append(',');
        stringBuffer.append("rearPressure4");
        stringBuffer.append('=');
        stringBuffer.append(this.rearPressure4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

