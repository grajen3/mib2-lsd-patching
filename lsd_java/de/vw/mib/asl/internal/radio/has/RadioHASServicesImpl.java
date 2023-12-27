/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.has;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import generated.de.vw.mib.has.containers.RadioFrequencyContainer;
import generated.de.vw.mib.has.containers.RadioPresetIndexContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.contexts.radio.RadioResults;
import generated.de.vw.mib.has.contexts.radio.RadioServicesAdapter;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class RadioHASServicesImpl
extends RadioServicesAdapter {
    private final RadioResults hasResults;
    private final AbstractASLTarget radioHASTarget;

    public RadioHASServicesImpl(AbstractASLTarget abstractASLTarget) {
        this.radioHASTarget = abstractASLTarget;
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Radio");
        hASContext.setServicesImpl(this);
        this.hasResults = (RadioResults)hASContext.getResultsImpl();
    }

    @Override
    public void decreaseRadioFrequency(int n) {
        this.radioHASTarget.triggerObserver(-1711013824, null);
        this.hasResults.decreaseRadioFrequencyResult(n, 0);
    }

    @Override
    public void increaseRadioFrequency(int n) {
        this.radioHASTarget.triggerObserver(-1509687232, null);
        this.hasResults.increaseRadioFrequencyResult(n, 0);
    }

    @Override
    public void nextRadioStation(int n) {
        if (RadioData.getAmfmDatabase().getStationListViewIsOpen()) {
            this.radioHASTarget.triggerObserver(-1979449280, null);
        } else {
            this.radioHASTarget.triggerObserver(-1962672064, null);
        }
        this.hasResults.nextRadioStationResult(n, 0);
    }

    @Override
    public void previousRadioStation(int n) {
        if (RadioData.getAmfmDatabase().getStationListViewIsOpen()) {
            this.radioHASTarget.triggerObserver(-1929117632, null);
        } else {
            this.radioHASTarget.triggerObserver(-1895563200, null);
        }
        this.hasResults.previousRadioStationResult(n, 0);
    }

    @Override
    public void seekBackward(int n) {
        EventGeneric eventGeneric = this.radioHASTarget.getEventFactory().newEvent(-805044160);
        eventGeneric.setInt(0, 0);
        this.radioHASTarget.triggerObserver(-805044160, eventGeneric);
        this.hasResults.seekBackwardResult(n, 0);
    }

    @Override
    public void seekForward(int n) {
        EventGeneric eventGeneric = this.radioHASTarget.getEventFactory().newEvent(-805044160);
        eventGeneric.setInt(0, 1);
        this.radioHASTarget.triggerObserver(-805044160, eventGeneric);
        this.hasResults.seekForwardResult(n, 0);
    }

    @Override
    public void tune(int n, RadioFrequencyContainer radioFrequencyContainer) {
        if (radioFrequencyContainer.isBandSet() && radioFrequencyContainer.isFrequencySet() && radioFrequencyContainer.isValid()) {
            EventGeneric eventGeneric = this.radioHASTarget.getEventFactory().newEvent(-1123811264);
            int n2 = radioFrequencyContainer.getBand() == 3 ? (int)radioFrequencyContainer.getFrequency() : (int)radioFrequencyContainer.getFrequency() / 1000;
            eventGeneric.setInt(0, n2);
            this.radioHASTarget.triggerObserver(-1123811264, eventGeneric);
            this.hasResults.tuneResult(n, 0);
        } else {
            this.hasResults.tuneResult(n, 1);
        }
    }

    @Override
    public void tuneStation(int n, RadioStationInfoContainer radioStationInfoContainer) {
        if (radioStationInfoContainer.isBandSet()) {
            if (radioStationInfoContainer.getBand() == 3) {
                EnsembleInfo ensembleInfo = new EnsembleInfo(radioStationInfoContainer.getEnsembleId(), radioStationInfoContainer.getExtendedCountryCode(), "", "", radioStationInfoContainer.getFrequencyLabel(), (int)radioStationInfoContainer.getFrequency(), false, false);
                ServiceInfo serviceInfo = new ServiceInfo(radioStationInfoContainer.getEnsembleId(), radioStationInfoContainer.getExtendedCountryCode(), radioStationInfoContainer.getServiceId(), "", "", new byte[0], radioStationInfoContainer.getTP(), false);
                EventGeneric eventGeneric = null;
                if (radioStationInfoContainer.isServiceComponentIdSet()) {
                    ComponentInfo componentInfo = new ComponentInfo(radioStationInfoContainer.getEnsembleId(), radioStationInfoContainer.getExtendedCountryCode(), radioStationInfoContainer.getServiceId(), radioStationInfoContainer.getServiceComponentId(), "", "", false, false);
                    eventGeneric = this.radioHASTarget.getEventFactory().newEvent(this.radioHASTarget.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB, -1970863872);
                    eventGeneric.setObject(0, componentInfo);
                    eventGeneric.setObject(1, serviceInfo);
                    eventGeneric.setObject(2, ensembleInfo);
                } else {
                    eventGeneric = this.radioHASTarget.getEventFactory().newEvent(this.radioHASTarget.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB, -1954086656);
                    eventGeneric.setObject(0, serviceInfo);
                    eventGeneric.setObject(1, ensembleInfo);
                }
                this.radioHASTarget.sendSafe(eventGeneric);
                this.hasResults.tuneStationResult(n, 0);
            } else {
                AmFmStation amFmStation = new AmFmStation();
                amFmStation.setFrequency((int)radioStationInfoContainer.getFrequency() / 1000);
                amFmStation.setWaveband(this.convertBandHAS2ASL(radioStationInfoContainer.getBand()));
                amFmStation.setPI(radioStationInfoContainer.getPICode());
                long l = RadioUtil.computeUniqueID(amFmStation);
                EventGeneric eventGeneric = this.radioHASTarget.getEventFactory().newEvent(0x4A040040);
                eventGeneric.setLong(0, l);
                this.radioHASTarget.triggerObserver(0x4A040040, eventGeneric);
                this.hasResults.tuneStationResult(n, 0);
            }
        } else {
            this.hasResults.tuneStationResult(n, 1);
        }
    }

    @Override
    public void deletePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
        EventGeneric eventGeneric = this.radioHASTarget.getEventFactory().newEvent(-1677459392);
        eventGeneric.setInt(0, this.convertBandHAS2ASL(radioPresetIndexContainer.getBand()));
        eventGeneric.setInt(1, radioPresetIndexContainer.getIndex());
        this.radioHASTarget.triggerObserver(-1677459392, eventGeneric);
        this.hasResults.deletePresetResult(n, 0);
    }

    private int convertBandHAS2ASL(int n) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 3: {
                return 2;
            }
        }
        return 1;
    }

    @Override
    public void storePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
        this.radioHASTarget.triggerObserver(-1543241664, null);
        EventGeneric eventGeneric = this.radioHASTarget.getEventFactory().newEvent(-553385920);
        eventGeneric.setInt(0, radioPresetIndexContainer.getIndex());
        this.radioHASTarget.triggerObserver(-553385920, eventGeneric);
        this.radioHASTarget.triggerObserver(-452722624, null);
        this.hasResults.storePresetResult(n, 0);
    }
}

