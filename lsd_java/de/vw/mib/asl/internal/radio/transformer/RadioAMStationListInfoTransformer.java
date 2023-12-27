/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioAMStationListInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioAMStationListInfoTransformer
extends AbstractRadioAMStationListInfoTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        AMStationInfoCollector aMStationInfoCollector = (AMStationInfoCollector)object;
        switch (n) {
            case 2: {
                return aMStationInfoCollector.hasPresetImage;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        AMStationInfoCollector aMStationInfoCollector = (AMStationInfoCollector)object;
        switch (n) {
            case 1: {
                return aMStationInfoCollector.station.getFrequency();
            }
            case 6: {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentAMStation();
                if (null != amFmStation && amFmStation.getFrequency() == aMStationInfoCollector.station.getFrequency() && aMStationInfoCollector.station.isHD()) {
                    return amFmStation.getHDStateForAMList();
                }
                return aMStationInfoCollector.station.getHDStateForAMList();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        AMStationInfoCollector aMStationInfoCollector = (AMStationInfoCollector)object;
        switch (n) {
            case 4: {
                return aMStationInfoCollector.station.getName();
            }
            case 5: {
                return aMStationInfoCollector.station.getShortNameHD();
            }
            case 0: {
                if (aMStationInfoCollector.autocompare <= 0) {
                    return "";
                }
                return new StringBuffer().append(String.valueOf(aMStationInfoCollector.autocompare)).append(" ").toString();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 7: {
                return 0L;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        AMStationInfoCollector aMStationInfoCollector = (AMStationInfoCollector)object;
        switch (n) {
            case 3: {
                return aMStationInfoCollector.imageResourceLocator;
            }
        }
        throw new IllegalArgumentException();
    }
}

