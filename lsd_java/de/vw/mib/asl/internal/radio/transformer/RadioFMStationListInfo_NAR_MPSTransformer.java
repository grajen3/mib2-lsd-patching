/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioFMStationListInfo_NAR_MPSTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioFMStationListInfo_NAR_MPSTransformer
extends AbstractRadioFMStationListInfo_NAR_MPSTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 6: {
                return fMStationInfoCollector.station.isCAInfoAvailable();
            }
            case 0: {
                return fMStationInfoCollector.autocompare > 0;
            }
            case 7: {
                return RadioData.getAmfmDatabase().hasSubServiceList(fMStationInfoCollector.station);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 5: {
                return fMStationInfoCollector.station.getSubscriptionStateAsHMIConstant();
            }
            case 4: {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentFMStation();
                if (fMStationInfoCollector.station.isHD() && fMStationInfoCollector.station.getFrequency() == amFmStation.getFrequency() && fMStationInfoCollector.station.getServiceId() == amFmStation.getServiceId()) {
                    return amFmStation.getHDStateForFMList();
                }
                return fMStationInfoCollector.station.getHDStateForFMList();
            }
            case 1: {
                return fMStationInfoCollector.station.getFrequency();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 5: {
                return 0L;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 3: {
                return fMStationInfoCollector.station.getShortNameHD();
            }
            case 2: {
                if (fMStationInfoCollector.station.isHD()) {
                    return fMStationInfoCollector.station.getLongNameHD();
                }
                return fMStationInfoCollector.station.getName();
            }
        }
        throw new IllegalArgumentException();
    }
}

