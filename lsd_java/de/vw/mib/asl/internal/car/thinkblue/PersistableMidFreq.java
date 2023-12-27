/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.framework.api.persistence.AbstractVersionedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.internal.car.thinkblue.Common;

public class PersistableMidFreq
extends AbstractVersionedPersistable {
    private boolean trendEco;
    private boolean trendCons;
    private int[] ecoHistory;
    private float[] consHistory;
    private int consumptionUnit;
    private int historyStyle;

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        int n;
        this.consumptionUnit = persistenceInputStream.readInt();
        this.trendEco = persistenceInputStream.readBoolean();
        this.trendCons = persistenceInputStream.readBoolean();
        this.clear();
        for (n = 0; n < this.ecoHistory.length; ++n) {
            this.ecoHistory[n] = persistenceInputStream.readInt();
        }
        for (n = 0; n < this.consHistory.length; ++n) {
            this.consHistory[n] = persistenceInputStream.readFloat();
        }
        this.historyStyle = persistenceInputStream.readInt();
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        int n;
        persistenceOutputStream.writeInt(this.consumptionUnit);
        persistenceOutputStream.writeBoolean(this.trendEco);
        persistenceOutputStream.writeBoolean(this.trendCons);
        for (n = 0; n < this.ecoHistory.length; ++n) {
            persistenceOutputStream.writeInt(this.ecoHistory[n]);
        }
        for (n = 0; n < this.consHistory.length; ++n) {
            persistenceOutputStream.writeFloat(this.consHistory[n]);
        }
        persistenceOutputStream.writeInt(this.historyStyle);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return null;
    }

    @Override
    public short getVersion() {
        return 0;
    }

    @Override
    public void clear() {
        if (this.ecoHistory == null) {
            this.ecoHistory = new int[Common.HISTORY_GRAPH_SIZE];
        }
        if (this.consHistory == null) {
            this.consHistory = new float[Common.HISTORY_GRAPH_SIZE];
        }
        this.historyStyle = 0;
    }

    public void setTrendEco(boolean bl) {
        this.trendEco = bl;
    }

    public void setTrendCons(boolean bl) {
        this.trendCons = bl;
    }

    public void setHistoryEco(int[] nArray) {
        this.ecoHistory = nArray;
    }

    public void setHistoryCons(float[] fArray) {
        this.consHistory = fArray;
    }

    public void setHistoryStyle(int n) {
        this.historyStyle = n;
    }

    public boolean getTrendEco() {
        return this.trendEco;
    }

    public boolean getTrendCons() {
        return this.trendCons;
    }

    public int[] getHistoryEco() {
        return this.ecoHistory;
    }

    public float[] getHistoryCons() {
        return this.consHistory;
    }

    public int getHistoryStyle() {
        return this.historyStyle;
    }

    public int getConsumptionUnit() {
        return this.consumptionUnit;
    }

    public void setConsumptionUnit(int n) {
        this.consumptionUnit = n;
    }
}

