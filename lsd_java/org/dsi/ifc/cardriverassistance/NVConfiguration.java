/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class NVConfiguration {
    public boolean installationHUDDisplay;
    public boolean installationKombiDisplay;
    public boolean installationMMIDisplay;
    public boolean panning;
    public boolean animalDetection;
    public boolean pedestrianDetection;

    public NVConfiguration() {
        this.installationHUDDisplay = false;
        this.installationKombiDisplay = false;
        this.installationMMIDisplay = false;
        this.panning = false;
        this.animalDetection = false;
        this.pedestrianDetection = false;
    }

    public NVConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.installationHUDDisplay = bl;
        this.installationKombiDisplay = bl2;
        this.installationMMIDisplay = bl3;
        this.panning = bl4;
        this.animalDetection = bl5;
        this.pedestrianDetection = bl6;
    }

    public boolean isInstallationHUDDisplay() {
        return this.installationHUDDisplay;
    }

    public boolean isInstallationKombiDisplay() {
        return this.installationKombiDisplay;
    }

    public boolean isInstallationMMIDisplay() {
        return this.installationMMIDisplay;
    }

    public boolean isPanning() {
        return this.panning;
    }

    public boolean isAnimalDetection() {
        return this.animalDetection;
    }

    public boolean isPedestrianDetection() {
        return this.pedestrianDetection;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("NVConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("installationHUDDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.installationHUDDisplay);
        stringBuffer.append(',');
        stringBuffer.append("installationKombiDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.installationKombiDisplay);
        stringBuffer.append(',');
        stringBuffer.append("installationMMIDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.installationMMIDisplay);
        stringBuffer.append(',');
        stringBuffer.append("panning");
        stringBuffer.append('=');
        stringBuffer.append(this.panning);
        stringBuffer.append(',');
        stringBuffer.append("animalDetection");
        stringBuffer.append('=');
        stringBuffer.append(this.animalDetection);
        stringBuffer.append(',');
        stringBuffer.append("pedestrianDetection");
        stringBuffer.append('=');
        stringBuffer.append(this.pedestrianDetection);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

