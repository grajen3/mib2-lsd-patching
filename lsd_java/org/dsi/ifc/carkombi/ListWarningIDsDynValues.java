/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class ListWarningIDsDynValues {
    public int pos;
    public int warningID;
    public String dynValue;

    public ListWarningIDsDynValues() {
        this.pos = 0;
        this.warningID = 0;
        this.dynValue = "";
    }

    public ListWarningIDsDynValues(int n, int n2, String string) {
        this.pos = n;
        this.warningID = n2;
        this.dynValue = string;
    }

    public int getPos() {
        return this.pos;
    }

    public int getWarningID() {
        return this.warningID;
    }

    public String getDynValue() {
        return this.dynValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ListWarningIDsDynValues");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("warningID");
        stringBuffer.append('=');
        stringBuffer.append(this.warningID);
        stringBuffer.append(',');
        stringBuffer.append("dynValue");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dynValue);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

