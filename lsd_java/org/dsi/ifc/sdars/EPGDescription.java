/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class EPGDescription {
    public int sID;
    public int programID;
    public String seriesDescription;
    public String programDescription;

    public EPGDescription() {
        this.sID = 0;
        this.programID = 0;
        this.seriesDescription = "";
        this.programDescription = "";
    }

    public EPGDescription(int n, int n2, String string, String string2) {
        this.sID = n;
        this.programID = n2;
        this.seriesDescription = string;
        this.programDescription = string2;
    }

    public int getSID() {
        return this.sID;
    }

    public int getProgramID() {
        return this.programID;
    }

    public String getSeriesDescription() {
        return this.seriesDescription;
    }

    public String getProgramDescription() {
        return this.programDescription;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("EPGDescription");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("programID");
        stringBuffer.append('=');
        stringBuffer.append(this.programID);
        stringBuffer.append(',');
        stringBuffer.append("seriesDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.seriesDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("programDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.programDescription);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

