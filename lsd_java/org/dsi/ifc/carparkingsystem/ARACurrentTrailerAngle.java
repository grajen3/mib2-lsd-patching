/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class ARACurrentTrailerAngle {
    public int angle;
    public boolean valid;

    public ARACurrentTrailerAngle() {
        this.angle = 0;
        this.valid = false;
    }

    public ARACurrentTrailerAngle(int n, boolean bl) {
        this.angle = n;
        this.valid = bl;
    }

    public int getAngle() {
        return this.angle;
    }

    public boolean isValid() {
        return this.valid;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ARACurrentTrailerAngle");
        stringBuffer.append('(');
        stringBuffer.append("angle");
        stringBuffer.append('=');
        stringBuffer.append(this.angle);
        stringBuffer.append(',');
        stringBuffer.append("valid");
        stringBuffer.append('=');
        stringBuffer.append(this.valid);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

