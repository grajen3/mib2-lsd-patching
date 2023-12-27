/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.bap.transformer;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.AbstractRadioBapReceptionListSdarsTransformer;
import org.dsi.ifc.sdars.StationInfo;

public class RadioBapReceptionListSdarsTransformer
extends AbstractRadioBapReceptionListSdarsTransformer {
    @Override
    public int getInt(int n, Object object) {
        int n2;
        StationInfo stationInfo = (StationInfo)object;
        switch (n) {
            case 1: {
                n2 = 8;
                break;
            }
            case 2: {
                int n3 = stationInfo.getSubscription() == 2 ? 128 : 0;
                n2 = n3 |= 1;
                break;
            }
            case 3: {
                n2 = SatDb.getInstance().getPresetApi().findStation(stationInfo);
                break;
            }
            case 7: {
                n2 = stationInfo.stationNumber;
                break;
            }
            case 4: {
                n2 = stationInfo.getCategoryNumber();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    @Override
    public long getLong(int n, Object object) {
        long l;
        StationInfo stationInfo = (StationInfo)object;
        switch (n) {
            case 0: {
                l = stationInfo.getSID();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    @Override
    public String getString(int n, Object object) {
        String string;
        StationInfo stationInfo = (StationInfo)object;
        switch (n) {
            case 5: {
                string = stationInfo.getFullLabel();
                break;
            }
            case 6: {
                string = stationInfo.getShortLabel();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }
}

