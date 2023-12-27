/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataProvider;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.list.impl.HMIListImpl;
import java.util.HashMap;
import java.util.Map;

class HMIListRegistryImpl
implements HMIListRegistry {
    private final Map lists = new HashMap();

    HMIListRegistryImpl() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public HMIList getHMIList(Object object) {
        Map map = this.lists;
        synchronized (map) {
            return this.accessHMIList(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setHMIListDataProvider(Object object, HMIListDataProvider hMIListDataProvider) {
        Map map = this.lists;
        synchronized (map) {
            HMIListImpl hMIListImpl = this.accessHMIList(object);
            hMIListImpl.setDataProvider(hMIListDataProvider);
        }
    }

    private HMIListImpl accessHMIList(Object object) {
        HMIListImpl hMIListImpl = (HMIListImpl)this.lists.get(object);
        if (null == hMIListImpl) {
            hMIListImpl = new HMIListImpl(object);
            this.lists.put(object, hMIListImpl);
        }
        return hMIListImpl;
    }
}

