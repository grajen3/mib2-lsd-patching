/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.sdars.SiriusChannel;

public class SiriusChannelImpl
implements SiriusChannel {
    private int radioDbId;
    private int frequency;
    private long hmiUniqueId = -1L;
    private int band;
    private String longName;
    private String shortName;
    private int stationNumber;
    private int sId;

    @Override
    public int getRadioDbId() {
        return this.radioDbId;
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int n) {
        this.frequency = n;
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
    public int getStationNumber() {
        return this.stationNumber;
    }

    @Override
    public int getSid() {
        return this.sId;
    }

    public void setUniqueHmiId(long l) {
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

    public void setStationNumber(int n) {
        this.stationNumber = n;
    }

    public void setSid(int n) {
        this.sId = n;
    }
}

