/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATChanneFilterChannelListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public class RadioSATChanneFilterChannelListTransformer
extends AbstractRadioSATChanneFilterChannelListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl;
        StationInfo stationInfo = (StationInfo)object;
        switch (n) {
            case 2: {
                bl = SatDb.getInstance().getImageDb().getImage(stationInfo.sID) != null;
                break;
            }
            case 0: {
                bl = SatDb.getInstance().getFilterListApi().isChannelSelected(stationInfo.stationNumber);
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public String getString(int n, Object object) {
        String string;
        StationInfo stationInfo = (StationInfo)object;
        switch (n) {
            case 5: {
                string = "";
                break;
            }
            case 1: {
                string = stationInfo.fullLabel;
                break;
            }
            case 4: {
                string = Integer.toString(stationInfo.stationNumber);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator;
        StationInfo stationInfo = (StationInfo)object;
        switch (n) {
            case 3: {
                resourceLocator = SatDb.getInstance().getImageDb().getImage(stationInfo.sID);
                break;
            }
            default: {
                resourceLocator = null;
            }
        }
        return resourceLocator;
    }
}

