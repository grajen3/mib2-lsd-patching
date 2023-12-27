/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCWallDetectionFrontRear {
    public boolean sector1;
    public boolean sector2;
    public boolean sector3;
    public boolean sector4;
    public boolean sector5;
    public boolean sector6;
    public boolean sector7;
    public boolean sector8;

    public PDCWallDetectionFrontRear() {
        this.sector1 = false;
        this.sector2 = false;
        this.sector3 = false;
        this.sector4 = false;
        this.sector5 = false;
        this.sector6 = false;
        this.sector7 = false;
        this.sector8 = false;
    }

    public PDCWallDetectionFrontRear(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.sector1 = bl;
        this.sector2 = bl2;
        this.sector3 = bl3;
        this.sector4 = bl4;
        this.sector5 = bl5;
        this.sector6 = bl6;
        this.sector7 = bl7;
        this.sector8 = bl8;
    }

    public boolean isSector1() {
        return this.sector1;
    }

    public boolean isSector2() {
        return this.sector2;
    }

    public boolean isSector3() {
        return this.sector3;
    }

    public boolean isSector4() {
        return this.sector4;
    }

    public boolean isSector5() {
        return this.sector5;
    }

    public boolean isSector6() {
        return this.sector6;
    }

    public boolean isSector7() {
        return this.sector7;
    }

    public boolean isSector8() {
        return this.sector8;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("PDCWallDetectionFrontRear");
        stringBuffer.append('(');
        stringBuffer.append("sector1");
        stringBuffer.append('=');
        stringBuffer.append(this.sector1);
        stringBuffer.append(',');
        stringBuffer.append("sector2");
        stringBuffer.append('=');
        stringBuffer.append(this.sector2);
        stringBuffer.append(',');
        stringBuffer.append("sector3");
        stringBuffer.append('=');
        stringBuffer.append(this.sector3);
        stringBuffer.append(',');
        stringBuffer.append("sector4");
        stringBuffer.append('=');
        stringBuffer.append(this.sector4);
        stringBuffer.append(',');
        stringBuffer.append("sector5");
        stringBuffer.append('=');
        stringBuffer.append(this.sector5);
        stringBuffer.append(',');
        stringBuffer.append("sector6");
        stringBuffer.append('=');
        stringBuffer.append(this.sector6);
        stringBuffer.append(',');
        stringBuffer.append("sector7");
        stringBuffer.append('=');
        stringBuffer.append(this.sector7);
        stringBuffer.append(',');
        stringBuffer.append("sector8");
        stringBuffer.append('=');
        stringBuffer.append(this.sector8);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

