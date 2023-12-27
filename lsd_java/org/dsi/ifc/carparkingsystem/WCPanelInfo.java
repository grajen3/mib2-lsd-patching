/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class WCPanelInfo {
    public int state;
    public double angle;
    public int positionY;
    public int positionX;

    public WCPanelInfo() {
        this.state = 0;
        this.angle = 0.0;
        this.positionY = 0;
        this.positionX = 0;
    }

    public WCPanelInfo(int n, double d2, int n2, int n3) {
        this.state = n;
        this.angle = d2;
        this.positionY = n2;
        this.positionX = n3;
    }

    public int getState() {
        return this.state;
    }

    public double getAngle() {
        return this.angle;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("WCPanelInfo");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("angle");
        stringBuffer.append('=');
        stringBuffer.append(this.angle);
        stringBuffer.append(',');
        stringBuffer.append("positionY");
        stringBuffer.append('=');
        stringBuffer.append(this.positionY);
        stringBuffer.append(',');
        stringBuffer.append("positionX");
        stringBuffer.append('=');
        stringBuffer.append(this.positionX);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

