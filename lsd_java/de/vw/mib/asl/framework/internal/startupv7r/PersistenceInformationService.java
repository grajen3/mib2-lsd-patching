/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;
import java.util.List;

public class PersistenceInformationService {
    private int[] availablePersistenceNamespaces = new int[0];
    private final Logger logger;

    public PersistenceInformationService(Logger logger) {
        this.logger = logger;
    }

    public void extractVariantPersistenceNamespaces(List list) {
        IntArrayList intArrayList = new IntArrayList();
        this.addAllNamespacesToList(list, intArrayList);
        this.availablePersistenceNamespaces = intArrayList.toArray();
        this.logger.info(1, "[PersistenceInformationService] Information about available persistence namespaces processed.");
    }

    public int[] getVariantPersistenceNamespaceIds() {
        return this.availablePersistenceNamespaces;
    }

    private void addAllNamespacesToList(List list, IntArrayList intArrayList) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ContextWorkUnit contextWorkUnit = (ContextWorkUnit)iterator.next();
            int[] nArray = contextWorkUnit.getPersistenceIdsForContext();
            if (nArray == null || nArray.length <= 0) continue;
            this.addToList(nArray, intArrayList);
        }
    }

    private void addToList(int[] nArray, IntArrayList intArrayList) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            intArrayList.add(nArray[i2]);
        }
    }
}

