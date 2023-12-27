/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCPLABargraph {
    public int arrowIndication;
    public int arrowLevel;

    public PDCPLABargraph() {
        this.arrowIndication = 0;
        this.arrowLevel = 0;
    }

    public PDCPLABargraph(int n, int n2) {
        this.arrowIndication = n;
        this.arrowLevel = n2;
    }

    public int getArrowIndication() {
        return this.arrowIndication;
    }

    public int getArrowLevel() {
        return this.arrowLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PDCPLABargraph");
        stringBuffer.append('(');
        stringBuffer.append("arrowIndication");
        stringBuffer.append('=');
        stringBuffer.append(this.arrowIndication);
        stringBuffer.append(',');
        stringBuffer.append("arrowLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.arrowLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

