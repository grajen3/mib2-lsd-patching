/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.transformer.AMPresetListInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioAMPresetListInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioAMPresetListInfoTransformer
extends AbstractRadioAMPresetListInfoTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 7: {
                return ((AMPresetListInfoCollector)object).name;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 6: {
                return ((AMPresetListInfoCollector)object).isElemtStored;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 8: {
                return ((AMPresetListInfoCollector)object).storedLogoState;
            }
            case 0: {
                return ((AMPresetListInfoCollector)object).frequency;
            }
            case 2: {
                return ((AMPresetListInfoCollector)object).hdStationNumber;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 4: {
                return ((AMPresetListInfoCollector)object).iDLong;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 3: {
                return ((AMPresetListInfoCollector)object).imageResoureLocator;
            }
        }
        throw new IllegalArgumentException();
    }
}

