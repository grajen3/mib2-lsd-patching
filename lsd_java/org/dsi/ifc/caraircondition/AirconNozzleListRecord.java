/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public class AirconNozzleListRecord {
    public int pos;
    public int horizontalPosition;
    public int verticalPosition;
    public AirconNozzleListCapabilities capabilities;
    public int horizontal;
    public int vertical;
    public int airflow;
    public AirconNozzleListStyles style;
    public int intervalHorizontal;
    public int intervalVertical;

    public AirconNozzleListRecord() {
        this.pos = 0;
        this.horizontalPosition = 0;
        this.verticalPosition = 0;
        this.capabilities = null;
        this.horizontal = 0;
        this.vertical = 0;
        this.airflow = 0;
        this.style = null;
        this.intervalHorizontal = 0;
        this.intervalVertical = 0;
    }

    public AirconNozzleListRecord(int n, int n2, int n3, AirconNozzleListCapabilities airconNozzleListCapabilities, int n4, int n5, int n6, AirconNozzleListStyles airconNozzleListStyles, int n7, int n8) {
        this.pos = n;
        this.horizontalPosition = n2;
        this.verticalPosition = n3;
        this.capabilities = airconNozzleListCapabilities;
        this.horizontal = n4;
        this.vertical = n5;
        this.airflow = n6;
        this.style = airconNozzleListStyles;
        this.intervalHorizontal = n7;
        this.intervalVertical = n8;
    }

    public int getPos() {
        return this.pos;
    }

    public int getHorizontalPosition() {
        return this.horizontalPosition;
    }

    public int getVerticalPosition() {
        return this.verticalPosition;
    }

    public AirconNozzleListCapabilities getCapabilities() {
        return this.capabilities;
    }

    public int getHorizontal() {
        return this.horizontal;
    }

    public int getVertical() {
        return this.vertical;
    }

    public int getAirflow() {
        return this.airflow;
    }

    public AirconNozzleListStyles getStyle() {
        return this.style;
    }

    public int getIntervalHorizontal() {
        return this.intervalHorizontal;
    }

    public int getIntervalVertical() {
        return this.intervalVertical;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2550);
        stringBuffer.append("AirconNozzleListRecord");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("horizontalPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.horizontalPosition);
        stringBuffer.append(',');
        stringBuffer.append("verticalPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.verticalPosition);
        stringBuffer.append(',');
        stringBuffer.append("capabilities");
        stringBuffer.append('=');
        stringBuffer.append(this.capabilities);
        stringBuffer.append(',');
        stringBuffer.append("horizontal");
        stringBuffer.append('=');
        stringBuffer.append(this.horizontal);
        stringBuffer.append(',');
        stringBuffer.append("vertical");
        stringBuffer.append('=');
        stringBuffer.append(this.vertical);
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

