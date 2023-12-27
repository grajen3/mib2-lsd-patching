/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class WCPanelStates {
    public boolean pairedBefore;
    public boolean secured;
    public boolean justPaired;
    public boolean defaultPin;

    public WCPanelStates() {
        this.pairedBefore = false;
        this.secured = false;
        this.justPaired = false;
        this.defaultPin = false;
    }

    public WCPanelStates(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.pairedBefore = bl;
        this.secured = bl2;
        this.justPaired = bl3;
        this.defaultPin = bl4;
    }

    public boolean isPairedBefore() {
        return this.pairedBefore;
    }

    public boolean isSecured() {
        return this.secured;
    }

    public boolean isJustPaired() {
        return this.justPaired;
    }

    public boolean isDefaultPin() {
        return this.defaultPin;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("WCPanelStates");
        stringBuffer.append('(');
        stringBuffer.append("pairedBefore");
        stringBuffer.append('=');
        stringBuffer.append(this.pairedBefore);
        stringBuffer.append(',');
        stringBuffer.append("secured");
        stringBuffer.append('=');
        stringBuffer.append(this.secured);
        stringBuffer.append(',');
        stringBuffer.append("justPaired");
        stringBuffer.append('=');
        stringBuffer.append(this.justPaired);
        stringBuffer.append(',');
        stringBuffer.append("defaultPin");
        stringBuffer.append('=');
        stringBuffer.append(this.defaultPin);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

