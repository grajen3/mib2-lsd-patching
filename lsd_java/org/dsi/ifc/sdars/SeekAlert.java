/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class SeekAlert {
    public int seekID;
    public int sID;
    public int alertType;

    public SeekAlert() {
        this.seekID = 0;
        this.sID = 0;
        this.alertType = 0;
    }

    public SeekAlert(int n, int n2, int n3) {
        this.seekID = n;
        this.sID = n2;
        this.alertType = n3;
    }

    public int getSeekID() {
        return this.seekID;
    }

    public int getSID() {
        return this.sID;
    }

    public int getAlertType() {
        return this.alertType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SeekAlert");
        stringBuffer.append('(');
        stringBuffer.append("seekID");
        stringBuffer.append('=');
        stringBuffer.append(this.seekID);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("alertType");
        stringBuffer.append('=');
        stringBuffer.append(this.alertType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

