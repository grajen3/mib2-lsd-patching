/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

public class VAttendee {
    public String cn;
    public String cutype;
    public String mailto;
    public String role;
    public String rsvp;

    public VAttendee() {
    }

    public VAttendee(String string, String string2, String string3, String string4, String string5) {
        this.cn = string;
        this.cutype = string2;
        this.mailto = string3;
        this.role = string4;
        this.rsvp = string5;
    }

    public String getCn() {
        return this.cn;
    }

    public String getCutype() {
        return this.cutype;
    }

    public String getMailto() {
        return this.mailto;
    }

    public String getRole() {
        return this.role;
    }

    public String getRsvp() {
        return this.rsvp;
    }

    public void setCn(String string) {
        this.cn = string;
    }

    public void setCutype(String string) {
        this.cutype = string;
    }

    public void setMailto(String string) {
        this.mailto = string;
    }

    public void setRole(String string) {
        this.role = string;
    }

    public void setRsvp(String string) {
        this.rsvp = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("VAttendee");
        stringBuffer.append('(');
        stringBuffer.append("cn");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.cn);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("cutype");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.cutype);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mailto");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mailto);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("role");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.role);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("rsvp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.rsvp);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

