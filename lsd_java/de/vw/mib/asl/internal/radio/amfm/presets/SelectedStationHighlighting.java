/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetTarget;
import org.dsi.ifc.radio.Station;

public final class SelectedStationHighlighting {
    private static boolean presetHighlightingIsActive = false;
    private static Station tunedStationByApplication = null;
    private static AmFmPresetTarget presetTarget = null;
    private static int hdStructure = 0;

    public static void setStationSelectionIsActive(boolean bl, boolean bl2) {
        if (presetHighlightingIsActive && null != tunedStationByApplication && bl2) {
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
            AmFmStation amFmStation2 = new AmFmStation();
            if (null != amFmStation) {
                amFmStation2 = new AmFmStation(amFmStation);
            }
            amFmStation2.setStation(tunedStationByApplication);
            RadioData.getAmfmDatabase().setCurrentStation(amFmStation2);
            AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation2);
        }
        presetHighlightingIsActive = bl;
        if (null != presetTarget) {
            presetTarget.stopTimer(-1601765120);
            if (presetHighlightingIsActive) {
                presetTarget.startTimer(-1601765120, (long)0, false);
            }
        }
    }

    public static void setApplicationStationToHmiStation() {
        if (null != tunedStationByApplication && !HsmTarget.waitingForUpdateSelectedStation) {
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
            AmFmStation amFmStation2 = new AmFmStation();
            if (null != amFmStation) {
                amFmStation2 = new AmFmStation(amFmStation);
            }
            amFmStation2.setStation(tunedStationByApplication);
            RadioData.getAmfmDatabase().setCurrentStation(amFmStation2);
        }
    }

    public static void updateGui(boolean bl) {
        if ((presetHighlightingIsActive || bl) && null != tunedStationByApplication) {
            AmFmStation amFmStation = new AmFmStation();
            AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
            if (null != amFmStation2) {
                amFmStation = new AmFmStation(amFmStation2);
            }
            amFmStation.setStation(tunedStationByApplication);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                amFmStation.setSubChannelBitMask(SelectedStationHighlighting.getHdStructure());
                AmFmPresetApi.getParent().updateGuiHD(amFmStation);
                AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
            } else {
                AmFmPresetApi.getParent().updateGui(amFmStation);
            }
        }
    }

    public static boolean getStationSelectionIsActive() {
        return presetHighlightingIsActive;
    }

    public static void setTunedStationByApplication(Station station) {
        tunedStationByApplication = null == station ? null : new Station(station.name, station.frequency, station.pi, station.receptionQuality, station.ptyCode, station.waveband, station.rds, station.tp, station.ta, station.tmc, station.scrollingPS, station.radioText, station.realPS, station.hd, station.shortNameHD, station.longNameHD, station.fullDigital, station.serviceId, station.subscription, station.eon, station.coChannel, station.stationArt);
    }

    public static AmFmStation getTunedStationByApplication() {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (null != tunedStationByApplication && null != amFmStation) {
            AmFmStation amFmStation2 = new AmFmStation(amFmStation);
            amFmStation2.setStation(tunedStationByApplication);
            return amFmStation2;
        }
        return null;
    }

    public static boolean isTunedStationNameValid() {
        return null != tunedStationByApplication && null != SelectedStationHighlighting.tunedStationByApplication.name && SelectedStationHighlighting.tunedStationByApplication.name.length() > 0;
    }

    public static void setPresetTarget(AmFmPresetTarget amFmPresetTarget) {
        presetTarget = amFmPresetTarget;
    }

    public static AmFmPresetTarget getPresetTarget() {
        return presetTarget;
    }

    public static int getHdStructure() {
        return hdStructure;
    }

    public static void setHdStructure(int n) {
        hdStructure = n;
    }
}

