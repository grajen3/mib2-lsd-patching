/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioFMStationListInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioFMStationListInfoTransformer
extends AbstractRadioFMStationListInfoTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 2: {
                return fMStationInfoCollector.hasPresetImage;
            }
            case 9: {
                return fMStationInfoCollector.isFirstItemInNewSection();
            }
            case 10: {
                return fMStationInfoCollector.isSelectable();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        AmFmStation amFmStation = fMStationInfoCollector.station;
        switch (n) {
            case 11: {
                return fMStationInfoCollector.getPtyGroupTitleId();
            }
            case 8: {
                if (RadioCodingAdapter.isHongKongVariant()) {
                    return 1;
                }
                return AmfmRDSOption.get() ? amFmStation.getTPState() : 1;
            }
            case 6: {
                if (RadioCodingAdapter.isHongKongVariant()) {
                    return 0;
                }
                return amFmStation.getPtyCode();
            }
            case 1: {
                return amFmStation.getFrequency();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        AmFmStation amFmStation = fMStationInfoCollector.station;
        switch (n) {
            case 4: {
                return amFmStation.getStationName();
            }
            case 7: {
                if (RadioCodingAdapter.isHongKongVariant()) {
                    return "";
                }
                return amFmStation.getRegionalisation();
            }
            case 0: {
                if (fMStationInfoCollector.autocompare > 0) {
                    return String.valueOf(fMStationInfoCollector.autocompare);
                }
                return "";
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        AmFmStation amFmStation = fMStationInfoCollector.station;
        switch (n) {
            case 5: {
                return amFmStation.getUniqueId();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)object;
        switch (n) {
            case 3: {
                return fMStationInfoCollector.imageResourceLocator;
            }
        }
        throw new IllegalArgumentException();
    }
}

