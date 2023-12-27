/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOSpecialFeatures {
    public boolean doorName;
    public boolean gpsSupervision;
    public boolean keyFob;
    public boolean biDirectionalCommunication;
    public boolean fixkitMode;
    public boolean defaultMode;

    public UGDOSpecialFeatures() {
        this.doorName = false;
        this.gpsSupervision = false;
        this.keyFob = false;
        this.biDirectionalCommunication = false;
        this.fixkitMode = false;
        this.defaultMode = false;
    }

    public UGDOSpecialFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.doorName = bl;
        this.gpsSupervision = bl2;
        this.keyFob = bl3;
        this.biDirectionalCommunication = bl4;
        this.fixkitMode = false;
        this.defaultMode = false;
    }

    public UGDOSpecialFeatures(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.doorName = bl;
        this.gpsSupervision = bl2;
        this.keyFob = bl3;
        this.biDirectionalCommunication = bl4;
        this.fixkitMode = bl5;
        this.defaultMode = bl6;
    }

    public boolean isDoorName() {
        return this.doorName;
    }

    public boolean isGpsSupervision() {
        return this.gpsSupervision;
    }

    public boolean isKeyFob() {
        return this.keyFob;
    }

    public boolean isBiDirectionalCommunication() {
        return this.biDirectionalCommunication;
    }

    public boolean isFixkitMode() {
        return this.fixkitMode;
    }

    public boolean isDefaultMode() {
        return this.defaultMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("UGDOSpecialFeatures");
        stringBuffer.append('(');
        stringBuffer.append("doorName");
        stringBuffer.append('=');
        stringBuffer.append(this.doorName);
        stringBuffer.append(',');
        stringBuffer.append("gpsSupervision");
        stringBuffer.append('=');
        stringBuffer.append(this.gpsSupervision);
        stringBuffer.append(',');
        stringBuffer.append("keyFob");
        stringBuffer.append('=');
        stringBuffer.append(this.keyFob);
        stringBuffer.append(',');
        stringBuffer.append("biDirectionalCommunication");
        stringBuffer.append('=');
        stringBuffer.append(this.biDirectionalCommunication);
        stringBuffer.append(',');
        stringBuffer.append("fixkitMode");
        stringBuffer.append('=');
        stringBuffer.append(this.fixkitMode);
        stringBuffer.append(',');
        stringBuffer.append("defaultMode");
        stringBuffer.append('=');
        stringBuffer.append(this.defaultMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

