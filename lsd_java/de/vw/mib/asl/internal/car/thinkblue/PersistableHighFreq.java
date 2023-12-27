/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.framework.api.persistence.AbstractVersionedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.internal.car.thinkblue.AverageData;
import de.vw.mib.asl.internal.car.thinkblue.Common;

public class PersistableHighFreq
extends AbstractVersionedPersistable {
    private static final short VERSION;
    private int[] irisSegments;
    private int ecoAvgMid;
    private int irisCursorPos;
    private int irisAddedElems;
    private int longTermBluePoints;
    private int sinceRefuelBluePoints;
    private int longTermCounter;
    private int sinceRefuelCounter;

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.ecoAvgMid = persistenceInputStream.readInt();
        this.irisCursorPos = persistenceInputStream.readInt();
        this.irisAddedElems = persistenceInputStream.readInt();
        if (this.irisSegments == null) {
            this.irisSegments = new int[Common.IRIS_SEGS_SIZE];
        }
        for (int i2 = 0; i2 < this.irisSegments.length; ++i2) {
            this.irisSegments[i2] = persistenceInputStream.readInt();
        }
        this.longTermBluePoints = persistenceInputStream.readInt();
        this.longTermCounter = persistenceInputStream.readInt();
        this.sinceRefuelBluePoints = persistenceInputStream.readInt();
        this.sinceRefuelCounter = persistenceInputStream.readInt();
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeInt(this.ecoAvgMid);
        persistenceOutputStream.writeInt(this.irisCursorPos);
        persistenceOutputStream.writeInt(this.irisAddedElems);
        for (int i2 = 0; i2 < this.irisSegments.length; ++i2) {
            persistenceOutputStream.writeInt(this.irisSegments[i2]);
        }
        persistenceOutputStream.writeInt(this.longTermBluePoints);
        persistenceOutputStream.writeInt(this.longTermCounter);
        persistenceOutputStream.writeInt(this.sinceRefuelBluePoints);
        persistenceOutputStream.writeInt(this.sinceRefuelCounter);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return new short[0];
    }

    @Override
    public short getVersion() {
        return 1;
    }

    @Override
    public void clear() {
        this.irisSegments = new int[Common.IRIS_SEGS_SIZE];
    }

    public void storeIrisSegments(int[] nArray) {
        this.irisSegments = nArray;
    }

    public void storeEcoAvgMid(int n) {
        this.ecoAvgMid = n;
    }

    public void storeIrisCursorPos(int n) {
        this.irisCursorPos = n;
    }

    public int[] getIrisSegments() {
        return this.irisSegments;
    }

    public int getEcoAvgMid() {
        return this.ecoAvgMid;
    }

    public int getIrisCursorPos() {
        return this.irisCursorPos;
    }

    public int getIrisAddedElems() {
        return this.irisAddedElems;
    }

    public void storeIrisAddedElems(int n) {
        this.irisAddedElems = n;
    }

    public AverageData readLongTermData() {
        AverageData averageData = new AverageData();
        averageData.setAverage(this.longTermBluePoints);
        averageData.setCounter(this.longTermCounter);
        return averageData;
    }

    public void storeLongTermData(AverageData averageData) {
        this.longTermBluePoints = averageData.getAverage();
        this.longTermCounter = averageData.getCounter();
    }

    public AverageData readSinceRefuelData() {
        AverageData averageData = new AverageData();
        averageData.setAverage(this.sinceRefuelBluePoints);
        averageData.setCounter(this.sinceRefuelCounter);
        return averageData;
    }

    public void storeSinceRefuelData(AverageData averageData) {
        this.sinceRefuelBluePoints = averageData.getAverage();
        this.sinceRefuelCounter = averageData.getCounter();
    }
}

