/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabEnsembleNameComparator;
import de.vw.mib.asl.internal.radio.transformer.DABServiceListItemInfoCollector;
import java.util.Comparator;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabServiceComparator
implements Comparator {
    public static final int SORTING_MODE_ALPHA;
    public static final int SORTING_MODE_SID;
    private int mSortingMode = 0;
    private DabEnsembleNameComparator ensembleComparator = null;
    public static final int SORTING_STRING_IS_SHORT_NAME;
    public static final int SORTING_STRING_IS_FULL_NAME;
    private int sortingString = 1;

    public DabServiceComparator(DabEnsembleNameComparator dabEnsembleNameComparator, int n) {
        this.ensembleComparator = dabEnsembleNameComparator;
        this.sortingString = n;
    }

    @Override
    public int compare(Object object, Object object2) {
        ServiceInfo serviceInfo = null;
        ServiceInfo serviceInfo2 = null;
        if (object instanceof DABServiceListItemInfoCollector) {
            serviceInfo = ((DABServiceListItemInfoCollector)object).getService();
        } else if (object instanceof ServiceInfo) {
            serviceInfo = (ServiceInfo)object;
        }
        if (serviceInfo == null) {
            return -1;
        }
        if (object2 instanceof DABServiceListItemInfoCollector) {
            serviceInfo2 = ((DABServiceListItemInfoCollector)object2).getService();
        } else if (object2 instanceof ServiceInfo) {
            serviceInfo2 = (ServiceInfo)object2;
        }
        if (serviceInfo2 == null) {
            return 1;
        }
        switch (this.mSortingMode) {
            case 1: {
                return this.compareSID(serviceInfo, serviceInfo2);
            }
        }
        return this.compareAlphaNumerical(serviceInfo, serviceInfo2);
    }

    private int compareSID(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
        EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo2.ensID, serviceInfo2.ensECC);
        if (ensembleInfo != null && ensembleInfo2 != null) {
            if (ensembleInfo.frequencyValue > ensembleInfo2.frequencyValue) {
                return 1;
            }
            if (ensembleInfo.frequencyValue < ensembleInfo2.frequencyValue) {
                return -1;
            }
        }
        if (serviceInfo.ensID > serviceInfo2.ensID) {
            return 1;
        }
        if (serviceInfo.ensID < serviceInfo2.ensID) {
            return -1;
        }
        if (serviceInfo.ensECC > serviceInfo2.ensECC) {
            return 1;
        }
        if (serviceInfo.ensECC < serviceInfo2.ensECC) {
            return -1;
        }
        if (serviceInfo.sID > serviceInfo2.sID) {
            return 1;
        }
        if (serviceInfo.sID < serviceInfo2.sID) {
            return -1;
        }
        return serviceInfo.fullName.compareToIgnoreCase(serviceInfo2.fullName);
    }

    private int compareAlphaNumerical(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (null != this.ensembleComparator) {
            int n;
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
            EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo2.ensID, serviceInfo2.ensECC);
            if (ensembleInfo != null && ensembleInfo2 != null && (n = this.ensembleComparator.compare(ensembleInfo, ensembleInfo2)) != 0) {
                return n;
            }
        }
        int n = 0;
        if (1 == this.sortingString) {
            if (null != serviceInfo.fullName && null != serviceInfo2.fullName) {
                n = serviceInfo.fullName.compareToIgnoreCase(serviceInfo2.fullName);
            }
        } else if (null != serviceInfo.shortName && null != serviceInfo2.shortName) {
            n = serviceInfo.shortName.compareToIgnoreCase(serviceInfo2.shortName);
        }
        if (n != 0) {
            return n;
        }
        if (serviceInfo.sID < serviceInfo2.sID) {
            return -1;
        }
        if (serviceInfo.sID > serviceInfo2.sID) {
            return 1;
        }
        return 0;
    }
}

