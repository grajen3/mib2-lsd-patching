/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATSATPresetListInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public class RadioSATSATPresetListInfoTransformer
extends AbstractRadioSATSATPresetListInfoTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = "";
        if (object != null) {
            StationInfo stationInfo = (StationInfo)object;
            switch (n) {
                case 3: {
                    string = stationInfo.shortLabel;
                    break;
                }
            }
        }
        return string;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        if (object != null) {
            StationInfo stationInfo = (StationInfo)object;
            switch (n) {
                case 1: {
                    bl = stationInfo.subscription == 2;
                    break;
                }
                case 5: {
                    ResourceLocator resourceLocator = SatDb.getInstance().getImageDb().getImage(stationInfo.getSID());
                    bl = resourceLocator != null;
                    break;
                }
                case 2: {
                    bl = true;
                    break;
                }
            }
        }
        return bl;
    }

    @Override
    public long getLong(int n, Object object) {
        long l = 0L;
        if (object != null) {
            StationInfo stationInfo = (StationInfo)object;
            switch (n) {
                case 4: {
                    l = stationInfo.stationNumber;
                    break;
                }
            }
        }
        return l;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = null;
        if (object != null) {
            StationInfo stationInfo = (StationInfo)object;
            switch (n) {
                case 0: {
                    resourceLocator = SatDb.getInstance().getImageDb().getImage(stationInfo.getSID());
                    break;
                }
            }
        }
        return resourceLocator;
    }
}

