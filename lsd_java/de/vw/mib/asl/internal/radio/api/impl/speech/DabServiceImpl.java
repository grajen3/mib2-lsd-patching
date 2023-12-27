/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.dab.DabService;

public class DabServiceImpl
implements DabService {
    private int ensId;
    private int ensEcc;
    private int radioDbId;
    private int frequency;
    private long hmiUniqueId = -1L;
    private int band;
    private long sId;
    private int scidi;
    private String longName = "";
    private String shortName = "";
    private String ensembleShortName = "";
    private String ensembleFullName = "";
    private String frequencyLabel = "";
    private String componentName = "";

    @Override
    public int getEnsId() {
        return this.ensId;
    }

    @Override
    public int getEnsEcc() {
        return this.ensEcc;
    }

    @Override
    public String getEnsembleShortName() {
        return this.ensembleShortName;
    }

    @Override
    public String getEnsembleFullName() {
        return this.ensembleFullName;
    }

    @Override
    public String getFrequencyLabel() {
        return this.frequencyLabel;
    }

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
    public long getSid() {
        return this.sId;
    }

    @Override
    public String getComponentName() {
        return this.componentName;
    }

    @Override
    public int getScidi() {
        return this.scidi;
    }

    public void setEnsId(int n) {
        this.ensId = n;
    }

    public void setEnsEcc(int n) {
        this.ensEcc = n;
    }

    public void setEnsembleShortName(String string) {
        this.ensembleShortName = string;
    }

    public void setEnsembleFullName(String string) {
        this.ensembleFullName = string;
    }

    public void setFrequencyLabel(String string) {
        this.frequencyLabel = string;
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

    public void setSid(long l) {
        this.sId = l;
    }

    public void setComponentName(String string) {
        this.componentName = string;
    }

    public void setScidi(int n) {
        this.scidi = n;
    }
}

