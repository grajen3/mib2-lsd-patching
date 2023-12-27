/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

public class ProjectInfo {
    public int brand;
    public int classification;
    public int generation;
    public int derivate;
    public int addition;

    public ProjectInfo() {
        this.brand = 0;
        this.classification = 0;
        this.generation = 0;
        this.derivate = 0;
        this.addition = 0;
    }

    public ProjectInfo(int n, int n2, int n3, int n4, int n5) {
        this.brand = n;
        this.classification = n2;
        this.generation = n3;
        this.derivate = n4;
        this.addition = n5;
    }

    public int getBrand() {
        return this.brand;
    }

    public int getClassification() {
        return this.classification;
    }

    public int getGeneration() {
        return this.generation;
    }

    public int getDerivate() {
        return this.derivate;
    }

    public int getAddition() {
        return this.addition;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("ProjectInfo");
        stringBuffer.append('(');
        stringBuffer.append("brand");
        stringBuffer.append('=');
        stringBuffer.append(this.brand);
        stringBuffer.append(',');
        stringBuffer.append("classification");
        stringBuffer.append('=');
        stringBuffer.append(this.classification);
        stringBuffer.append(',');
        stringBuffer.append("generation");
        stringBuffer.append('=');
        stringBuffer.append(this.generation);
        stringBuffer.append(',');
        stringBuffer.append("derivate");
        stringBuffer.append('=');
        stringBuffer.append(this.derivate);
        stringBuffer.append(',');
        stringBuffer.append("addition");
        stringBuffer.append('=');
        stringBuffer.append(this.addition);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

