/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconNozzleListCapabilities {
    public boolean horizontalPosition;
    public boolean verticalPosition;
    public boolean airflow;
    public boolean style;
    public boolean intervalHorizontal;
    public boolean intervalVertical;

    public AirconNozzleListCapabilities() {
        this.horizontalPosition = false;
        this.verticalPosition = false;
        this.airflow = false;
        this.style = false;
        this.intervalHorizontal = false;
        this.intervalVertical = false;
    }

    public AirconNozzleListCapabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.horizontalPosition = bl;
        this.verticalPosition = bl2;
        this.airflow = bl3;
        this.style = bl4;
        this.intervalHorizontal = bl5;
        this.intervalVertical = bl6;
    }

    public boolean isHorizontalPosition() {
        return this.horizontalPosition;
    }

    public boolean isVerticalPosition() {
        return this.verticalPosition;
    }

    public boolean isAirflow() {
        return this.airflow;
    }

    public boolean isStyle() {
        return this.style;
    }

    public boolean isIntervalHorizontal() {
        return this.intervalHorizontal;
    }

    public boolean isIntervalVertical() {
        return this.intervalVertical;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AirconNozzleListCapabilities");
        stringBuffer.append('(');
        stringBuffer.append("horizontalPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.horizontalPosition);
        stringBuffer.append(',');
        stringBuffer.append("verticalPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.verticalPosition);
        stringBuffer.append(',');
        stringBuffer.append("airflow");
        stringBuffer.append('=');
        stringBuffer.append(this.airflow);
        stringBuffer.append(',');
        stringBuffer.append("style");
        stringBuffer.append('=');
        stringBuffer.append(this.style);
        stringBuffer.append(',');
        stringBuffer.append("intervalHorizontal");
        stringBuffer.append('=');
        stringBuffer.append(this.intervalHorizontal);
        stringBuffer.append(',');
        stringBuffer.append("intervalVertical");
        stringBuffer.append('=');
        stringBuffer.append(this.intervalVertical);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

