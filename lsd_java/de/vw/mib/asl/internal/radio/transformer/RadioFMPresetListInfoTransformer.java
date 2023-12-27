/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.transformer.FMPresetListInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioFMPresetListInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioFMPresetListInfoTransformer
extends AbstractRadioFMPresetListInfoTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 4: {
                return ((FMPresetListInfoCollector)object).isElementStored;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((FMPresetListInfoCollector)object).attributes;
            }
            case 1: {
                return ((FMPresetListInfoCollector)object).frequency;
            }
            case 3: {
                return ((FMPresetListInfoCollector)object).hdStationNumber;
            }
            case 10: {
                if (RadioDataApi.isDrawStationLogoActivated()) {
                    return ((FMPresetListInfoCollector)object).storedLogoState;
                }
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 8: {
                return ((FMPresetListInfoCollector)object).name;
            }
            case 9: {
                return "";
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 5: {
                return ((FMPresetListInfoCollector)object).idLong;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 6: {
                if (RadioDataApi.isDrawStationLogoActivated()) {
                    return ((FMPresetListInfoCollector)object).imageResourceLocator;
                }
                return null;
            }
        }
        throw new IllegalArgumentException();
    }
}

