/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioFMStationListInfo_NAR_SPSTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioFMStationListInfo_NAR_SPSTransformer
extends AbstractRadioFMStationListInfo_NAR_SPSTransformer {
    @Override
    public String getString(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 2: {
                return fMStationInfoCollector.station.getShortNameHD();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 5: {
                return fMStationInfoCollector.station.isCAInfoAvailable();
            }
            case 0: {
                return fMStationInfoCollector.autocompare > 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 4: {
                return fMStationInfoCollector.station.getSubscriptionStateAsHMIConstant();
            }
            case 1: {
                return fMStationInfoCollector.station.getFrequency();
            }
            case 6: {
                return fMStationInfoCollector.station.getSubChannel();
            }
            case 7: {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentFMStation();
                if (fMStationInfoCollector.station.isHD() && fMStationInfoCollector.station.getFrequency() == amFmStation.getFrequency() && fMStationInfoCollector.station.getServiceId() == amFmStation.getServiceId()) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(" station list HD reception state integer for current SPS station : Frequency : ").append(amFmStation.getFrequency()).append(" ServiceID : ").append(amFmStation.getServiceId()).log();
                    }
                    return amFmStation.getHDStateForFMList();
                }
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" station list HD reception state integer for NOT selected SPS station : Frequency : ").append(fMStationInfoCollector.station.getFrequency()).append(" ServiceID : ").append(fMStationInfoCollector.station.getServiceId()).log();
                }
                return fMStationInfoCollector.station.getHDStateForFMList();
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
    public long getLong(int n, Object object) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException();
    }
}

