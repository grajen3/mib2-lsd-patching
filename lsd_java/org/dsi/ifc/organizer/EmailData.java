/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class EmailData {
    public boolean preferred;
    public int emailType;
    public String emailAddr;

    public EmailData() {
        this.preferred = false;
        this.emailType = 0;
        this.emailAddr = null;
    }

    public EmailData(boolean bl, int n, String string) {
        this.preferred = bl;
        this.emailType = n;
        this.emailAddr = string;
    }

    public boolean isPreferred() {
        return this.preferred;
    }

    public int getEmailType() {
        return this.emailType;
    }

    public String getEmailAddr() {
        return this.emailAddr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("EmailData");
        stringBuffer.append('(');
        stringBuffer.append("preferred");
        stringBuffer.append('=');
        stringBuffer.append(this.preferred);
        stringBuffer.append(',');
        stringBuffer.append("emailType");
        stringBuffer.append('=');
        stringBuffer.append(this.emailType);
        stringBuffer.append(',');
        stringBuffer.append("emailAddr");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.emailAddr);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

