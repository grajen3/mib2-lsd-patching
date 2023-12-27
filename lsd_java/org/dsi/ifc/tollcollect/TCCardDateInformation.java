/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

import org.dsi.ifc.global.DateTime;

public class TCCardDateInformation {
    public DateTime expirationDate;
    public DateTime issueDate;

    public TCCardDateInformation() {
        this.expirationDate = null;
        this.issueDate = null;
    }

    public TCCardDateInformation(DateTime dateTime, DateTime dateTime2) {
        this.expirationDate = dateTime;
        this.issueDate = dateTime2;
    }

    public DateTime getExpirationDate() {
        return this.expirationDate;
    }

    public DateTime getIssueDate() {
        return this.issueDate;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("TCCardDateInformation");
        stringBuffer.append('(');
        stringBuffer.append("expirationDate");
        stringBuffer.append('=');
        stringBuffer.append(this.expirationDate);
        stringBuffer.append(',');
        stringBuffer.append("issueDate");
        stringBuffer.append('=');
        stringBuffer.append(this.issueDate);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

