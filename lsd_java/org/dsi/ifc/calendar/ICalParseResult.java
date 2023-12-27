/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

public class ICalParseResult {
    public String fileAbslPath;
    public String errorText;
    public int resultCode;

    public ICalParseResult() {
    }

    public ICalParseResult(String string, String string2, int n) {
        this.fileAbslPath = string;
        this.errorText = string2;
        this.resultCode = n;
    }

    public String getFileAbslPath() {
        return this.fileAbslPath;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("ICalParseResult");
        stringBuffer.append('(');
        stringBuffer.append("fileAbslPath");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fileAbslPath);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("errorText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.errorText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("resultCode");
        stringBuffer.append('=');
        stringBuffer.append(this.resultCode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

