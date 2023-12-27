/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;
import org.dsi.ifc.carcomfort.UGDOTransmittableElements;

public class UGDOConfiguration {
    public int availableHardkeys;
    public int availableSoftkeys;
    public UGDOSpecialFeatures specialFeatures;
    public int gpsSupervisionRadius;
    public UGDOTransmittableElements buttonListTransmittableElements;

    public UGDOConfiguration() {
        this.availableHardkeys = 0;
        this.availableSoftkeys = 0;
        this.specialFeatures = null;
        this.gpsSupervisionRadius = 0;
        this.buttonListTransmittableElements = null;
    }

    public UGDOConfiguration(int n, int n2, UGDOSpecialFeatures uGDOSpecialFeatures, int n3, UGDOTransmittableElements uGDOTransmittableElements) {
        this.availableHardkeys = n;
        this.availableSoftkeys = n2;
        this.specialFeatures = uGDOSpecialFeatures;
        this.gpsSupervisionRadius = n3;
        this.buttonListTransmittableElements = uGDOTransmittableElements;
    }

    public int getAvailableHardkeys() {
        return this.availableHardkeys;
    }

    public int getAvailableSoftkeys() {
        return this.availableSoftkeys;
    }

    public UGDOSpecialFeatures getSpecialFeatures() {
        return this.specialFeatures;
    }

    public int getGpsSupervisionRadius() {
        return this.gpsSupervisionRadius;
    }

    public UGDOTransmittableElements getButtonListTransmittableElements() {
        return this.buttonListTransmittableElements;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2350);
        stringBuffer.append("UGDOConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("availableHardkeys");
        stringBuffer.append('=');
        stringBuffer.append(this.availableHardkeys);
        stringBuffer.append(',');
        stringBuffer.append("availableSoftkeys");
        stringBuffer.append('=');
        stringBuffer.append(this.availableSoftkeys);
        stringBuffer.append(',');
        stringBuffer.append("specialFeatures");
        stringBuffer.append('=');
        stringBuffer.append(this.specialFeatures);
        stringBuffer.append(',');
        stringBuffer.append("gpsSupervisionRadius");
        stringBuffer.append('=');
        stringBuffer.append(this.gpsSupervisionRadius);
        stringBuffer.append(',');
        stringBuffer.append("buttonListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.buttonListTransmittableElements);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

