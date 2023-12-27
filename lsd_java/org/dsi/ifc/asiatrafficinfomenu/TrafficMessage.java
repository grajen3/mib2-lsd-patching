/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

import org.dsi.ifc.global.DateTime;

public class TrafficMessage {
    public int trafficMessageID;
    public boolean isValid;
    public int[] detailContentIDs;
    public String value;
    public DateTime date;
    public int contentID;

    public TrafficMessage() {
        this.trafficMessageID = 0;
        this.isValid = false;
        this.detailContentIDs = null;
        this.value = null;
        this.date = null;
        this.contentID = 0;
    }

    public TrafficMessage(int n, boolean bl, int[] nArray, String string, DateTime dateTime, int n2) {
        this.trafficMessageID = n;
        this.isValid = bl;
        this.detailContentIDs = nArray;
        this.value = string;
        this.date = dateTime;
        this.contentID = n2;
    }

    public int getTrafficMessageID() {
        return this.trafficMessageID;
    }

    public boolean isIsValid() {
        return this.isValid;
    }

    public int[] getDetailContentIDs() {
        return this.detailContentIDs;
    }

    public String getValue() {
        return this.value;
    }

    public DateTime getDate() {
        return this.date;
    }

    public int getContentID() {
        return this.contentID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("TrafficMessage");
        stringBuffer.append('(');
        stringBuffer.append("trafficMessageID");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficMessageID);
        stringBuffer.append(',');
        stringBuffer.append("isValid");
        stringBuffer.append('=');
        stringBuffer.append(this.isValid);
        stringBuffer.append(',');
        stringBuffer.append("detailContentIDs");
        stringBuffer.append('[');
        if (this.detailContentIDs != null) {
            stringBuffer.append(this.detailContentIDs.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.detailContentIDs != null) {
            int n = this.detailContentIDs.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.detailContentIDs[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.detailContentIDs);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("date");
        stringBuffer.append('=');
        stringBuffer.append(this.date);
        stringBuffer.append(',');
        stringBuffer.append("contentID");
        stringBuffer.append('=');
        stringBuffer.append(this.contentID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

