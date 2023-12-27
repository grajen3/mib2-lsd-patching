/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class HybridSinkState {
    public boolean installation;
    public boolean heating;
    public boolean cooling;

    public HybridSinkState() {
        this.installation = false;
        this.heating = false;
        this.cooling = false;
    }

    public HybridSinkState(boolean bl, boolean bl2, boolean bl3) {
        this.installation = bl;
        this.heating = bl2;
        this.cooling = bl3;
    }

    public boolean isInstallation() {
        return this.installation;
    }

    public boolean isHeating() {
        return this.heating;
    }

    public boolean isCooling() {
        return this.cooling;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("HybridSinkState");
        stringBuffer.append('(');
        stringBuffer.append("installation");
        stringBuffer.append('=');
        stringBuffer.append(this.installation);
        stringBuffer.append(',');
        stringBuffer.append("heating");
        stringBuffer.append('=');
        stringBuffer.append(this.heating);
        stringBuffer.append(',');
        stringBuffer.append("cooling");
        stringBuffer.append('=');
        stringBuffer.append(this.cooling);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

