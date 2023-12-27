/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

import org.dsi.ifc.tvtuner.Time;

public class EWSInfo {
    public long namePID;
    public int servicePID;
    public Time warningTime;
    public int warningType;
    public int affectedArea;
    public int warningPrio;
    public int warningSrcClass;
    public String originCountry;
    public long ewsID;
    public Time receivingTime;
    public String messageText;
    public String[] areaCodeListNames;

    public EWSInfo() {
        this.namePID = 0L;
        this.servicePID = 0;
        this.warningTime = null;
        this.warningType = 0;
        this.affectedArea = 0;
        this.warningPrio = 0;
        this.warningSrcClass = 0;
        this.originCountry = null;
        this.ewsID = 0L;
        this.receivingTime = null;
        this.messageText = null;
        this.areaCodeListNames = null;
    }

    public EWSInfo(long l, int n, Time time, int n2, int n3, int n4, int n5, String string, long l2, Time time2, String string2, String[] stringArray) {
        this.namePID = l;
        this.servicePID = n;
        this.warningTime = time;
        this.warningType = n2;
        this.affectedArea = n3;
        this.warningPrio = n4;
        this.warningSrcClass = n5;
        this.originCountry = string;
        this.ewsID = l2;
        this.receivingTime = time2;
        this.messageText = string2;
        this.areaCodeListNames = stringArray;
    }

    public long getNamePID() {
        return this.namePID;
    }

    public int getServicePID() {
        return this.servicePID;
    }

    public Time getWarningTime() {
        return this.warningTime;
    }

    public int getWarningType() {
        return this.warningType;
    }

    public int getAffectedArea() {
        return this.affectedArea;
    }

    public int getWarningPrio() {
        return this.warningPrio;
    }

    public int getWarningSrcClass() {
        return this.warningSrcClass;
    }

    public String getOriginCountry() {
        return this.originCountry;
    }

    public long getEwsID() {
        return this.ewsID;
    }

    public Time getReceivingTime() {
        return this.receivingTime;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public String[] getAreaCodeListNames() {
        return this.areaCodeListNames;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2750);
        stringBuffer.append("EWSInfo");
        stringBuffer.append('(');
        stringBuffer.append("namePID");
        stringBuffer.append('=');
        stringBuffer.append(this.namePID);
        stringBuffer.append(',');
        stringBuffer.append("servicePID");
        stringBuffer.append('=');
        stringBuffer.append(this.servicePID);
        stringBuffer.append(',');
        stringBuffer.append("warningTime");
        stringBuffer.append('=');
        stringBuffer.append(this.warningTime);
        stringBuffer.append(',');
        stringBuffer.append("warningType");
        stringBuffer.append('=');
        stringBuffer.append(this.warningType);
        stringBuffer.append(',');
        stringBuffer.append("affectedArea");
        stringBuffer.append('=');
        stringBuffer.append(this.affectedArea);
        stringBuffer.append(',');
        stringBuffer.append("warningPrio");
        stringBuffer.append('=');
        stringBuffer.append(this.warningPrio);
        stringBuffer.append(',');
        stringBuffer.append("warningSrcClass");
        stringBuffer.append('=');
        stringBuffer.append(this.warningSrcClass);
        stringBuffer.append(',');
        stringBuffer.append("originCountry");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.originCountry);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ewsID");
        stringBuffer.append('=');
        stringBuffer.append(this.ewsID);
        stringBuffer.append(',');
        stringBuffer.append("receivingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.receivingTime);
        stringBuffer.append(',');
        stringBuffer.append("messageText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.messageText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("areaCodeListNames");
        stringBuffer.append('[');
        if (this.areaCodeListNames != null) {
            stringBuffer.append(this.areaCodeListNames.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.areaCodeListNames != null) {
            int n = this.areaCodeListNames.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.areaCodeListNames[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.areaCodeListNames);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

