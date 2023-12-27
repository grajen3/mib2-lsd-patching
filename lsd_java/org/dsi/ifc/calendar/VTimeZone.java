/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.calendar.VTimeZoneStandard;

public class VTimeZone {
    public String tzID;
    public VTimeZoneStandard[] daylight;
    public VTimeZoneStandard[] standard;

    public VTimeZone() {
    }

    public VTimeZone(String string, VTimeZoneStandard[] vTimeZoneStandardArray, VTimeZoneStandard[] vTimeZoneStandardArray2) {
        this.tzID = string;
        this.daylight = vTimeZoneStandardArray;
        this.standard = vTimeZoneStandardArray2;
    }

    public String getTzID() {
        return this.tzID;
    }

    public VTimeZoneStandard[] getDaylight() {
        return this.daylight;
    }

    public VTimeZoneStandard[] getStandard() {
        return this.standard;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("VTimeZone");
        stringBuffer.append('(');
        stringBuffer.append("tzID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.tzID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("daylight");
        stringBuffer.append('[');
        if (this.daylight != null) {
            stringBuffer.append(this.daylight.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.daylight != null) {
            n3 = this.daylight.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.daylight[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.daylight);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("standard");
        stringBuffer.append('[');
        if (this.standard != null) {
            stringBuffer.append(this.standard.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.standard != null) {
            n3 = this.standard.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.standard[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.standard);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

