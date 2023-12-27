/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class ARATrailerConfiguration {
    public short maxTrailerAngle;
    public short instantTrailerAngle;
    public short hazinessTrailerAngle;
    public short threshold1;
    public short threshold2;
    public short threshold3;
    public short threshold4;
    public byte stepSize1;
    public byte stepSize2;
    public byte stepSize3;
    public byte stepSize4;

    public ARATrailerConfiguration() {
        this.maxTrailerAngle = 0;
        this.instantTrailerAngle = 0;
        this.hazinessTrailerAngle = 0;
        this.threshold1 = 0;
        this.threshold2 = 0;
        this.threshold3 = 0;
        this.threshold4 = 0;
        this.stepSize1 = 0;
        this.stepSize2 = 0;
        this.stepSize3 = 0;
        this.stepSize4 = 0;
    }

    public ARATrailerConfiguration(short s, short s2, short s3, short s4, short s5, short s6, short s7, byte by, byte by2, byte by3, byte by4) {
        this.maxTrailerAngle = s;
        this.instantTrailerAngle = s2;
        this.hazinessTrailerAngle = s3;
        this.threshold1 = s4;
        this.threshold2 = s5;
        this.threshold3 = s6;
        this.threshold4 = s7;
        this.stepSize1 = by;
        this.stepSize2 = by2;
        this.stepSize3 = by3;
        this.stepSize4 = by4;
    }

    public short getMaxTrailerAngle() {
        return this.maxTrailerAngle;
    }

    public short getInstantTrailerAngle() {
        return this.instantTrailerAngle;
    }

    public short getHazinessTrailerAngle() {
        return this.hazinessTrailerAngle;
    }

    public short getThreshold1() {
        return this.threshold1;
    }

    public short getThreshold2() {
        return this.threshold2;
    }

    public short getThreshold3() {
        return this.threshold3;
    }

    public short getThreshold4() {
        return this.threshold4;
    }

    public byte getStepSize1() {
        return this.stepSize1;
    }

    public byte getStepSize2() {
        return this.stepSize2;
    }

    public byte getStepSize3() {
        return this.stepSize3;
    }

    public byte getStepSize4() {
        return this.stepSize4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("ARATrailerConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("maxTrailerAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.maxTrailerAngle);
        stringBuffer.append(',');
        stringBuffer.append("instantTrailerAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.instantTrailerAngle);
        stringBuffer.append(',');
        stringBuffer.append("hazinessTrailerAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.hazinessTrailerAngle);
        stringBuffer.append(',');
        stringBuffer.append("threshold1");
        stringBuffer.append('=');
        stringBuffer.append(this.threshold1);
        stringBuffer.append(',');
        stringBuffer.append("threshold2");
        stringBuffer.append('=');
        stringBuffer.append(this.threshold2);
        stringBuffer.append(',');
        stringBuffer.append("threshold3");
        stringBuffer.append('=');
        stringBuffer.append(this.threshold3);
        stringBuffer.append(',');
        stringBuffer.append("threshold4");
        stringBuffer.append('=');
        stringBuffer.append(this.threshold4);
        stringBuffer.append(',');
        stringBuffer.append("stepSize1");
        stringBuffer.append('=');
        stringBuffer.append(this.stepSize1);
        stringBuffer.append(',');
        stringBuffer.append("stepSize2");
        stringBuffer.append('=');
        stringBuffer.append(this.stepSize2);
        stringBuffer.append(',');
        stringBuffer.append("stepSize3");
        stringBuffer.append('=');
        stringBuffer.append(this.stepSize3);
        stringBuffer.append(',');
        stringBuffer.append("stepSize4");
        stringBuffer.append('=');
        stringBuffer.append(this.stepSize4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

