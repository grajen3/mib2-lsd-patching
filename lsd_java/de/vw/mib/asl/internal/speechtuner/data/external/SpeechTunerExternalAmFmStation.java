/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.external;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;

public class SpeechTunerExternalAmFmStation
implements AmFmStation {
    private int radioDbId;
    private long hmiUniqueId;
    private int band;
    private int frequency;
    private int hdServiceId;
    private String longName;
    private String shortName;

    public SpeechTunerExternalAmFmStation(int n, long l, int n2, int n3, int n4, String string, String string2) {
        this.radioDbId = n;
        this.hmiUniqueId = l;
        this.band = n2;
        this.frequency = n3;
        this.hdServiceId = n4;
        this.longName = string;
        this.shortName = string2;
    }

    @Override
    public int getBand() {
        return this.band;
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public int getHdServiceId() {
        return this.hdServiceId;
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
    public int getRadioDbId() {
        return this.radioDbId;
    }

    @Override
    public int getUniqueHmiId() {
        return new Long(this.hmiUniqueId).intValue();
    }

    @Override
    public long getHmiUniqueId() {
        return this.hmiUniqueId;
    }

    @Override
    public int getPi() {
        return -1;
    }
}

