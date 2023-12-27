/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.bap.transformer;

import de.vw.mib.asl.api.tvtuner.ASLTvtunerFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioItem;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.AbstractRadioBapReceptionListTransformer;
import java.util.Collection;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class RadioBapReceptionListTransformer
extends AbstractRadioBapReceptionListTransformer {
    private static final int UNKNOWN_STATION_ID;
    private static final int FIRST_PTY_CODE;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EnsembleInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ServiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$FrequencyInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ComponentInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$ServiceInfo;

    @Override
    public int getInt(int n, Object object) {
        int n2;
        Class clazz = object.getClass();
        if (clazz == (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation == null ? (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation = RadioBapReceptionListTransformer.class$("de.vw.mib.asl.internal.radio.amfm.common.AmFmStation")) : class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation)) {
            RadioItem radioItem = (RadioItem)object;
            switch (radioItem.type()) {
                case 4: 
                case 5: {
                    AmFmStation amFmStation = (AmFmStation)object;
                    n2 = this.getIntFMAM(n, amFmStation);
                    break;
                }
                default: {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("ASL-Radio-Stationtype is unknown").log();
                    }
                    n2 = 0;
                    break;
                }
            }
        } else if (object instanceof AmFmStationInfoCollector) {
            AmFmStationInfoCollector amFmStationInfoCollector = (AmFmStationInfoCollector)object;
            n2 = this.getIntFMAM(n, amFmStationInfoCollector.station);
        } else if (clazz == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            n2 = this.getIntDAB(n, ensembleInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            org.dsi.ifc.radio.ServiceInfo serviceInfo = (org.dsi.ifc.radio.ServiceInfo)object;
            n2 = this.getIntDAB(n, serviceInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo)) {
            FrequencyInfo frequencyInfo = (FrequencyInfo)object;
            n2 = this.getIntDAB(n, frequencyInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            n2 = this.getIntDAB(n, componentInfo);
        } else if (object instanceof StationInfo) {
            StationInfo stationInfo = (StationInfo)object;
            n2 = this.getIntSDARS(n, stationInfo);
        } else if (clazz == (class$org$dsi$ifc$tvtuner$ServiceInfo == null ? (class$org$dsi$ifc$tvtuner$ServiceInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.tvtuner.ServiceInfo")) : class$org$dsi$ifc$tvtuner$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            n2 = this.getIntTv(n, serviceInfo);
        } else {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("ASL-Radio-Stationtype is unknown").log();
            }
            n2 = 0;
        }
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        String string;
        Class clazz = object.getClass();
        if (clazz == (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation == null ? (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation = RadioBapReceptionListTransformer.class$("de.vw.mib.asl.internal.radio.amfm.common.AmFmStation")) : class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation)) {
            RadioItem radioItem = (RadioItem)object;
            switch (radioItem.type()) {
                case 4: 
                case 5: {
                    AmFmStation amFmStation = (AmFmStation)object;
                    string = this.getStringFMAM(n, amFmStation);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
                }
            }
        } else if (object instanceof AmFmStationInfoCollector) {
            AmFmStationInfoCollector amFmStationInfoCollector = (AmFmStationInfoCollector)object;
            string = this.getStringFMAM(n, amFmStationInfoCollector.station);
        } else if (clazz == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            string = this.getStringDAB(n, ensembleInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            org.dsi.ifc.radio.ServiceInfo serviceInfo = (org.dsi.ifc.radio.ServiceInfo)object;
            string = this.getStringDAB(n, serviceInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo)) {
            FrequencyInfo frequencyInfo = (FrequencyInfo)object;
            string = this.getStringDAB(n, frequencyInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            string = this.getStringDAB(n, componentInfo);
        } else if (object instanceof StationInfo) {
            StationInfo stationInfo = (StationInfo)object;
            string = this.getStringSDARS(n, stationInfo);
        } else if (clazz == (class$org$dsi$ifc$tvtuner$ServiceInfo == null ? (class$org$dsi$ifc$tvtuner$ServiceInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.tvtuner.ServiceInfo")) : class$org$dsi$ifc$tvtuner$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            string = this.getStringTv(n, serviceInfo);
        } else {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("ASL-Radio-Stationtype is unknown").log();
            }
            string = "";
        }
        return string;
    }

    @Override
    public long getLong(int n, Object object) {
        long l;
        Class clazz = object.getClass();
        if (clazz == (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation == null ? (class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation = RadioBapReceptionListTransformer.class$("de.vw.mib.asl.internal.radio.amfm.common.AmFmStation")) : class$de$vw$mib$asl$internal$radio$amfm$common$AmFmStation)) {
            RadioItem radioItem = (RadioItem)object;
            switch (radioItem.type()) {
                case 4: 
                case 5: {
                    AmFmStation amFmStation = (AmFmStation)object;
                    l = this.getLongFMAM(n, amFmStation);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
                }
            }
        } else if (object instanceof AmFmStationInfoCollector) {
            AmFmStationInfoCollector amFmStationInfoCollector = (AmFmStationInfoCollector)object;
            l = this.getLongFMAM(n, amFmStationInfoCollector.station);
        } else if (clazz == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            l = this.getLongDAB(n, ensembleInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            org.dsi.ifc.radio.ServiceInfo serviceInfo = (org.dsi.ifc.radio.ServiceInfo)object;
            l = this.getLongDAB(n, serviceInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo)) {
            FrequencyInfo frequencyInfo = (FrequencyInfo)object;
            l = this.getLongDAB(n, frequencyInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            l = this.getLongDAB(n, componentInfo);
        } else if (object instanceof StationInfo) {
            StationInfo stationInfo = (StationInfo)object;
            l = this.getLongSDARS(n, stationInfo);
        } else if (clazz == (class$org$dsi$ifc$tvtuner$ServiceInfo == null ? (class$org$dsi$ifc$tvtuner$ServiceInfo = RadioBapReceptionListTransformer.class$("org.dsi.ifc.tvtuner.ServiceInfo")) : class$org$dsi$ifc$tvtuner$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            l = this.getLongTv(n, serviceInfo);
        } else {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_BAP).append("ASL-Radio-Stationtype is unknown").log();
            }
            l = 0L;
        }
        return l;
    }

    private int getIntDAB(int n, FrequencyInfo frequencyInfo) {
        switch (n) {
            case 2: {
                return 0;
            }
            case 3: {
                return 0;
            }
            case 4: {
                return -1;
            }
            case 5: {
                return 0;
            }
            case 6: {
                return 0;
            }
            case 9: {
                return 0;
            }
            case 11: {
                return -1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private int getIntDAB(int n, EnsembleInfo ensembleInfo) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                int n3 = ensembleInfo.tp ? 32 : 0;
                n2 = n3 |= ensembleInfo.potentiallyReceivable ? 1 : 0;
                break;
            }
            case 4: {
                n2 = -1;
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: {
                n2 = 0;
                break;
            }
            case 9: {
                n2 = 0;
                break;
            }
            case 11: {
                n2 = -1;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private int getIntDAB(int n, org.dsi.ifc.radio.ServiceInfo serviceInfo) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                int n3 = 1;
                n3 |= serviceInfo.tp ? 32 : 0;
                n3 |= RadioData.getDabDatabase().mTunerState.hasComponents(serviceInfo) ? 4 : 0;
                org.dsi.ifc.radio.ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (DabTunerState.compare(serviceInfo2, serviceInfo)) {
                    n3 |= !RadioData.getDabDatabase().mTunerState.isServiceMuted() ? 1 : 0;
                    n3 |= RadioData.getDabDatabase().mTunerState.isFmLinkingActive() ? 16 : 0;
                }
                n2 = n3;
                break;
            }
            case 4: {
                n2 = RadioData.getDabDatabase().dabPresetList.autocompareNew(null, serviceInfo, false);
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: {
                if (serviceInfo.ptyCodes != null && serviceInfo.ptyCodes.length > 0) {
                    n2 = serviceInfo.ptyCodes[0];
                    break;
                }
                n2 = 0;
                break;
            }
            case 9: {
                n2 = 0;
                break;
            }
            case 11: {
                n2 = -1;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    public int getIntDAB(int n, ComponentInfo componentInfo) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                int n3;
                n2 = n3 = 1;
                break;
            }
            case 4: {
                n2 = -1;
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: {
                n2 = 0;
                break;
            }
            case 9: {
                n2 = 0;
                break;
            }
            case 11: {
                n2 = -1;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private String getStringDAB(int n, EnsembleInfo ensembleInfo) {
        String string;
        switch (n) {
            case 7: {
                string = ensembleInfo.fullName;
                break;
            }
            case 8: {
                string = ensembleInfo.shortName;
                break;
            }
            case 10: {
                string = ensembleInfo.frequencyLabel;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private String getStringDAB(int n, FrequencyInfo frequencyInfo) {
        String string;
        switch (n) {
            case 7: 
            case 8: {
                string = frequencyInfo.label;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private String getStringDAB(int n, org.dsi.ifc.radio.ServiceInfo serviceInfo) {
        String string;
        switch (n) {
            case 7: {
                string = serviceInfo.fullName;
                break;
            }
            case 10: {
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
                if (ensembleInfo != null) {
                    string = ensembleInfo.frequencyLabel;
                    break;
                }
                string = "";
                break;
            }
            case 8: {
                string = serviceInfo.shortName;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private String getStringDAB(int n, ComponentInfo componentInfo) {
        String string;
        switch (n) {
            case 7: {
                string = componentInfo.fullName;
                break;
            }
            case 8: {
                string = componentInfo.shortName;
                break;
            }
            case 10: {
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(componentInfo.ensID, componentInfo.ensECC);
                if (ensembleInfo != null) {
                    string = ensembleInfo.frequencyLabel;
                    break;
                }
                string = "";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private int getIntFMAM(int n, AmFmStation amFmStation) {
        int n2;
        switch (n) {
            case 2: {
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
            case 3: {
                int n3 = amFmStation.isTp() ? 32 : 0;
                n3 |= amFmStation.isTmc() ? 64 : 0;
                n2 = n3 |= 1;
                break;
            }
            case 4: {
                n2 = -1;
                AmFmPreset amFmPreset = amFmStation.type() == 5 ? AmFmPresetApi.getPreset(1, amFmStation) : AmFmPresetApi.getPreset(0, amFmStation);
                if (amFmPreset == null) break;
                n2 = amFmPreset.getIndex();
                break;
            }
            case 5: {
                n2 = amFmStation.calcRegonalisationIntForBap();
                break;
            }
            case 6: {
                n2 = amFmStation.getPtyCode();
                break;
            }
            case 9: {
                n2 = amFmStation.getFrequency();
                break;
            }
            case 11: {
                if (amFmStation.isHD()) {
                    if (amFmStation.type() == 5 && (RadioData.getAmfmDatabase().hasSubServiceList(amFmStation) || amFmStation.getSubChannelCount() > 0 || amFmStation.getServiceId() > 1)) {
                        n2 = amFmStation.getSubChannel();
                        break;
                    }
                    n2 = 0;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private String getStringFMAM(int n, AmFmStation amFmStation) {
        String string;
        switch (n) {
            case 7: {
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
            case 10: {
                string = "";
                break;
            }
            case 8: {
                string = amFmStation.getShortNameHD();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    public static Object[] computeReceptionListElementsForFMAM(Collection collection) {
        return collection.toArray();
    }

    private long getLongDAB(int n, FrequencyInfo frequencyInfo) {
        long l;
        switch (n) {
            case 0: {
                l = 0L;
                break;
            }
            case 1: {
                l = 0L;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    private long getLongDAB(int n, EnsembleInfo ensembleInfo) {
        long l;
        switch (n) {
            case 0: {
                l = DabTunerState.calcEnsembleId(ensembleInfo.ensID, ensembleInfo.ensECC);
                break;
            }
            case 1: {
                l = 0L;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    public long getLongDAB(int n, ComponentInfo componentInfo) {
        long l;
        switch (n) {
            case 0: {
                l = DabTunerState.calcComponentId(componentInfo.sCIDI, componentInfo.sID, componentInfo.ensECC, componentInfo.ensID);
                break;
            }
            case 1: {
                l = DabTunerState.calcServiceId(componentInfo.ensID, componentInfo.ensECC, componentInfo.sID);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    private long getLongDAB(int n, org.dsi.ifc.radio.ServiceInfo serviceInfo) {
        long l;
        switch (n) {
            case 0: {
                l = DabTunerState.calcServiceId(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID);
                break;
            }
            case 1: {
                l = DabTunerState.calcEnsembleId(serviceInfo.ensID, serviceInfo.ensECC);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    public long getLongFMAM(int n, AmFmStation amFmStation) {
        long l;
        switch (n) {
            case 0: {
                l = RadioUtil.computeUniqueID(amFmStation);
                break;
            }
            case 1: {
                l = 0L;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    private int getIntSDARS(int n, StationInfo stationInfo) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 8;
                break;
            }
            case 3: {
                int n3 = stationInfo.getSubscription() == 2 ? 128 : 0;
                n2 = n3 |= 1;
                break;
            }
            case 4: {
                n2 = SatDb.getInstance().getPresetApi().findStation(stationInfo);
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: {
                n2 = 0;
                break;
            }
            case 9: {
                n2 = stationInfo.getStationNumber();
                break;
            }
            case 11: {
                n2 = stationInfo.getCategoryNumber();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private String getStringSDARS(int n, StationInfo stationInfo) {
        String string;
        switch (n) {
            case 7: {
                string = stationInfo.getFullLabel();
                break;
            }
            case 10: {
                string = "";
                break;
            }
            case 8: {
                string = stationInfo.getShortLabel();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private long getLongSDARS(int n, StationInfo stationInfo) {
        long l;
        switch (n) {
            case 0: {
                l = stationInfo.getSID();
                break;
            }
            case 1: {
                l = 0L;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
    }

    private int getIntTv(int n, ServiceInfo serviceInfo) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 7;
                break;
            }
            case 3: {
                int n3 = 0;
                n3 |= 1;
                n2 = n3 |= 2;
                break;
            }
            case 4: {
                n2 = ASLTvtunerFactory.getTvtunerApi().getPresetPosition(serviceInfo);
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: {
                n2 = 0;
                break;
            }
            case 9: {
                n2 = serviceInfo.getServicePID();
                break;
            }
            case 11: {
                n2 = -1;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private String getStringTv(int n, ServiceInfo serviceInfo) {
        String string;
        switch (n) {
            case 7: {
                string = serviceInfo.getName();
                break;
            }
            case 10: {
                string = "";
                break;
            }
            case 8: {
                string = serviceInfo.getName();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private long getLongTv(int n, ServiceInfo serviceInfo) {
        long l;
        switch (n) {
            case 0: {
                l = serviceInfo.getNamePID();
                break;
            }
            case 1: {
                l = serviceInfo.getNamePID() + (long)serviceInfo.getServicePID();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return l;
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

