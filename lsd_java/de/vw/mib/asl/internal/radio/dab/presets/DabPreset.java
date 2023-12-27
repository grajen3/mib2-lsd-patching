/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.presets.Preset;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabPreset
extends Preset {
    private ServiceInfo mService;
    private EnsembleInfo mEnsemble;
    public FrequencyInfo mFrequency = null;

    public DabPreset(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo) {
        this.mService = serviceInfo;
        this.mEnsemble = ensembleInfo;
        this.mFrequency = new FrequencyInfo(ensembleInfo.frequencyValue, ensembleInfo.frequencyLabel);
        this.setDatabaseStationId(-1L);
    }

    public DabPreset(DabPreset dabPreset) {
        if (null != dabPreset) {
            this.stationImage = dabPreset.stationImage;
            this.mService = dabPreset.mService;
            this.mEnsemble = dabPreset.mEnsemble;
            if (null != this.mEnsemble) {
                this.mFrequency = new FrequencyInfo(this.mEnsemble.frequencyValue, this.mEnsemble.frequencyLabel);
            }
            this.setDatabaseStationId(dabPreset.databaseStationId);
        }
    }

    public void getStationLogosFromDatabaseSouthSide(ServiceInfo serviceInfo) {
        if (null != serviceInfo && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
            RadioDataApi.requestRadioDabStationLogos(new ServiceInfo[]{serviceInfo}, 2);
        }
    }

    public void setAutoStoreLogo(String string) {
        GuiApiDab.updatePresetList();
        try {
            GuiApiDab.updateCurrentStationInfo();
        }
        catch (Exception exception) {
            ServiceManager.logger.info(256, new StringBuffer().append("Exception in setAutoStoreLogo() by updateCurrentStationInfo() :").append(exception).toString());
        }
        DabRadioSlsApi.notifyNewLogoAvailable();
    }

    public void setFrequency(FrequencyInfo frequencyInfo) {
        this.mFrequency = frequencyInfo;
    }

    public void tune() {
        RadioData.getDabDatabase().mTunerState.resetReceptionState(this.mEnsemble);
        RadioData.getDabDatabase().mTunerState.setCurrentService(this.mService, this.mEnsemble);
        RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
        RadioData.getDabDatabase().mPersistable.setCurrentService(this.mService);
        RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
        RadioData.getDabDatabase().mTunerState.saveCurrentEnsemble(this.mEnsemble);
        DabDsiApi.selectStoredService(this);
        RadioData.getDabDatabase().mInitialStartup = false;
    }

    public boolean hasPicture() {
        return this.stationImage != null;
    }

    public void setPicture(ResourceLocator resourceLocator) {
        this.stationImage = resourceLocator;
    }

    public ServiceInfo getService() {
        return this.mService;
    }

    public EnsembleInfo getEnsemble() {
        return this.mEnsemble;
    }

    public String toString() {
        String string = "Preset - ";
        string = new StringBuffer().append(string).append("EnsId[").append(this.mEnsemble.ensID).append("] ").toString();
        string = new StringBuffer().append(string).append("EnsEcc[").append(this.mEnsemble.ensECC).append("] ").toString();
        string = new StringBuffer().append(string).append("EnsShortName[").append(this.mEnsemble.shortName).append("] ").toString();
        string = new StringBuffer().append(string).append("SID[").append(this.mService.sID).append("] ").toString();
        string = new StringBuffer().append(string).append("ServiceShortName[").append(this.mService.shortName).append("] ").toString();
        string = new StringBuffer().append(string).append("Picture[").append(this.stationImage).append("]").toString();
        return string;
    }

    public void clearUnknownValues(short s) {
    }

    public void clear() {
    }

    void setLogoFromDatabaseSouthSide(ResourceLocator resourceLocator) {
        try {
            if (null != resourceLocator) {
                this.stationImage = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public FrequencyInfo getFrequency() {
        return this.mFrequency;
    }
}

