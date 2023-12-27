/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.bap.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.AbstractRadioBapReceptionListAmTransformer;

public class RadioBapReceptionListAmTransformer
extends AbstractRadioBapReceptionListAmTransformer {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation;

    @Override
    public int getInt(int n, Object object) {
        int n2 = -1;
        Class clazz = object.getClass();
        if (clazz == (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation == null ? (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation = RadioBapReceptionListAmTransformer.class$("de.vw.mib.asl.internal.radio.amfm.common.AmFmStation")) : class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation)) {
            AmFmStation amFmStation = (AmFmStation)object;
            n2 = this.getIntAM(n, amFmStation);
        } else if (object instanceof AmFmStationInfoCollector) {
            AmFmStationInfoCollector amFmStationInfoCollector = (AmFmStationInfoCollector)object;
            n2 = this.getIntAM(n, amFmStationInfoCollector.station);
        }
        return n2;
    }

    private int getIntAM(int n, AmFmStation amFmStation) {
        int n2;
        switch (n) {
            case 1: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    if (amFmStation.isSubService()) {
                        n2 = 6;
                        break;
                    }
                    n2 = 5;
                    break;
                }
                n2 = 1;
                break;
            }
            case 2: {
                int n3 = amFmStation.isTp() ? 32 : 0;
                n3 |= amFmStation.isTmc() ? 64 : 0;
                n2 = n3 |= 1;
                break;
            }
            case 3: {
                n2 = -1;
                AmFmPreset amFmPreset = amFmStation.type() == 5 ? AmFmPresetApi.getPreset(1, amFmStation) : AmFmPresetApi.getPreset(0, amFmStation);
                if (amFmPreset == null) break;
                n2 = amFmPreset.getIndex();
                break;
            }
            case 4: {
                n2 = amFmStation.calcRegonalisationIntForBap();
                break;
            }
            case 5: {
                n2 = amFmStation.getPtyCode();
                break;
            }
            case 8: {
                n2 = amFmStation.getFrequency();
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
        long l = -1L;
        Class clazz = object.getClass();
        if (clazz == (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation == null ? (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation = RadioBapReceptionListAmTransformer.class$("de.vw.mib.asl.internal.radio.amfm.common.AmFmStation")) : class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation)) {
            AmFmStation amFmStation = (AmFmStation)object;
            l = this.getLongAM(n, amFmStation);
        } else if (object instanceof AmFmStationInfoCollector) {
            AmFmStationInfoCollector amFmStationInfoCollector = (AmFmStationInfoCollector)object;
            l = this.getLongAM(n, amFmStationInfoCollector.station);
        }
        return l;
    }

    public long getLongAM(int n, AmFmStation amFmStation) {
        long l;
        switch (n) {
            case 0: {
                l = RadioUtil.computeUniqueID(amFmStation);
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
        String string = null;
        Class clazz = object.getClass();
        if (clazz == (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation == null ? (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation = RadioBapReceptionListAmTransformer.class$("de.vw.mib.asl.internal.radio.amfm.common.AmFmStation")) : class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation)) {
            AmFmStation amFmStation = (AmFmStation)object;
            string = this.getStringAM(n, amFmStation);
        } else if (object instanceof AmFmStationInfoCollector) {
            AmFmStationInfoCollector amFmStationInfoCollector = (AmFmStationInfoCollector)object;
            string = this.getStringAM(n, amFmStationInfoCollector.station);
        }
        return string;
    }

    private String getStringAM(int n, AmFmStation amFmStation) {
        String string;
        switch (n) {
            case 6: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    if (amFmStation.isHD()) {
                        string = amFmStation.getShortNameHD();
                        break;
                    }
                    string = amFmStation.getName();
                    break;
                }
                string = amFmStation.getRealName();
                break;
            }
            case 7: {
                string = amFmStation.getShortNameHD();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

