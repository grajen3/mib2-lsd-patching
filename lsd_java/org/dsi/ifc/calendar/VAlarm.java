/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

public class VAlarm {
    public String action;
    public String description;
    public String trigger;

    public VAlarm(String string, String string2, String string3) {
        this.action = string;
        this.description = string2;
        this.trigger = string3;
    }

    public VAlarm() {
    }

    public String getAction() {
        return this.action;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public void setAction(String string) {
        this.action = string;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public void setTrigger(String string) {
        this.trigger = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("VAlarm");
        stringBuffer.append('(');
        stringBuffer.append("action");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.action);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("trigger");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.trigger);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

