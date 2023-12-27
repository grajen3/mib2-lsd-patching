/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.api.startupv7r.DSIInfo;
import de.vw.mib.asl.framework.internal.startupv7r.ContextInfo;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DsiInformationService {
    private final Logger logger;
    private final ContextInfo contextInfo;
    private String[] availableDsiNames = new String[0];

    public DsiInformationService(Logger logger, ContextInfo contextInfo) {
        this.logger = logger;
        this.contextInfo = contextInfo;
    }

    public String[] getVariantDsiNames() {
        return this.availableDsiNames;
    }

    public void extractVariantDsiNames(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ContextWorkUnit contextWorkUnit = (ContextWorkUnit)iterator.next();
            int[] nArray = contextWorkUnit.getDsiInterfacesToStart();
            this.addDsisToList(nArray, arrayList);
        }
        this.writeClassNamesToArray(arrayList);
        this.logger.info(1, "[DsiInformationService] Information about available DSI processed.");
    }

    private void writeClassNamesToArray(List list) {
        this.availableDsiNames = new String[list.size()];
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.availableDsiNames[n++] = (String)iterator.next();
        }
    }

    private void addDsisToList(int[] nArray, ArrayList arrayList) {
        int[] nArray2 = this.contextInfo.filterForAllowedDsis(nArray, false);
        DSIInfo[] dSIInfoArray = this.contextInfo.getDSIInfoBeforeStart(nArray2, false);
        if (dSIInfoArray == null || dSIInfoArray.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < dSIInfoArray.length; ++i2) {
            DSIInfo dSIInfo = dSIInfoArray[i2];
            arrayList.add(dSIInfo.interfaceName);
        }
    }
}

