/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import java.util.Set;

public final class AmFmFixedStationList {
    private final AmFmStation[] mList;
    private int mIndex;

    public AmFmFixedStationList(Set set) {
        if (set == null || set.size() == 0) {
            this.mList = new AmFmStation[0];
            this.mIndex = -1;
        } else {
            this.mList = (AmFmStation[])set.toArray(new AmFmStation[set.size()]);
            this.mIndex = 0;
        }
    }

    public AmFmFixedStationList(AmFmStationList amFmStationList) {
        if (amFmStationList != null && amFmStationList.size() > 0) {
            Set set = amFmStationList.getListCopy();
            this.mList = set != null && set.size() > 0 ? amFmStationList.toArray() : new AmFmStation[0];
            this.mIndex = 0;
        } else {
            this.mList = new AmFmStation[0];
            this.mIndex = -1;
        }
    }

    public AmFmFixedStationList(AmFmStation amFmStation) {
        AmFmStationList amFmStationList = RadioData.getAmfmDatabase().getCurrentStationList();
        if (null != amFmStationList) {
            AmFmStationList amFmStationList2 = null;
            if (RadioCurrentWaveband.isAm()) {
                amFmStationList2 = amFmStationList.generateFrozenAmList(amFmStation);
            } else if (RadioCurrentWaveband.isFm()) {
                amFmStationList2 = amFmStationList.generateFrozenFmList(amFmStation);
            }
            if (null != amFmStationList2) {
                this.mList = amFmStationList2.toArray();
                this.mIndex = -1;
                this.setActual(amFmStation);
            } else {
                this.mList = new AmFmStation[0];
            }
        } else {
            this.mList = new AmFmStation[0];
        }
    }

    public AmFmFixedStationList(AmFmStation[] amFmStationArray) {
        if (amFmStationArray == null || amFmStationArray.length == 0) {
            this.mList = new AmFmStation[0];
            this.mIndex = -1;
        } else {
            this.mList = amFmStationArray;
            this.mIndex = 0;
        }
    }

    public AmFmStation next() {
        if (this.mList.length > 0) {
            ++this.mIndex;
            if (this.mIndex >= this.mList.length) {
                this.mIndex = 0;
            }
            return this.mList[this.mIndex];
        }
        return null;
    }

    public AmFmStation prev() {
        if (this.mList.length > 0) {
            --this.mIndex;
            if (this.mIndex < 0) {
                this.mIndex = this.mList.length - 1;
            }
            return this.mList[this.mIndex];
        }
        return null;
    }

    public AmFmStation first() {
        if (this.mList.length > 0) {
            this.mIndex = 0;
            return this.mList[this.mIndex];
        }
        return null;
    }

    public int setActual(AmFmStation amFmStation) {
        if (amFmStation != null && null != this.mList) {
            for (int i2 = 0; i2 < this.mList.length; ++i2) {
                if (!this.mList[i2].equals(amFmStation)) continue;
                this.mIndex = i2;
                return this.mIndex;
            }
        }
        return -1;
    }

    public int size() {
        return this.mList.length;
    }

    public AmFmStation prepareNext(AmFmStation amFmStation) {
        int n = 0;
        if (amFmStation != null) {
            int n2 = this.mList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                n = i2 + 1;
                if (n < n2 && this.mList[i2].getFrequency() < amFmStation.getFrequency() && this.mList[n].getFrequency() > amFmStation.getFrequency()) {
                    this.mIndex = n;
                    return this.mList[n];
                }
                if (this.mList[i2].getFrequency() <= amFmStation.getFrequency() && this.mList[n2 - 1].getFrequency() >= amFmStation.getFrequency()) continue;
                this.mIndex = i2;
                return this.mList[i2];
            }
        }
        return null;
    }

    public void writeInFileLogger() {
    }
}

