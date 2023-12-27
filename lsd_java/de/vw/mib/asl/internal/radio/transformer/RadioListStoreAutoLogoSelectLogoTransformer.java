/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioStationLogoSelectionCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioListStoreAutoLogoSelectLogoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioListStoreAutoLogoSelectLogoTransformer
extends AbstractRadioListStoreAutoLogoSelectLogoTransformer
implements ItemTransformer {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 0: {
                return ((RadioStationLogoSelectionCollector)object).logoResourceLocator;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                return ((RadioStationLogoSelectionCollector)object).logoAutoSelected;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 2: {
                return "";
            }
            case 3: {
                return ((RadioStationLogoSelectionCollector)object).stationName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 4: {
                return ((RadioStationLogoSelectionCollector)object).stationFrequency;
            }
        }
        throw new IllegalArgumentException();
    }
}

