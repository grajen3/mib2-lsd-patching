/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sdars.categories.CategoryHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.ImageDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetApi;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATCategoryListSubItemInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public class RadioSATCategoryListSubItemInfoTransformer
extends AbstractRadioSATCategoryListSubItemInfoTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        if (object != null) {
            StationInfo stationInfo = (StationInfo)object;
            switch (n) {
                case 1: {
                    ImageDb imageDb;
                    SatDb satDb = SatDb.getInstance();
                    if (satDb == null || (imageDb = satDb.getImageDb()) == null) break;
                    ResourceLocator resourceLocator = imageDb.getImage(stationInfo.sID);
                    bl = resourceLocator != null;
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
                case 6: {
                    l = stationInfo.getSID();
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
                case 2: {
                    ImageDb imageDb;
                    SatDb satDb = SatDb.getInstance();
                    if (satDb == null || (imageDb = satDb.getImageDb()) == null) break;
                    resourceLocator = imageDb.getImage(stationInfo.sID);
                    break;
                }
            }
        }
        return resourceLocator;
    }

    @Override
    public String getString(int n, Object object) {
        String string = "";
        if (object != null) {
            StationInfo stationInfo = (StationInfo)object;
            switch (n) {
                case 0: {
                    SatPresetApi satPresetApi;
                    SatDb satDb = SatDb.getInstance();
                    if (satDb == null || (satPresetApi = satDb.getPresetApi()) == null) break;
                    int n2 = satPresetApi.findStation(stationInfo);
                    string = n2 == -1 ? "" : Integer.toString(n2);
                    break;
                }
                case 3: {
                    string = stationInfo.getFullLabel();
                    break;
                }
                case 4: {
                    string = stationInfo.getShortLabel();
                    break;
                }
                case 5: {
                    CategoryHandler categoryHandler;
                    short s = stationInfo.getCategoryNumber();
                    SatDb satDb = SatDb.getInstance();
                    if (satDb == null || (categoryHandler = satDb.getCategories()) == null) break;
                    string = categoryHandler.getLabel(s);
                    break;
                }
                case 7: {
                    short s = stationInfo.getStationNumber();
                    string = Integer.toString(s);
                    break;
                }
            }
        }
        return string;
    }
}

