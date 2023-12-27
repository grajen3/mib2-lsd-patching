/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSDefaultMode {
    public int vpsScreen;
    public int vpsMode;

    public VPSDefaultMode() {
        this.vpsScreen = 0;
        this.vpsMode = 0;
    }

    public VPSDefaultMode(int n, int n2) {
        this.vpsScreen = n;
        this.vpsMode = n2;
    }

    public int getVpsScreen() {
        return this.vpsScreen;
    }

    public int getVpsMode() {
        return this.vpsMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("VPSDefaultMode");
        stringBuffer.append('(');
        stringBuffer.append("vpsScreen");
        stringBuffer.append('=');
        stringBuffer.append(this.vpsScreen);
        stringBuffer.append(',');
        stringBuffer.append("vpsMode");
        stringBuffer.append('=');
        stringBuffer.append(this.vpsMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

