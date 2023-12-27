/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

public class CarConfiguration {
    public byte version;
    public byte carBrand;
    public byte carClass;
    public byte carGeneration;
    public byte carDerivate;
    public byte carDerivateSupplement;

    public byte getVersion() {
        return this.version;
    }

    public void setVersion(byte by) {
        this.version = by;
    }

    public byte getCarBrand() {
        return this.carBrand;
    }

    public void setCarBrand(byte by) {
        this.carBrand = by;
    }

    public byte getCarClass() {
        return this.carClass;
    }

    public void setCarClass(byte by) {
        this.carClass = by;
    }

    public byte getCarGeneration() {
        return this.carGeneration;
    }

    public void setCarGeneration(byte by) {
        this.carGeneration = by;
    }

    public byte getCarDerivate() {
        return this.carDerivate;
    }

    public void setCarDerivate(byte by) {
        this.carDerivate = by;
    }

    public byte getCarDerivateSupplement() {
        return this.carDerivateSupplement;
    }

    public void setCarDerivateSupplement(byte by) {
        this.carDerivateSupplement = by;
    }

    public CarConfiguration() {
    }

    public CarConfiguration(byte by, byte by2, byte by3, byte by4, byte by5, byte by6) {
        this.version = by;
        this.carBrand = by2;
        this.carClass = by3;
        this.carGeneration = by4;
        this.carDerivate = by5;
        this.carDerivateSupplement = by6;
    }

    public String toString() {
        return new StringBuffer("CarConfiguration{").append("version=").append(this.version).append(", carBrand=").append(this.carBrand).append(", carClass=").append(this.carClass).append(", carGeneration=").append(this.carGeneration).append(", carDerivate=").append(this.carDerivate).append(", carDerivateSupplement=").append(this.carDerivateSupplement).append("}").toString();
    }
}

