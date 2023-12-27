/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCWallDetectionRightLeft {
    public boolean sector1;
    public boolean sector2;
    public boolean sector3;
    public boolean sector4;

    public PDCWallDetectionRightLeft() {
        this.sector1 = false;
        this.sector2 = false;
        this.sector3 = false;
        this.sector4 = false;
    }

    public PDCWallDetectionRightLeft(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.sector1 = bl;
        this.sector2 = bl2;
        this.sector3 = bl3;
        this.sector4 = bl4;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PDCWallDetectionRightLeft");
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

