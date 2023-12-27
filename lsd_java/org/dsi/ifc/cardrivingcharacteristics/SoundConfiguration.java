/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.SoundAvailableStyles;

public class SoundConfiguration {
    public SoundAvailableStyles availableSoundStyles;

    public SoundConfiguration() {
        this.availableSoundStyles = null;
    }

    public SoundConfiguration(SoundAvailableStyles soundAvailableStyles) {
        this.availableSoundStyles = soundAvailableStyles;
    }

    public SoundAvailableStyles getAvailableSoundStyles() {
        return this.availableSoundStyles;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("SoundConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("availableSoundStyles");
        stringBuffer.append('=');
        stringBuffer.append(this.availableSoundStyles);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

