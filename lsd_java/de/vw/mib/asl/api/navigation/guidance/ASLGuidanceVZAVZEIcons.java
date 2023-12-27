/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceVZAVZEIcons;

public class ASLGuidanceVZAVZEIcons
implements IGuidanceVZAVZEIcons {
    private String mainIcons = "";
    private String additionalIcons = "";
    private String speedIcons = "";
    private boolean isMainIconActive = false;
    private boolean isAdditionalIconActive = false;
    private boolean isSpeedIconActive = false;

    public void setMainIcon(String string) {
        this.mainIcons = string;
    }

    @Override
    public String getMainIcon() {
        return this.mainIcons;
    }

    public void setAdditionalIcon(String string) {
        this.additionalIcons = string;
    }

    @Override
    public String getAdditionalIcon() {
        return this.additionalIcons;
    }

    public void setSpeedIcon(String string) {
        this.speedIcons = string;
    }

    @Override
    public String getSpeedIcon() {
        return this.speedIcons;
    }

    public void setMainIconActive(boolean bl) {
        this.isMainIconActive = bl;
    }

    @Override
    public boolean getMainIconActive() {
        return this.isMainIconActive;
    }

    public void setAdditionalIconActive(boolean bl) {
        this.isAdditionalIconActive = bl;
    }

    @Override
    public boolean getAdditionalIconActive() {
        return this.isAdditionalIconActive;
    }

    public void setSpeedIconActive(boolean bl) {
        this.isSpeedIconActive = bl;
    }

    @Override
    public boolean getSpeedIconActive() {
        return this.isSpeedIconActive;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ASLGuidanceVZAVZEIcons [mainIcons=");
        stringBuffer.append(this.mainIcons);
        stringBuffer.append(", additionalIcons=");
        stringBuffer.append(this.additionalIcons);
        stringBuffer.append(", speedIcons=");
        stringBuffer.append(this.speedIcons);
        stringBuffer.append(", mainIconActive=");
        stringBuffer.append(this.isMainIconActive);
        stringBuffer.append(", additionalIconActive=");
        stringBuffer.append(this.isAdditionalIconActive);
        stringBuffer.append(", speedIconActive=");
        stringBuffer.append(this.isSpeedIconActive);
        stringBuffer.append(", speedLimitKmh=");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

