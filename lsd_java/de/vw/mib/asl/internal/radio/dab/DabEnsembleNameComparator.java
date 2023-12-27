/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.transformer.DABStationListInfoCollector;
import java.util.Comparator;
import org.dsi.ifc.radio.EnsembleInfo;

public class DabEnsembleNameComparator
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        try {
            EnsembleInfo ensembleInfo = null;
            EnsembleInfo ensembleInfo2 = null;
            if (object instanceof DABStationListInfoCollector) {
                ensembleInfo = ((DABStationListInfoCollector)object).getEnsemble();
            } else if (object instanceof EnsembleInfo) {
                ensembleInfo = (EnsembleInfo)object;
            }
            if (ensembleInfo == null) {
                return -1;
            }
            if (object2 instanceof DABStationListInfoCollector) {
                ensembleInfo2 = ((DABStationListInfoCollector)object2).getEnsemble();
            } else if (object2 instanceof EnsembleInfo) {
                ensembleInfo2 = (EnsembleInfo)object2;
            }
            if (ensembleInfo2 == null) {
                return 1;
            }
            if (null != ensembleInfo.fullName && null != ensembleInfo2.fullName && ensembleInfo.fullName.length() > 0 && ensembleInfo2.fullName.length() > 0) {
                int n = ensembleInfo.fullName.compareToIgnoreCase(ensembleInfo2.fullName);
                if (0 != n) {
                    return n;
                }
                return this.doOtherComparisons(ensembleInfo, ensembleInfo2);
            }
            if (null != ensembleInfo.fullName && ensembleInfo.fullName.length() > 0 && (null == ensembleInfo2.fullName || ensembleInfo2.fullName.length() <= 0)) {
                return -1;
            }
            if ((null == ensembleInfo.fullName || ensembleInfo.fullName.length() <= 0) && null != ensembleInfo2.fullName && ensembleInfo2.fullName.length() > 0) {
                return 1;
            }
            return this.doOtherComparisons(ensembleInfo, ensembleInfo2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return 0;
        }
    }

    private int doOtherComparisons(EnsembleInfo ensembleInfo, EnsembleInfo ensembleInfo2) {
        try {
            if (ensembleInfo.frequencyValue > ensembleInfo2.frequencyValue) {
                return 1;
            }
            if (ensembleInfo.frequencyValue < ensembleInfo2.frequencyValue) {
                return -1;
            }
            if (ensembleInfo.ensID > ensembleInfo2.ensID) {
                return 1;
            }
            if (ensembleInfo.ensID < ensembleInfo2.ensID) {
                return -1;
            }
            if (ensembleInfo.ensECC > ensembleInfo2.ensECC) {
                return 1;
            }
            if (ensembleInfo.ensECC < ensembleInfo2.ensECC) {
                return -1;
            }
            return 0;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return 0;
        }
    }
}

