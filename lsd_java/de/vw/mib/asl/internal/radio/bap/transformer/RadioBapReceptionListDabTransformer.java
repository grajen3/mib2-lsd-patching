/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.bap.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.AbstractRadioBapReceptionListDabTransformer;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class RadioBapReceptionListDabTransformer
extends AbstractRadioBapReceptionListDabTransformer {
    private static final int UNKNOWN_STATION_ID;
    private static final int FIRST_PTY_CODE;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EnsembleInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ServiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$FrequencyInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ComponentInfo;

    @Override
    public int getInt(int n, Object object) {
        int n2;
        Class clazz = object.getClass();
        if (clazz == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            n2 = this.getIntDAB(n, ensembleInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            n2 = this.getIntDAB(n, serviceInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo)) {
            FrequencyInfo frequencyInfo = (FrequencyInfo)object;
            n2 = this.getIntDAB(n, frequencyInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            n2 = this.getIntDAB(n, componentInfo);
        } else {
            ServiceManager.logger.error(8, "ASL-stationtype is unknown.");
            n2 = 0;
        }
        return n2;
    }

    @Override
    public long getLong(int n, Object object) {
        long l;
        Class clazz = object.getClass();
        if (clazz == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            l = this.getLongDAB(n, ensembleInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            l = this.getLongDAB(n, serviceInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo)) {
            FrequencyInfo frequencyInfo = (FrequencyInfo)object;
            l = this.getLongDAB(n, frequencyInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            l = this.getLongDAB(n, componentInfo);
        } else {
            ServiceManager.logger.error(8, "ASL-stationtype is unknown.");
            l = 0L;
        }
        return l;
    }

    @Override
    public String getString(int n, Object object) {
        String string;
        Class clazz = object.getClass();
        if (clazz == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            string = this.getStringDAB(n, ensembleInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            string = this.getStringDAB(n, serviceInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$FrequencyInfo == null ? (class$org$dsi$ifc$radio$FrequencyInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.FrequencyInfo")) : class$org$dsi$ifc$radio$FrequencyInfo)) {
            FrequencyInfo frequencyInfo = (FrequencyInfo)object;
            string = this.getStringDAB(n, frequencyInfo);
        } else if (clazz == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = RadioBapReceptionListDabTransformer.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            string = this.getStringDAB(n, componentInfo);
        } else {
            ServiceManager.logger.error(8, "ASL-stationtype is unknown.");
            string = "";
        }
        return string;
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private int getIntDAB(int n, ServiceInfo serviceInfo) {
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
                ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentService();
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
                if (serviceInfo.ptyCodes != null && serviceInfo.ptyCodes.length > 0) {
                    n2 = serviceInfo.ptyCodes[0];
                    break;
                }
                n2 = 0;
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    private String getStringDAB(int n, EnsembleInfo ensembleInfo) {
        String string;
        switch (n) {
            case 6: {
                string = ensembleInfo.fullName;
                break;
            }
            case 7: {
                string = ensembleInfo.shortName;
                break;
            }
            case 8: {
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
            case 6: 
            case 7: {
                string = frequencyInfo.label;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return string;
    }

    private String getStringDAB(int n, ServiceInfo serviceInfo) {
        String string;
        switch (n) {
            case 6: {
                string = serviceInfo.fullName;
                break;
            }
            case 8: {
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
                if (ensembleInfo != null) {
                    string = ensembleInfo.frequencyLabel;
                    break;
                }
                string = "";
                break;
            }
            case 7: {
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
            case 6: {
                string = componentInfo.fullName;
                break;
            }
            case 7: {
                string = componentInfo.shortName;
                break;
            }
            case 8: {
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

    private long getLongDAB(int n, ServiceInfo serviceInfo) {
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

