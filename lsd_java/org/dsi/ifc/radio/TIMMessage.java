/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class TIMMessage {
    public String name;
    public int pi;
    public long frequency;
    public int messageID;
    public int lengthSeconds;
    public int lengthMinutes;
    public int recordTimeSeconds;
    public int recordTimeMinutes;
    public int recordTimeHour;
    public int recordTimeDay;
    public int recordTimeMonth;
    public int recordTimeYear;

    public TIMMessage() {
        this.name = "";
        this.pi = 0;
        this.frequency = 0L;
        this.messageID = 0;
        this.lengthSeconds = 0;
        this.lengthMinutes = 0;
        this.recordTimeSeconds = 0;
        this.recordTimeMinutes = 0;
        this.recordTimeHour = 0;
        this.recordTimeDay = 0;
        this.recordTimeMonth = 0;
        this.recordTimeYear = 0;
    }

    public TIMMessage(String string, int n, long l, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.name = string;
        this.pi = n;
        this.frequency = l;
        this.messageID = n2;
        this.lengthSeconds = n3;
        this.lengthMinutes = n4;
        this.recordTimeSeconds = n5;
        this.recordTimeMinutes = n6;
        this.recordTimeHour = n7;
        this.recordTimeDay = n8;
        this.recordTimeMonth = n9;
        this.recordTimeYear = n10;
    }

    public String getName() {
        return this.name;
    }

    public int getPi() {
        return this.pi;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public int getLengthSeconds() {
        return this.lengthSeconds;
    }

    public int getLengthMinutes() {
        return this.lengthMinutes;
    }

    public int getRecordTimeSeconds() {
        return this.recordTimeSeconds;
    }

    public int getRecordTimeMinutes() {
        return this.recordTimeMinutes;
    }

    public int getRecordTimeHour() {
        return this.recordTimeHour;
    }

    public int getRecordTimeDay() {
        return this.recordTimeDay;
    }

    public int getRecordTimeMonth() {
        return this.recordTimeMonth;
    }

    public int getRecordTimeYear() {
        return this.recordTimeYear;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(750);
        stringBuffer.append("TIMMessage");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("pi");
        stringBuffer.append('=');
        stringBuffer.append(this.pi);
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("messageID");
        stringBuffer.append('=');
        stringBuffer.append(this.messageID);
        stringBuffer.append(',');
        stringBuffer.append("lengthSeconds");
        stringBuffer.append('=');
        stringBuffer.append(this.lengthSeconds);
        stringBuffer.append(',');
        stringBuffer.append("lengthMinutes");
        stringBuffer.append('=');
        stringBuffer.append(this.lengthMinutes);
        stringBuffer.append(',');
        stringBuffer.append("recordTimeSeconds");
        stringBuffer.append('=');
        stringBuffer.append(this.recordTimeSeconds);
        stringBuffer.append(',');
        stringBuffer.append("recordTimeMinutes");
        stringBuffer.append('=');
        stringBuffer.append(this.recordTimeMinutes);
        stringBuffer.append(',');
        stringBuffer.append("recordTimeHour");
        stringBuffer.append('=');
        stringBuffer.append(this.recordTimeHour);
        stringBuffer.append(',');
        stringBuffer.append("recordTimeDay");
        stringBuffer.append('=');
        stringBuffer.append(this.recordTimeDay);
        stringBuffer.append(',');
        stringBuffer.append("recordTimeMonth");
        stringBuffer.append('=');
        stringBuffer.append(this.recordTimeMonth);
        stringBuffer.append(',');
        stringBuffer.append("recordTimeYear");
        stringBuffer.append('=');
        stringBuffer.append(this.recordTimeYear);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

