/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.transformer.DabPresetListInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioDABPresetListInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioDABPresetListInfoTransformer
extends AbstractRadioDABPresetListInfoTransformer {
    static final int INVALID_LONG_ATTRIBUTE;

    @Override
    public boolean getBoolean(int n, Object object) {
        DabPresetListInfoCollector dabPresetListInfoCollector = (DabPresetListInfoCollector)object;
        switch (n) {
            case 1: {
                return dabPresetListInfoCollector.mIsServiceStored;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        DabPresetListInfoCollector dabPresetListInfoCollector = (DabPresetListInfoCollector)object;
        switch (n) {
            case 0: {
                return dabPresetListInfoCollector.mAttributes;
            }
            case 7: {
                if (RadioDataApi.isDrawStationLogoActivated()) {
                    return dabPresetListInfoCollector.mAutoStoreState;
                }
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        DabPresetListInfoCollector dabPresetListInfoCollector = (DabPresetListInfoCollector)object;
        switch (n) {
            case 5: {
                return dabPresetListInfoCollector.mPresetName;
            }
            case 6: {
                return "";
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 4: {
                return 0L;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        DabPresetListInfoCollector dabPresetListInfoCollector = (DabPresetListInfoCollector)object;
        switch (n) {
            case 2: {
                if (RadioDataApi.isDrawStationLogoActivated()) {
                    return dabPresetListInfoCollector.mResource;
                }
                return null;
            }
        }
        throw new IllegalArgumentException();
    }
}

