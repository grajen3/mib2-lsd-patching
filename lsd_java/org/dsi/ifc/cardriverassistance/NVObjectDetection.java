/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class NVObjectDetection {
    public boolean animalDetection;
    public boolean pedestrianDetection;

    public NVObjectDetection() {
        this.animalDetection = false;
        this.pedestrianDetection = false;
    }

    public NVObjectDetection(boolean bl, boolean bl2) {
        this.animalDetection = bl;
        this.pedestrianDetection = bl2;
    }

    public boolean isAnimalDetection() {
        return this.animalDetection;
    }

    public boolean isPedestrianDetection() {
        return this.pedestrianDetection;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("NVObjectDetection");
        stringBuffer.append('(');
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

