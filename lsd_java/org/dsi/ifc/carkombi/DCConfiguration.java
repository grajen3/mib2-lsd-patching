/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.DCTransmittableElements;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class DCConfiguration {
    public int maxVolume;
    public DCTransmittableElements elementContentSelectionListTransmittableElements;
    public boolean dependencyDrivingProfile;
    public CarArrayListTransmittableElements displayPresetsListTransmittableElements;
    public int[] displayPresetsListRAConfig;

    public DCConfiguration() {
        this.maxVolume = 0;
        this.elementContentSelectionListTransmittableElements = null;
        this.dependencyDrivingProfile = false;
        this.displayPresetsListTransmittableElements = null;
        this.displayPresetsListRAConfig = null;
    }

    public DCConfiguration(int n, DCTransmittableElements dCTransmittableElements) {
        this.maxVolume = n;
        this.elementContentSelectionListTransmittableElements = dCTransmittableElements;
        this.dependencyDrivingProfile = false;
        this.displayPresetsListTransmittableElements = null;
        this.displayPresetsListRAConfig = null;
    }

    public DCConfiguration(int n, DCTransmittableElements dCTransmittableElements, boolean bl, CarArrayListTransmittableElements carArrayListTransmittableElements, int[] nArray) {
        this.maxVolume = n;
        this.elementContentSelectionListTransmittableElements = dCTransmittableElements;
        this.dependencyDrivingProfile = bl;
        this.displayPresetsListTransmittableElements = carArrayListTransmittableElements;
        this.displayPresetsListRAConfig = nArray;
    }

    public int getMaxVolume() {
        return this.maxVolume;
    }

    public DCTransmittableElements getElementContentSelectionListTransmittableElements() {
        return this.elementContentSelectionListTransmittableElements;
    }

    public boolean isDependencyDrivingProfile() {
        return this.dependencyDrivingProfile;
    }

    public CarArrayListTransmittableElements getDisplayPresetsListTransmittableElements() {
        return this.displayPresetsListTransmittableElements;
    }

    public int[] getDisplayPresetsListRAConfig() {
        return this.displayPresetsListRAConfig;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("DCConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("maxVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.maxVolume);
        stringBuffer.append(',');
        stringBuffer.append("elementContentSelectionListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.elementContentSelectionListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("dependencyDrivingProfile");
        stringBuffer.append('=');
        stringBuffer.append(this.dependencyDrivingProfile);
        stringBuffer.append(',');
        stringBuffer.append("displayPresetsListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.displayPresetsListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("displayPresetsListRAConfig");
        stringBuffer.append('[');
        if (this.displayPresetsListRAConfig != null) {
            stringBuffer.append(this.displayPresetsListRAConfig.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.displayPresetsListRAConfig != null) {
            int n = this.displayPresetsListRAConfig.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.displayPresetsListRAConfig[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.displayPresetsListRAConfig);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

