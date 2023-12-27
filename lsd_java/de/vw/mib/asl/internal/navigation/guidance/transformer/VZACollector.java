/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

public class VZACollector {
    public int addIconType = 0;
    public int iconType = 0;
    public int speedLimitIndex = 0;
    public boolean isItemActive = false;
    public boolean isAddItemActive = false;
    public int speedLimitKmh = 0;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VZACollector [isAddItemActive=");
        stringBuffer.append(this.isAddItemActive);
        stringBuffer.append(", isItemActive=");
        stringBuffer.append(this.isItemActive);
        stringBuffer.append(", myAddIconType=");
        stringBuffer.append(this.addIconType);
        stringBuffer.append(", myIconType=");
        stringBuffer.append(this.iconType);
        stringBuffer.append(", speedLimitIndex=");
        stringBuffer.append(this.speedLimitIndex);
        stringBuffer.append(", speedLimitKmh=");
        stringBuffer.append(this.speedLimitKmh);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

