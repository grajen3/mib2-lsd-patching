/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.energyflow;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.energyflow.EnergyFlowConstants;
import java.io.InputStream;

public final class EnergyFlowConfigData
extends AbstractConfigData {
    private short[][] featurePositions;
    private short[][] energyFlowPositions;
    private short[] shiftValues;
    private short[][] carPositions;

    public EnergyFlowConfigData(int n) {
        super(new StringBuilder(256).append(SkinHelper.getDataPath(4)).append(EnergyFlowConstants.FILE_NAME[n]).toString(), (short)21, (short)1, 6);
    }

    @Override
    protected void deserialize(InputStream inputStream) {
        this.readHeader(inputStream);
        this.readFeaturePositions(inputStream);
        this.readEnergyFlowPositions(inputStream);
        this.readShiftValues(inputStream);
        this.readCarPositions(inputStream);
    }

    private void readHeader(InputStream inputStream) {
        short s = this.getShort(inputStream, 4);
        this.onConfigFileLengthChanged(s);
    }

    private void readFeaturePositions(InputStream inputStream) {
        this.featurePositions = new short[8][2];
        this.fillArray(inputStream, this.featurePositions, 6);
    }

    private void readEnergyFlowPositions(InputStream inputStream) {
        this.energyFlowPositions = new short[24][2];
        this.fillArray(inputStream, this.energyFlowPositions, 38);
    }

    private void readShiftValues(InputStream inputStream) {
        this.shiftValues = new short[10];
        this.fillArray(inputStream, this.shiftValues, 134);
    }

    private void readCarPositions(InputStream inputStream) {
        this.carPositions = new short[1][2];
        this.fillArray(inputStream, this.carPositions, 154);
    }

    public short[][] getFeaturePositions() {
        return this.featurePositions;
    }

    public short[][] getEnergyFlowPositions() {
        return this.energyFlowPositions;
    }

    public short[] getShiftValues() {
        return this.shiftValues;
    }

    public int getFeaturePositionX(int n) {
        if (n >= 0 && n < this.featurePositions.length) {
            return this.featurePositions[n][0];
        }
        return -1;
    }

    public short getFeaturePositionY(int n) {
        if (n >= 0 && n < this.featurePositions.length) {
            return this.featurePositions[n][1];
        }
        return -1;
    }

    public short getEnergyFlowPositionX(int n) {
        if (n >= 0 && n < this.energyFlowPositions.length) {
            return this.energyFlowPositions[n][0];
        }
        return -1;
    }

    public short getEnergyFlowPositionY(int n) {
        if (n >= 0 && n < this.energyFlowPositions.length) {
            return this.energyFlowPositions[n][1];
        }
        return -1;
    }

    public short getCarPositionX(int n) {
        if (n >= 0 && n < this.carPositions.length) {
            return this.carPositions[n][0];
        }
        return -1;
    }

    public short getCarPositionY(int n) {
        if (n >= 0 && n < this.carPositions.length) {
            return this.carPositions[n][1];
        }
        return -1;
    }

    public short getShiftValue(int n) {
        if (n >= 0 && n < this.shiftValues.length) {
            return this.shiftValues[n];
        }
        return -1;
    }

    public void setFeaturePositions(short[][] sArray) {
        this.featurePositions = sArray;
    }

    public void setEnergyFlowPositions(short[][] sArray) {
        this.energyFlowPositions = sArray;
    }

    public void setShiftValues(short[] sArray) {
        this.shiftValues = sArray;
    }
}

