/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;

public class AmFmStationImpl
implements AmFmStation {
    private int radioDbId;
    private int frequency;
    private long hmiUniqueId = -1L;
    private int band;
    private String longName;
    private String shortName;
    private int hdServiceId;
    private int Pi;

    @Override
    public int getRadioDbId() {
        return this.radioDbId;
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public int getUniqueHmiId() {
        return -1;
    }

    @Override
    public long getHmiUniqueId() {
        return this.hmiUniqueId;
    }

    @Override
    public int getBand() {
        return this.band;
    }

    @Override
    public String getLongName() {
        return this.longName;
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    @Override
    public int getHdServiceId() {
        return this.hdServiceId;
    }

    @Override
    public int getPi() {
        return this.Pi;
    }

    public void setRadioDbId(int n) {
        this.radioDbId = n;
    }

    public void setFrequency(int n) {
        this.frequency = n;
    }

    public void setHmiUniqueId(long l) {
        this.hmiUniqueId = l;
    }

    public void setBand(int n) {
        this.band = n;
    }

    public void setLongName(String string) {
        this.longName = string;
    }

    public void setShortName(String string) {
        this.shortName = string;
    }

    public void setHdServiceId(int n) {
        this.hdServiceId = n;
    }

    public void setPi(int n) {
        this.Pi = n;
    }
}

