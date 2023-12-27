/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

public class VZAIconsCollector {
    public String mainIcons = "";
    public String additionalIcons = "";
    public String speedIcons = "";
    public String bgInteractiveMode = "";
    public String bgDisplayMode = "";
    public boolean isMainIconActive = false;
    public boolean isAdditionalIconActive = false;
    public boolean isSpeedIconActive = false;
    public int speedLimitKmh = 0;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VZACIconsollector [mainIcons=");
        stringBuffer.append(this.mainIcons);
        stringBuffer.append(", additionalIcons=");
        stringBuffer.append(this.additionalIcons);
        stringBuffer.append(", speedIcons=");
        stringBuffer.append(this.speedIcons);
        stringBuffer.append(", bgInteractiveMode=");
        stringBuffer.append(this.bgInteractiveMode);
        stringBuffer.append(", bgDisplayMode=");
        stringBuffer.append(this.bgDisplayMode);
        stringBuffer.append(", mainIconActive=");
        stringBuffer.append(this.isMainIconActive);
        stringBuffer.append(", additionalIconActive=");
        stringBuffer.append(this.isAdditionalIconActive);
        stringBuffer.append(", speedIconActive=");
        stringBuffer.append(this.isSpeedIconActive);
        stringBuffer.append(", speedLimitKmh=");
        stringBuffer.append(this.speedLimitKmh);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

